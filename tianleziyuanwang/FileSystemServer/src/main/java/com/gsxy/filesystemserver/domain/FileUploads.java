package com.gsxy.filesystemserver.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @TableName file
 */

public class FileUploads implements Serializable {
    /**
     *
     */
    @TableId
    private Long id;

    /**
     * 生成的文件名
     */
    private String fileName;
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
     * 下载文件路径
     */
    private String downloadPath;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改人
     */
    private Long updateBy;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 逻辑删除（0：未删除，1：被删除）
     */
    private Integer delFlag;


    public FileUploads() {
    }

    public FileUploads(String fileName, String originalFileName, String fileType, Integer role, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.originalFileName = originalFileName;
        this.fileName = fileName;
        this.fileType = fileType;
        this.role = role;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public FileUploads(String fileName, String originalFileName, String fileType, Integer role, String downloadPath, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.originalFileName = originalFileName;
        this.fileName = fileName;
        this.fileType = fileType;
        this.role = role;
        this.downloadPath = downloadPath;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }

    public FileUploads(Long id, String fileName, String originalFileName, String fileType, Integer role, String downloadPath, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, Integer delFlag) {
        this.id = id;
        this.fileName = fileName;
        this.originalFileName = originalFileName;
        this.fileType = fileType;
        this.role = role;
        this.downloadPath = downloadPath;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.delFlag = delFlag;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getDownloadPath() {
        return downloadPath;
    }

    public void setDownloadPath(String downloadPath) {
        this.downloadPath = downloadPath;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "FileUploads{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", originalFileName='" + originalFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", role=" + role +
                ", downloadPath='" + downloadPath + '\'' +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", delFlag=" + delFlag +
                '}';
    }
}

