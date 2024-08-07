package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.Carousel;

import java.util.List;

/**
 * Carousel分页查询Vo
 */
public class CarouselQueryVo {

    private List<Carousel> list;

    private Long count;

    public CarouselQueryVo(List<Carousel> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public CarouselQueryVo(){}

    public List<Carousel> getList() {
        return list;
    }

    public void setList(List<Carousel> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "CarouselQueryVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
