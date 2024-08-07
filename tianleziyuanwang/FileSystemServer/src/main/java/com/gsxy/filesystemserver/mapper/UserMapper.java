package com.gsxy.filesystemserver.mapper;

import com.gsxy.filesystemserver.domain.User;
import com.gsxy.filesystemserver.domain.bo.UserLoginBo;
import com.gsxy.filesystemserver.domain.bo.UserRegBo;
import com.gsxy.filesystemserver.domain.bo.UserUpdateBo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    /**
     * @author zhuxinyu 2023-11-28
     *      在用户表中查找目标用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM user WHERE id = #{id} LIMIT 1")
    User queryByUserId(@Param("id")Long id);

    User userLogin(UserLoginBo userLoginBo);

    User findByUsername(String username);

    Long userReg(UserRegBo userRegBo);

    Long userUpdate(UserUpdateBo userUpdateBo);
}
