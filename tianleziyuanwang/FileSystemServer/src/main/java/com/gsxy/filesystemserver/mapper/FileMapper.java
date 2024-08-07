package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.DeleteLog;
import com.gsxy.filesystemserver.domain.DownloadFile;
import com.gsxy.filesystemserver.domain.FileUploads;
import com.gsxy.filesystemserver.domain.bo.FileUpdateBo;
import com.gsxy.filesystemserver.domain.vo.FilePagingToData;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author Oh...Yeah!!!
* @description 针对表【file】的数据库操作Mapper
* @createDate 2024-03-10 14:26:20
* @Entity com.gsxy.filesystemserver.domain.FileUploads
*/
@Mapper
public interface FileMapper{


    public List<FileUploads> queryPublicFileWithoutMyself(@Param("start") Long start,@Param("size")Integer size,@Param("id") Long id);

    public Long queryPublicFileWithoutMyselfCoung(@Param("start") Long start,@Param("size")Integer size,@Param("id") Long id);

    Long getCount(@Param("parmas") FileUploads fileUploads);

    /**
     * 将上传的文件信息录入数据库
     * @param fileSystem
     */
    void add(FileUploads fileSystem);

    /**
     * 添加下载文件的信息
     * @param downloadFile
     */
    void insertDownloadFile(DownloadFile downloadFile);

    /**
     * 查找此文件
     */
    FileUploads findFile(Long imgId);

    /**
     * @author zhuxinyu 2024-03-10
     *      分页查询
     * @param fileUploads
     * @return
     */
    List<FilePagingToData> filePagingToGetUserData(@Param("start") Long start,@Param("size")Integer size,@Param("parmas")FileUploads fileUploads);

    Long fileDelete(Long id);

    /**
     * @param fileUpdateBo
     * @return
     * @author hln 2024-03-13
     * 文件查询
     */
    int updateFile(FileUpdateBo fileUpdateBo);

    /**
     * @author hln 2024-3-25
     * 记录删除操作日志
     * @param deleteLog
     */
    void insertIntoDelteLog(DeleteLog deleteLog);


    String selectFileNameById(Long id);

    /**
     * @author hln 2024-3-26
     * 根据id查找文件扩展名
     * @param id
     * @return
     */
    String selectFileTypeById(Long id);

    /**
     * 删除
     * @param id
     */
    void deleteCarouselFile(Long id);

    /**
     * 删除
     * @param aLong
     */
    void deleteFile(Long aLong);
}




