package com.gsxy.filesystemserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName download_file
 */

public class DownloadFile implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 下载的文件名
     */
    private String fileName;

    /**
     * 下载的路径
     */
    private String downPath;

    /**
     * 下载人
     */
    private Long createBy;

    /**
     * 下载时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    public DownloadFile() {
    }

    public DownloadFile(String fileName, String downPath, Long createBy, Date createTime) {
        this.fileName = fileName;
        this.downPath = downPath;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    public DownloadFile(Long id, String fileName, String downPath, Long createBy, Date createTime) {
        this.id = id;
        this.fileName = fileName;
        this.downPath = downPath;
        this.createBy = createBy;
        this.createTime = createTime;
    }

    /**
     *
     */
    public Long getId() {
        return id;
    }

    /**
     *
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 下载的文件名
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 下载的文件名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 下载的路径
     */
    public String getDownPath() {
        return downPath;
    }

    /**
     * 下载的路径
     */
    public void setDownPath(String downPath) {
        this.downPath = downPath;
    }

    /**
     * 下载人
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * 下载人
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * 下载时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 下载时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DownloadFile{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", downPath='" + downPath + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                '}';
    }
}