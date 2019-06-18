package com.weimo.fighting.shop.model;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class JokeBean {

    private int joke_id;
    private String joke_content;
    private String joke_person;
    private String joke_time;

    public int getJoke_id() {
        return joke_id;
    }

    public void setJoke_id(int joke_id) {
        this.joke_id = joke_id;
    }

    public String getJoke_content() {
        return joke_content;
    }

    public void setJoke_content(String joke_content) {
        this.joke_content = joke_content;
    }

    public String getJoke_person() {
        return joke_person;
    }

    public void setJoke_person(String joke_person) {
        this.joke_person = joke_person;
    }

    public String getJoke_time() {
        return joke_time;
    }

    public void setJoke_time(String joke_time) {
        this.joke_time = joke_time;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "JokeBean{" +
                "joke_id=" + joke_id +
                ", joke_content='" + joke_content + '\'' +
                ", joke_person='" + joke_person + '\'' +
                ", joke_time=" + simpleDateFormat.format(joke_time) +
                '}';
    }
}
