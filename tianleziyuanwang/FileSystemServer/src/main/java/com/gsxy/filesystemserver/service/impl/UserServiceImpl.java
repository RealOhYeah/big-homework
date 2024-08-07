package com.gsxy.filesystemserver.service.impl;

import com.gsxy.filesystemserver.domain.User;
import com.gsxy.filesystemserver.domain.bo.UserLoginBo;
import com.gsxy.filesystemserver.domain.bo.UserRegBo;
import com.gsxy.filesystemserver.domain.bo.UserUpdateBo;
import com.gsxy.filesystemserver.domain.vo.ResponseVo;
import com.gsxy.filesystemserver.mapper.UserMapper;
import com.gsxy.filesystemserver.service.UserService;
import com.gsxy.filesystemserver.utils.JwtUtil;
import com.gsxy.filesystemserver.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    /**
     * 用户登入
     * @param userLoginBo
     * @return
     */
    @Override
    public ResponseVo userLogin(UserLoginBo userLoginBo){
        //通过username取获取用户
        User user = userMapper.userLogin(userLoginBo);

        //比较用户密码和数据库中密码是否一致
        if (user == null || !user.getPassword().equals(userLoginBo.getPassword())) {
            return new ResponseVo("账号或密码错误",null,"0x201");
        }
        //从数据库进行数据库的拿取
        String token = JwtUtil.createJWT(user);
        String name = user.getName();
        String username= user.getUsername();
        String org = user.getOrg();

        //登录时权限变为用户角色，如果数据库中role没有数据权限，进行0的录入
        user.setRole(0);

        //用于给前端进行数据的展示
        HashMap<String,Object> map = new HashMap<>();
        map.put("token",token);
        map.put("name",name);
        map.put("username",username);
        map.put("org",org);

        return new ResponseVo("登入成功",map,"0x200");
    }


    /**
     * 用户注册
     * @param userRegBo
     * @return
     */
    @Override
    public ResponseVo userReg(UserRegBo userRegBo){

        User username = userMapper.findByUsername(userRegBo.getUsername());

        if (username != null) {
            return new ResponseVo("该username已经存在",null,"0x202");
        }
        Long aLong = userMapper.userReg(userRegBo);
        userRegBo.setCreateBy(username.getId());
        userRegBo.setCreateTime(new Date());
        if(aLong.longValue() == 0L){
            return new ResponseVo("注册失败",null,"0x500");
        }

        return new ResponseVo("注册成功",null,"0x200");
    }

    @Override
    public ResponseVo userUpdate(UserUpdateBo userUpdateBo) {

        userUpdateBo.setId(Long.valueOf( ThreadLocalUtil.mapThreadLocalOfJWT.get().get("userInfo").get("id").toString()));
        Long userId = userUpdateBo.getId();
        userUpdateBo.setUpdateBy(userId);
        userUpdateBo.setUpdateTime(new Date());
        Long aLong = userMapper.userUpdate(userUpdateBo);

        if(aLong == null || aLong.longValue() == 0L){
            return new ResponseVo("修改失败",null,"0x500");
        }

        return new ResponseVo("修改成功",userId,"0x200");
    }
}
