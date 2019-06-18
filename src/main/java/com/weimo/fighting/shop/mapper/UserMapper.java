package com.weimo.fighting.shop.mapper;

import com.weimo.fighting.shop.model.UserBean;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where user_phone=#{userPhone} and user_password=#{password}")
    @Results({
            @Result(column = "user_name",property = "userName"),
            @Result(column = "user_phone",property = "userPhone"),
            @Result(column = "user_password",property = "password")
    })
    public UserBean getUser(UserBean userBean);

}
