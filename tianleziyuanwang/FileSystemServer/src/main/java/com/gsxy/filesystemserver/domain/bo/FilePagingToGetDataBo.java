package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.FileUploads;

import java.io.Serializable;

/**
 * 2024-03-10
 * 分页查询
 */
public class FilePagingToGetDataBo implements Serializable {
    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private FileUploads fileUploads;


    @Override
    public String toString() {
        return "FilePagingToGetDataBo{" +
                "start=" + start +
                ", size=" + size +
                ", fileUploads=" + fileUploads +
                '}';
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public FileUploads getFileUploads() {
        return fileUploads;
    }

    public void setFileUploads(FileUploads fileUploads) {
        this.fileUploads = fileUploads;
    }

    public FilePagingToGetDataBo() {
    }

    public FilePagingToGetDataBo(Long start, Integer size, FileUploads fileUploads) {
        this.start = start;
        this.size = size;
        this.fileUploads = fileUploads;
    }
}
