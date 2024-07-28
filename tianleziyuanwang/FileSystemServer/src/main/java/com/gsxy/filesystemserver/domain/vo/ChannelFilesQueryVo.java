package com.gsxy.filesystemserver.domain.vo;

import com.gsxy.filesystemserver.domain.Carousel;
import com.gsxy.filesystemserver.domain.ChannelFiles;

import java.util.List;

public class ChannelFilesQueryVo {

    private List<ChannelFiles> list;

    private Long count;

    public ChannelFilesQueryVo(){}

    public ChannelFilesQueryVo(List<ChannelFiles> list, Long count) {
        this.list = list;
        this.count = count;
    }

    public List<ChannelFiles> getList() {
        return list;
    }

    public void setList(List<ChannelFiles> list) {
        this.list = list;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }
}
