package com.gsxy.filesystemserver.domain.bo;

import com.gsxy.filesystemserver.domain.ChannelList;
import org.apache.poi.sl.draw.geom.Guide;

public class ChannelListPagingToGetDataBo {

    private Long start;//开始坐标
    private Integer size;//每页显示长度
    private ChannelList channelList;

    public ChannelListPagingToGetDataBo() {
    }

    public ChannelListPagingToGetDataBo(Long start, Integer size, ChannelList channelList) {
        this.start = start;
        this.size = size;
        this.channelList = channelList;
    }

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

    public ChannelList getChannelList() {
        return channelList;
    }

    public void setChannelList(ChannelList channelList) {
        this.channelList = channelList;
    }

    @Override
    public String toString() {
        return "ChannelListPagingToGetDataBo{" +
                "start=" + start +
                ", size=" + size +
                ", channelList=" + channelList +
                '}';
    }
}
