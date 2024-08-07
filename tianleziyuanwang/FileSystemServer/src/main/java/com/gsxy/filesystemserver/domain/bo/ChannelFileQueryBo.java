package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.ChannelFiles;

public class ChannelFileQueryBo {

    private Long start;//开始坐标

    private Integer size;//每页显示长度

    private ChannelFiles channelFiles;

    public ChannelFileQueryBo(Long start, Integer size, ChannelFiles channelFiles) {
        this.start = start;
        this.size = size;
        this.channelFiles = channelFiles;
    }

    public ChannelFileQueryBo(){}

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

    public ChannelFiles getChannelFiles() {
        return channelFiles;
    }

    public void setChannelFiles(ChannelFiles channelFiles) {
        this.channelFiles = channelFiles;
    }

    @Override
    public String toString() {
        return "ChannelFileQueryBo{" +
                "start=" + start +
                ", size=" + size +
                ", channelFiles=" + channelFiles +
                '}';
    }
}
