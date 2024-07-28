package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.ChannelList;

import java.util.List;

public class ChannelListPagingToGetDataVo {

    private List<ChannelList> list;
    private Integer count;

    public ChannelListPagingToGetDataVo() {
    }

    public ChannelListPagingToGetDataVo(List<ChannelList> list, Integer count) {
        this.list = list;
        this.count = count;
    }

    public List<ChannelList> getList() {
        return list;
    }

    public void setList(List<ChannelList> list) {
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
        return "ChannelListPagingToGetDataVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
