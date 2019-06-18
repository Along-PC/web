package com.weimo.fighting.model;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

//        addStudent();
//        selectStudent();
//        getAllStudent();
        Random random = new Random();
        int i = random.nextInt(3);
        System.out.println("dangqian:"+i);
    }

    public static void selectStudent(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudent(1);
        DBOperatorUtils.logger.debug(student.toString());
        System.out.println(student.toString());
    }

    public static void getAllStudent(){
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getAllStudent();
        System.out.println("askadkaksdk");
        for (int i = 0; i < students.size(); i++) {
            DBOperatorUtils.logger.error(students.get(i).toString());
            System.out.println(students.get(i).toString());
        }
    }

    public static void addStudent() {
        Student student = new Student();
        student.setAge(26);
        student.setName("阿飞");
        student.setPhone("17610823875");
        student.setSex(1);
        SqlSessionFactory sqlSessionFactory = DBOperatorUtils.getInstance().getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.addStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }
}
