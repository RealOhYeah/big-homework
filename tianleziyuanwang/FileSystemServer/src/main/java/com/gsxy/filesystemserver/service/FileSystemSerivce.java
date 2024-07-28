package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.FilePagingToGetDataBo;
import com.gsxy.filesystemserver.domain.bo.FileUpdateBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileSystemSerivce {


    /**
     * @author hln 2024-03-12
     * 文件修改
     * @param fileUpdateBo
     */
    ResponseVo updateFile(FileUpdateBo fileUpdateBo);

    /**
     * 上传图片
     * @param file
     * @return
     * @throws IOException
     */
    public String imgUpDown(MultipartFile file,Long channelId) throws IOException;

    /**
     * 文件下载
     */
    public byte[] getFile( String imgUrl) throws IOException;


    /**
     * @author zhuxinyu 2024-03-10
     * 分页查询
     * @param fileUploads
     * @return
     */
    public ResponseVo FilePagingToGetData(FilePagingToGetDataBo fileUploads);

    public ResponseVo FileDelete(Long id);

    /**
     * @author hln 2024-4-1
     *  文件批量删除
     */
    ResponseVo deleteList(List<Long> list);

    /**
     * 获取不是自己公开的文件
     * @return
     */
    public ResponseVo queryPublicFileWithoutMyself(Long start,Integer size);
}
