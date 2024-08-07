package com.gsxy.filesystemserver.domain.vo;

import org.springframework.http.ResponseEntity;

public class DownloadFileVo {
    private ResponseVo responseVo;
    private ResponseEntity<byte[]> responseEntity;

    public DownloadFileVo() {
    }

    public DownloadFileVo(ResponseVo responseVo, ResponseEntity<byte[]> responseEntity) {
        this.responseVo = responseVo;
        this.responseEntity = responseEntity;
    }

    public ResponseVo getResponseVo() {
        return responseVo;
    }

    public void setResponseVo(ResponseVo responseVo) {
        this.responseVo = responseVo;
    }

    public ResponseEntity<byte[]> getResponseEntity() {
        return responseEntity;
    }

    public void setResponseEntity(ResponseEntity<byte[]> responseEntity) {
        this.responseEntity = responseEntity;
    }

    @Override
    public String toString() {
        return "DownloadFileVo{" +
                "responseVo=" + responseVo +
                ", responseEntity=" + responseEntity +
                '}';
    }
}
