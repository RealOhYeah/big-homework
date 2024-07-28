package com.gsxy.filesystemserver.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class FilePagingToData {

    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 最开始的文件名
     */
    private String originalFileName;
    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件权限
     */
    private Integer role;


    /**
     * 修改时间
     */
    private Date updateTime;

    public FilePagingToData() {
    }

    public FilePagingToData(Long id, String originalFileName, String fileType, Integer role, Date updateTime) {
        this.id = id;
        this.originalFileName = originalFileName;
        this.fileType = fileType;
        this.role = role;
        this.updateTime = updateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "FilePagingToData{" +
                "id=" + id +
                ", originalFileName='" + originalFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", role=" + role +
                ", updateTime=" + updateTime +
                '}';
    }
}
