package com.gsxy.filesystemserver.domain;

import java.io.Serializable;

/**
 * (ChannelFiles)实体类
 *
 * @author makejava
 * @since 2024-03-14 15:41:15
 */
public class ChannelFiles implements Serializable {
    private static final long serialVersionUID = 477947612481198706L;

    private Long id;
    /**
     * 通道id
     */
    private Long channelId;
    /**
     * 文件id
     */
    private Long fileId;


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

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public ChannelFiles(Long id, Long channelId, Long fileId) {
        this.id = id;
        this.channelId = channelId;
        this.fileId = fileId;
    }

    public ChannelFiles(){}

    @Override
    public String toString() {
        return "ChannelFiles{" +
                "id=" + id +
                ", channelId=" + channelId +
                ", fileId=" + fileId +
                '}';
    }
}

