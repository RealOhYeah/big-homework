package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.Carousel;

import java.io.Serializable;

/**
 * Carousel分页查询BO
 */
public class CarouselQueryBo implements Serializable {

    private Long start;//开始坐标

    private Integer size;//每页显示长度

    private Carousel carousel;

    public CarouselQueryBo(Long start, Integer size, Carousel carousel) {
        this.start = start;
        this.size = size;
        this.carousel = carousel;
    }

    public CarouselQueryBo(){}

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

    public Carousel getCarousel() {
        return carousel;
    }

    public void setCarousel(Carousel carousel) {
        this.carousel = carousel;
    }

    @Override
    public String toString() {
        return "CarouselQueryBo{" +
                "start=" + start +
                ", size=" + size +
                ", carousel=" + carousel +
                '}';
    }
}
