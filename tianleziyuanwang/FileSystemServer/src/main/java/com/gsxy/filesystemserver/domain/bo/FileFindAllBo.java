package com.gsxy.filesystemserver.domain.bo;

import java.io.Serializable;
import java.util.Date;

/**
 * 2024-2-03-10
 * 查看所有信息
 */
public class FileFindAllBo implements Serializable {
    private String fileName;//文件名
    private String fileType;//文件类型
    //todo 问题1 为什么加createTime
    private Date createTime;//创建时间
    private Integer status;//状态
    private Integer start;//开始长度
    private Integer size;//截止长度

    public FileFindAllBo() {
    }

    public FileFindAllBo(String fileName, String fileType, Date createTime, Integer status, Integer start, Integer size) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.createTime = createTime;
        this.status = status;
        this.start = start;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "FileFindAllBo{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                ", start=" + start +
                ", size=" + size +
                '}';
    }
}
