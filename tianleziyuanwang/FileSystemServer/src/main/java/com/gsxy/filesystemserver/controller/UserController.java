package com.gsxy.filesystemserver.controller;


import com.alibaba.fastjson2.JSONArray;
import com.gsxy.filesystemserver.domain.bo.UserLoginBo;
import com.gsxy.filesystemserver.domain.bo.UserRegBo;
import com.gsxy.filesystemserver.domain.bo.UserUpdateBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 鉴权板块
 */
@CrossOrigin
@Api(value = "用户板块接口",tags = {"用户板块接口"})
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    /**
     * 用户登入
     * @param userLoginBo
     * @return
     */
    @PostMapping(value = "/login",produces = "text/plain;charset=UTF-8")
    @ApiOperation("用户登入")
    public String userLogin(@RequestBody UserLoginBo userLoginBo){
        if (userLoginBo == null){
            com.alibaba.fastjson2.JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }
        return JSONArray.toJSONString(userService.userLogin(userLoginBo));
    }


    /**
     * 用户注册
     * @param userRegBo
     * @return
     */
    @PostMapping(value = "/userReg",produces = "text/plain;charset=UTF-8")
    @ApiOperation("用户注册")
    public String userReg(@RequestBody UserRegBo userRegBo){
        if (userRegBo == null){
            JSONArray.toJSONString( new ResponseVo("参数为null", null, "0x455"));
        }
        return JSONArray.toJSONString(userService.userReg(userRegBo));
    }

    /**
     * 用户修改
     * @param userUpdateBo
     * @return
     */
    @PostMapping(value = "/userUpdate",produces = "text/plain;charset=UTF-8")
    @ApiOperation("用户修改")
    public String userUpdate(@RequestBody UserUpdateBo userUpdateBo){
        return JSONArray.toJSONString(userService.userUpdate(userUpdateBo));
    }
}
