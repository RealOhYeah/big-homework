package com.gsxy.filesystemserver.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (CarouselFile)实体类
 *
 * @author 杨易达
 * @since 2024-03-13 11:06:04
 */
public class CarouselFile implements Serializable {
    private static final long serialVersionUID = -34710049067364305L;

    private Long id;
    /**
     * 轮播图id
     */
    private Long carouselId;
    /**
     * 文件fileid 必须是图片
     */
    private Long fileId;
    /**
     * 排序id
     */
    private Integer soft;
    /**
     * 创建人id
     */
    private Long createBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    /**
     * 修改人
     */
    private Long updateBy;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    /**
     * 状态
     */
    private Integer status;

    /**
     * 一个图片停留多少秒
     */
    private String seconds;

    /**
     * 介绍
     */
    private String introduceText;

    /**
     * 字体颜色
     */
    private String fontColor;

    @Override
    public String toString() {
        return "CarouselFile{" +
                "id=" + id +
                ", carouselId=" + carouselId +
                ", fileId=" + fileId +
                ", soft=" + soft +
                ", createBy=" + createBy +
                ", createTime=" + createTime +
                ", updateBy=" + updateBy +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", seconds='" + seconds + '\'' +
                ", introduceText='" + introduceText + '\'' +
                ", fontColor='" + fontColor + '\'' +
                '}';
    }

    public String getFontColor() {
        return fontColor;
    }

    public void setFontColor(String fontColor) {
        this.fontColor = fontColor;
    }

    public CarouselFile(Long id, Long carouselId, Long fileId, Integer soft, Long createBy, Date createTime, Long updateBy, Date updateTime, Integer status, String seconds, String introduceText, String fontColor) {
        this.id = id;
        this.carouselId = carouselId;
        this.fileId = fileId;
        this.soft = soft;
        this.createBy = createBy;
        this.createTime = createTime;
        this.updateBy = updateBy;
        this.updateTime = updateTime;
        this.status = status;
        this.seconds = seconds;
        this.introduceText = introduceText;
        this.fontColor = fontColor;
    }

    public CarouselFile(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCarouselId() {
        return carouselId;
    }

    public void setCarouselId(Long carouselId) {
        this.carouselId = carouselId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public Integer getSoft() {
        return soft;
    }

    public void setSoft(Integer soft) {
        this.soft = soft;
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

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public String getIntroduceText() {
        return introduceText;
    }

    public void setIntroduceText(String introduceText) {
        this.introduceText = introduceText;
    }

}

