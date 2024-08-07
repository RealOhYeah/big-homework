package com.gsxy.filesystemserver.service;


import com.gsxy.filesystemserver.domain.bo.*;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;

/**
 * 用户板块
 */
public interface UserService {
    /**
     * @author zhuxinyu 2024-03-06
     *      用户登录
     * @param userLoginBo
     * @return
     */
    ResponseVo userLogin(UserLoginBo userLoginBo);

    ResponseVo userReg(UserRegBo userRegBo);

    ResponseVo userUpdate(UserUpdateBo userUpdateBo);

}
