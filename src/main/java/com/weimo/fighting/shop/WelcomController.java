package com.weimo.fighting.shop;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class WelcomController {

    @RequestMapping(value="/along",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String sayHello(){
        List<String> list=new ArrayList<>();
        list.add("威武帅气脸拿起炒锅就给了小黑一下子");
        list.add("小胖和二凯在床上舒舒服服的睡了一觉");
        list.add("小黑在街上又咬了一只狗");
        Random random = new Random();
        int i = random.nextInt(list.size());
        return list.get(i)+"        --未末传媒";
    }
}
