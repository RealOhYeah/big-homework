package com.gsxy.filesystemserver.domain.vo;

import java.util.List;

public class FindAllNewVo {
    private List<FileFindAllVo> list;
    private Integer count;

    public FindAllNewVo() {
    }

    public FindAllNewVo(List<FileFindAllVo> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<FileFindAllVo> getList() {
        return list;
    }

    public void setList(List<FileFindAllVo> list) {
        this.list = list;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "FindAllNewVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}