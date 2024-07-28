package com.gsxy.filesystemserver.domain.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 2024-03-10
 * 返回所有信息
 */
public class FileFindAllVo implements Serializable {
    private String fileName;//文件名
    private String fileType;//文件类型
    private Date createTime;//创建时间
    private Integer status;//状态

    public FileFindAllVo() {
    }

    public FileFindAllVo(String fileName, String fileType, Date createTime, Integer status) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.createTime = createTime;
        this.status = status;
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

    @Override
    public String toString() {
        return "FileFindAllVo{" +
                "fileName='" + fileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", createTime=" + createTime +
                ", status=" + status +
                '}';
    }
}
