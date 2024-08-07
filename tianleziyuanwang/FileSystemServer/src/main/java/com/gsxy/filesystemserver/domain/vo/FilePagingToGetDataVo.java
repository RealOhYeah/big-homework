package com.gsxy.filesystemserver.domain.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 2024-03-10
 * 用户分页查询返回数据实体类
 */
public class FilePagingToGetDataVo implements Serializable {
    private List<FilePagingToData> list;
    private Integer count;

    public FilePagingToGetDataVo() {
    }

    public FilePagingToGetDataVo(List<FilePagingToData> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<FilePagingToData> getList() {
        return list;
    }

    public void setList(List<FilePagingToData> list) {
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
        return "FilePagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
