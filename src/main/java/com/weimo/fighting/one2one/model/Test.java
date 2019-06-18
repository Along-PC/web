package com.weimo.fighting.one2one.model;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.one2one.mapper.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        DBOperatorUtils instance = DBOperatorUtils.getInstance();
//        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        Employee hw9803 = mapper.selectEmployeeById("HW9803");
//        System.out.println(hw9803.toString());
//        System.out.println(hw9803.getEmployeeSchool().toString());
//        String temp="55:E9:41:FA:8F:92:26:90:75:56:88:14:6B:3F:87:CD:21:25:43:EF";
//        String replace = temp.replace(":", "");
//        System.out.println(replace);
//        DecimalFormat decimalFormat = new DecimalFormat("0.00");
//        System.out.println(decimalFormat.format(132130.0163123123));
//
//        NumberFormat nf = NumberFormat.getNumberInstance();
//        // 最多保留两位小数
//        nf.setMaximumFractionDigits(2);
//        // 最少保留两位小数
//        nf.setMinimumFractionDigits(2);
//        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
//        nf.setRoundingMode(RoundingMode.UP);
////        nf.setRoundingMode(RoundingMode.DOWN);
//        System.out.println(nf.format(213123.7));

//        List<Integer>  integers=new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            integers.add(i);
//        }
//
//        Iterator<Integer> iterator = integers.iterator();
//        while (iterator.hasNext()) {
//            Integer next = iterator.next();
//            if (next==5) {
//                iterator.remove();
//            }
//        }
//        System.out.println(Arrays.toString(integers.toArray()));

//        try {
//            ArrayList<Integer> list = new ArrayList<>();
//            Method method = list.getClass().getMethod("add", Object.class);
//            method.invoke(list, "菜比an。");
//            System.out.println(list.get(0));
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }

        float v = Float.parseFloat("0");
        System.out.println("sssss:"+v);

    }

}
