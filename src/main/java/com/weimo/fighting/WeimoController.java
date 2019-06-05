package com.weimo.fighting;

import com.sun.deploy.net.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
public class WeimoController {

    @RequestMapping(value = "/hello")
    public ModelAndView getHello() {
        ModelAndView modelAndView = new ModelAndView("along");
        modelAndView.addObject("time",new Date());
        System.out.println("个老子的");
        return modelAndView;
//        response.setContentType("text/html,charset=utf-8");
//        try {
//            response.getWriter().println("woshinidaye!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
