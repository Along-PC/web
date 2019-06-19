package com.weimo.fighting.shop.controller;

import com.google.gson.Gson;
import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.shop.mapper.UserMapper;
import com.weimo.fighting.shop.model.CommonBean;
import com.weimo.fighting.shop.model.UserBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value = "/verify",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String verify(String userPhone,String userPwd){
        System.out.println("userPhone:"+userPhone);
        System.out.println("userPwd:"+userPwd);
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserBean userBean = new UserBean();
        userBean.setUserPhone(userPhone);
        userBean.setPassword(userPwd);
        UserBean user = mapper.getUser(userBean);
        CommonBean<UserBean> userBeanCommonBean = new CommonBean<>();
        if (user==null) {
            userBeanCommonBean.setStatus(-1);
        }else{
            userBeanCommonBean.setStatus(0);
            userBeanCommonBean.setData(user);
        }
        Gson gson = new Gson();
        sqlSession.close();
        return gson.toJson(userBeanCommonBean);
    }
}
