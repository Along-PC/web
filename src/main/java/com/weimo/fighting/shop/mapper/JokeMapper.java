package com.weimo.fighting.shop.mapper;

import com.weimo.fighting.shop.model.JokeBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JokeMapper {

    @Select("select * from joke")
    public List<JokeBean> getAllJokeBean();

    @Insert("insert into joke(joke_content,joke_person,joke_time) values(#{joke_content},#{joke_person},#{joke_time})")
    public void addJoke(JokeBean jokeBean);

}
