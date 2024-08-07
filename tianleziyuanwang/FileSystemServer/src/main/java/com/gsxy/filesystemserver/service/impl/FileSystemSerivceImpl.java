package com.gsxy.filesystemserver.service.impl;

import cn.hutool.core.lang.hash.Hash;
import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.DownloadFile;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.FilePagingToGetDataBo;
import com.gsxy.filesystemserver.domain.bo.FileUpdateBo;
import com.gsxy.filesystemserver.domain.vo.FilePagingToData;
import com.gsxy.filesystemserver.domain.vo.FilePagingToGetDataVo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.FileMapper;
import com.gsxy.filesystemserver.service.FileSystemSerivce;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import java.util.UUID;

@Service
public class FileSystemSerivceImpl implements FileSystemSerivce {
    @Value("${filePath}")
    private String path;
    @Value("${projecturl}")
    private String projecturl;

    @Autowired
    private  FileMapper fileMapper;

    /**
     * @author hln 2024-03-12
     * 文件修改
     * @param fileUpdateBo
     */
    @Override
    public ResponseVo updateFile(FileUpdateBo fileUpdateBo) {
        String userIdStr = String.valueOf(ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id"));
        Long userId = Long.valueOf(userIdStr);
        fileUpdateBo.setCreateBy(userId);

        String fileType = fileMapper.selectFileTypeById(fileUpdateBo.getId());
        String updateFileName = fileUpdateBo.getUpdateFileName();

        String[] split = updateFileName.split("\\.");

        if(split.length > 1) {
            fileUpdateBo.setUpdateFileName(updateFileName);
//            fileUpdateBo.setFileType("." + split[1]);
        } else {
            fileUpdateBo.setUpdateFileName(updateFileName + "" + fileType);
        }

        int i = fileMapper.updateFile(fileUpdateBo);

        if(i != 1) {
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",null,"0x200");
    }


    /**
     * 文件下载
     */
    @Override
    public byte[] getFile(String imgUrl) throws IOException{

        File file = new File(path+"/"+imgUrl);
        System.err.println(file.getPath());
        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];

        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }



    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    @Override
    public String imgUpDown(MultipartFile file,Long channelId) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();

        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        //为了避免发生图片替换，这里使用了文件名重新生成
        String newFileName = UUID.randomUUID()+suffixName;

        //获取创建人的id
        String userId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");

        File saveFilePath = new File(path+"/"+userId+"/");
        //判断是否存在文件夹，不存在就创建，但其实可以直接手动确定创建好，这样不用每次保存都检测
        if (!saveFilePath.exists()){
            System.out.println("文件创建");
            System.out.println(saveFilePath.mkdirs());
        }


        //保存文件到指定路径下
        file.transferTo(new File(saveFilePath.getCanonicalPath() +"/" + newFileName));

        FileUploads fileUploads = new FileUploads(newFileName, fileName, suffixName, 0, (userId + "/" + newFileName), Long.valueOf(userId), new Date(), Long.valueOf(userId), new Date(), 0, 0);
        //将文件信息插入数据库
        fileMapper.add(fileUploads);


        return JSONArray.toJSONString(new ResponseVo<>("success",fileUploads,"0x200"));
    }




    /**
     * 分页查询
     * @param fileUploads
     * @return
     */
    @Override
    public ResponseVo FilePagingToGetData(FilePagingToGetDataBo fileUploads) {
        String userId = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        fileUploads.getFileUploads().setCreateBy(Long.valueOf(userId));

        List<FilePagingToData> fileList = fileMapper.filePagingToGetUserData(fileUploads.getStart(),fileUploads.getSize(),fileUploads.getFileUploads());
        Long count = fileMapper.getCount(fileUploads.getFileUploads());
        System.out.println(count);

        HashMap<String,Object> map = new HashMap<>();
        map.put("count",count);
        map.put("list",fileList);

        return new ResponseVo("查询成功",new FilePagingToGetDataVo(fileList,Math.toIntExact(count)),"0x200");
    }

    /**
     *
     * 删除文件
     * @param id
     * @return
     */
    @Override
    public ResponseVo FileDelete(Long id){
        Long aLong = fileMapper.fileDelete(id);
        if (aLong == null || aLong.longValue() <= 0L) {
            return new ResponseVo("删除失败",null,"0x500");
        }

        //记录删除操作日志
        DeleteLog deleteLog = new DeleteLog();

        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);

        deleteLog.setDeleteBy(userId);
        deleteLog.setDeleteTime(new Date());
        deleteLog.setTableName("file_uploads");
        String fileName = fileMapper.selectFileNameById(id);
        deleteLog.setFileName(fileName);

        fileMapper.insertIntoDelteLog(deleteLog);

        return new ResponseVo("删除成功",aLong,"0x200");
    }

    /**
     * @author hln 2024-4-1
     *  文件批量删除
     */
    @Override
    public ResponseVo deleteList(List<Long> list) {

        list.stream().forEach(id -> fileMapper.deleteCarouselFile(id));

        return new ResponseVo("删除成功",null,"0x200");
    }


    /**
     * 获取不是自己公开的文件
     * @return
     */
    @Override
    public ResponseVo queryPublicFileWithoutMyself(Long start, Integer size){
        String userIdStr = (String) ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id");
        Long userId = Long.valueOf(userIdStr);
        Long count = fileMapper.queryPublicFileWithoutMyselfCoung(start,size,userId);
        List<FileUploads> fileUploads = fileMapper.queryPublicFileWithoutMyself(start, size, userId);

        HashMap map = new HashMap<>();
        map.put("list",fileUploads);
        map.put("count",count);

        return new ResponseVo("删除成功",map,"0x200");
    }
}
