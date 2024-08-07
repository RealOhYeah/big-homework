package com.gsxy.filesystemserver.controller;

import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.FilePagingToGetDataBo;
import com.gsxy.filesystemserver.domain.bo.FileUpdateBo;
import com.gsxy.filesystemserver.mapper.FileMapper;
import com.gsxy.filesystemserver.service.ChannelsService;
import com.gsxy.filesystemserver.service.FileSystemSerivce;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 文件板块
 */
@RestController
@RequestMapping(value = "/file",produces = "text/plain;charset=UTF-8")
public class FileSystemController {

    @Autowired
    private FileSystemSerivce fileSystemSerivce;

    /**
     * @author hln 2024-4-1
     *  文件批量删除
     */
    @ApiOperation("文件批量删除操作")
    @PostMapping("/deleteList")
    public String deleteList(@RequestBody List<Long> list) {
        return JSONArray.toJSONString(fileSystemSerivce.deleteList(list));
    }

    /**
     * 文件修改
     */
    @ApiOperation("文件修改")
    @PostMapping("/updateFile")
    public String updateFile(@RequestBody FileUpdateBo fileUpdateBo) {
        return JSONArray.toJSONString(fileSystemSerivce.updateFile(fileUpdateBo));
    }


    /**
     * 文件下载
     */
    @GetMapping(value ="/getFile")
    public ResponseEntity<byte[]> getFile(@RequestParam(value = "imgUrl") String imgUrl) throws IOException {
        System.err.println(imgUrl);
        System.err.println("？123？");
        byte[] fileContent = fileSystemSerivce.getFile(imgUrl);

        String fileName = new File(imgUrl).getName();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName); // 设置原始文件名

        return new ResponseEntity<>(fileContent, headers, HttpStatus.OK);
    }

    @GetMapping("/getVideo")
    public ResponseEntity<Resource> getVideo(@RequestParam(value = "imgUrl") String imgUrl) throws IOException {
        System.err.println("？？");
        // 根据imgUrl从文件系统或其他地方获取视频数据
        byte[] videoData = fileSystemSerivce.getFile(imgUrl);
        System.err.println("？？");

        // 将视频数据包装为输入流资源
        ByteArrayInputStream inputStream = new ByteArrayInputStream(videoData);
        InputStreamResource resource = new InputStreamResource(inputStream);

        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.valueOf("video/quicktime")); // 设置视频MIME类型
        headers.setContentDispositionFormData("inline", "video.mov"); // 设置原始文件名，并告诉浏览器在页面中显示

        // 返回响应实体
        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }

    /**
     * 上传文件
     */
    @ApiOperation("上传文件")
    @PostMapping("/imgUpDown")
    public String imgUpDown(@RequestPart("file") MultipartFile file,@RequestParam("channelId")Long channelId) throws IOException {
        return fileSystemSerivce.imgUpDown(file,channelId);
    }

    /**
     * @author zhuxinyu 2024-03-10
     *      分页查询
     * @param fileUploads
     * @return
     */
    @PostMapping("/pagingToGetData")
    @ApiOperation("分页查询")
    public String filePagingToGetData(@RequestBody FilePagingToGetDataBo fileUploads){



        return JSONArray.toJSONString(fileSystemSerivce.FilePagingToGetData(fileUploads));
    }

    /**
     * @author zhuxinyu 2024-03-12
     * 文件删除
     * @param id
     * @return
     */
    @PostMapping(value = "/fileDelete",produces = "text/plain;charset=UTF-8")
    @ApiOperation("删除文件")
    public String fileDelete(@RequestParam Long id){
        return JSONArray.toJSONString(fileSystemSerivce.FileDelete(id));
    }


    @ApiOperation("查询不是自己的公开文件")
    @PostMapping("/queryPublicFileWithoutMyself")
    public String queryPublicFileWithoutMyself(@RequestParam("start") Long start, @RequestParam("size") Integer size){
        return JSONArray.toJSONString(fileSystemSerivce.queryPublicFileWithoutMyself(start,size));
    }
}
