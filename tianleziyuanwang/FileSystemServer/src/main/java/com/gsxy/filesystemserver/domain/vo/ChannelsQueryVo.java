package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.Channels;

import java.util.List;

/**
 * @author hln 2024-3-16
 */
public class ChannelsQueryVo {

    private List<Channels> list;

    private Long count;

    public ChannelsQueryVo(List<Channels> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public ChannelsQueryVo(){}

    public List<Channels> getList() {
        return list;
    }

    public void setList(List<Channels> list) {
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
        return "ChannelsQueryVo{" +
                "list=" + list +
                ", count=" + count +
                '}';
    }
}
