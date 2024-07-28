package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.CarouselFile;
import com.gsxy.filesystemserver.domain.bo.CarouselFileQueryBo;

import java.util.List;

/**
 * CarouselFile分页查询Vo
 */
public class CarouselFileQueryVo {

    private List<CarouselFile> list;

    private Long count;

    public CarouselFileQueryVo(List<CarouselFile> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public CarouselFileQueryVo() {}

    public List<CarouselFile> getList() {
        return list;
    }

    public void setList(List<CarouselFile> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
