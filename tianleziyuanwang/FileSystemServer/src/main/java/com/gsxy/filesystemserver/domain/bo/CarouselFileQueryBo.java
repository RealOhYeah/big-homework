package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.domain.vo.CarouselFileQueryVo;

import java.io.Serializable;

/**
 * CarouselFile分页查询Bo
 */
public class CarouselFileQueryBo implements Serializable {

    private Long start;//开始坐标

    private Integer size;//每页显示长度

    private CarouselFile carouselFile;

    public CarouselFileQueryBo(Long start, Integer size, CarouselFile carouselFile) {
        this.start = start;
        this.size = size;
        this.carouselFile = carouselFile;
    }

    public CarouselFileQueryBo(){}

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

    public CarouselFile getCarouselFile() {
        return carouselFile;
    }

    public void setCarouselFile(CarouselFile carouselFile) {
        this.carouselFile = carouselFile;
    }

    @Override
    public String toString() {
        return "CarouselFileQueryBo{" +
                "start=" + start +
                ", size=" + size +
                ", carouselFile=" + carouselFile +
                '}';
    }
}
