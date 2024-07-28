package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.Channels;

import java.io.Serializable;

public class ChannelsQueryBo implements Serializable {

    private Long start;//开始坐标

    private Integer size;//每页显示长度

    private Channels channels;

    public ChannelsQueryBo(Long start, Integer size, Channels channels) {
        this.start = start;
        this.size = size;
        this.channels = channels;
    }

    public ChannelsQueryBo(){}

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

    public Channels getChannels() {
        return channels;
    }

    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    @Override
    public String toString() {
        return "ChannelsQueryBo{" +
                "start=" + start +
                ", size=" + size +
                ", channels=" + channels +
                '}';
    }
}


