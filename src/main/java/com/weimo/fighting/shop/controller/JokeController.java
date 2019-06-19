package com.weimo.fighting.shop.controller;

import com.google.gson.Gson;
import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.shop.mapper.JokeMapper;
import com.weimo.fighting.shop.model.CommonBean;
import com.weimo.fighting.shop.model.JokeBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class JokeController {

    @RequestMapping(value="add_joke",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addJoke(String joke_content,String joke_person,String joke_time){
        JokeBean jokeBean = new JokeBean();
        jokeBean.setJoke_content(joke_content);
        jokeBean.setJoke_time(joke_time);
        jokeBean.setJoke_person(joke_person);
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JokeMapper mapper = sqlSession.getMapper(JokeMapper.class);
        mapper.addJoke(jokeBean);
        sqlSession.commit();
        sqlSession.close();
        CommonBean<String> commonBean = new CommonBean<>();
        commonBean.setStatus(0);
        return new Gson().toJson(commonBean);
    }

    @RequestMapping(value="/getAllJokes",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String getAllJokes(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JokeMapper mapper = sqlSession.getMapper(JokeMapper.class);
        List<JokeBean> allJokeBean = mapper.getAllJokeBean();
        CommonBean<List<JokeBean>> listCommonBean = new CommonBean<>();
        listCommonBean.setStatus(0);
        listCommonBean.setData(allJokeBean);
        Gson gson = new Gson();
        String jokes = gson.toJson(listCommonBean);
        return jokes;
    }
}
