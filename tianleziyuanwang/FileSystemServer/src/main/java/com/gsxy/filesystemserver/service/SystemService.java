package com.gsxy.filesystemserver.service;

import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import org.springframework.stereotype.Service;

@Service
public interface SystemService {
    /**
     * is amdin
     * @param token
     * @param leave
     * @return
     */
    public ResponseVo isAdmin(String token, Integer leave);

    /**
     * 鉴权
     * @param token
     * @return
     */
    public ResponseVo auth(String token);


    public String getNonPower();
}
