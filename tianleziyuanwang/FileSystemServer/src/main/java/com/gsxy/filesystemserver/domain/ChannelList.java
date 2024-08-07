package com.gsxy.filesystemserver.domain;

import java.io.Serializable;

public class ChannelList implements Serializable {

    private Long id;
    private Long channelId;
    private Long showId;

    public ChannelList() {
    }

    public ChannelList(Long id, Long channelId, Long showId) {
        this.id = id;
        this.channelId = channelId;
        this.showId = showId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public Long getShowId() {
        return showId;
    }

    public void setShowId(Long showId) {
        this.showId = showId;
    }

    @Override
    public String toString() {
        return "ChannelList{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", showId=" + showId +
                '}';
    }
}
