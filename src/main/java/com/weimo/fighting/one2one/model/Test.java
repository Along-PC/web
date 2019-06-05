package com.weimo.fighting.one2one.model;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.one2one.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.text.DecimalFormat;

public class Test {
    public static void main(String[] args) {
        DBOperatorUtils instance = DBOperatorUtils.getInstance();
        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee hw9803 = mapper.selectEmployeeById("HW9803");
        System.out.println(hw9803.toString());
//        System.out.println(hw9803.getEmployeeSchool().toString());
//        String temp="55:E9:41:FA:8F:92:26:90:75:56:88:14:6B:3F:87:CD:21:25:43:EF";
//        String replace = temp.replace(":", "");
//        System.out.println(replace);
//        DecimalFormat decimalFormat = new DecimalFormat("0.00");
//        System.out.println(decimalFormat.format(67.01));

    }
}
