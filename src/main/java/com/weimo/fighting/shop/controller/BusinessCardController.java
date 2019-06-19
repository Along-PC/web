package com.weimo.fighting.shop.controller;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.shop.mapper.BusinessCardMapper;
import com.weimo.fighting.shop.model.BusinessCardBean;
import com.weimo.fighting.shop.model.CommonBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BusinessCardController {

    @RequestMapping(value = "/getAllCards")
    @ResponseBody
    public CommonBean getAllCards(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BusinessCardMapper mapper = sqlSession.getMapper(BusinessCardMapper.class);
        List<BusinessCardBean> allBusinessCard = mapper.getAllBusinessCard();
        CommonBean<List<BusinessCardBean>> listCommonBean = new CommonBean<>();
        listCommonBean.setStatus(0);
        listCommonBean.setData(allBusinessCard);
        return listCommonBean;
    }


}
