package com.weimo.fighting.shop.model;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.shop.mapper.JokeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Calendar;
import java.util.List;

public class Run {

    public static void main(String[] args) {
//        addJoke();
        showJokes();
    }

    public static void addJoke(){
        JokeBean jokeBean = new JokeBean();
        jokeBean.setJoke_content("一个宗旨，打死小黑");
        jokeBean.setJoke_person("龙皇");
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JokeMapper mapper = sqlSession.getMapper(JokeMapper.class);
        mapper.addJoke(jokeBean);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void showJokes(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        JokeMapper mapper = sqlSession.getMapper(JokeMapper.class);
        List<JokeBean> allJokeBean = mapper.getAllJokeBean();
        for (int i = 0; i < allJokeBean.size(); i++) {
            System.out.println(allJokeBean.get(i).toString());
        }
        sqlSession.close();
    }

}
