package com.gsxy.filesystemserver.domain.bo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * carouse添加Bo类
 */
public class CarouselAddBo implements Serializable {

    private String name;

    /**
     * 最大数量
     */
    private Integer maxNumber;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 创建人
     */
    private Long createBy;

    public CarouselAddBo(String name, Integer maxNumber, Date createTime, Long createBy) {
        this.name = name;
        this.maxNumber = maxNumber;
        this.createTime = createTime;
        this.createBy = createBy;
    }

    public CarouselAddBo(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(Integer maxNumber) {
        this.maxNumber = maxNumber;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "CarouselAddBo{" +
                "name='" + name + '\'' +
                ", maxNumber=" + maxNumber +
                ", createTime=" + createTime +
                ", createBy=" + createBy +
                '}';
    }
}
