package com.weimo.fighting.dynamic.model;

import com.weimo.fighting.DBOperatorUtils;
import com.weimo.fighting.dynamic.Mapper.StudentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Run {

    public static void main(String[] args) {

//        getStduent();
//        addStduent();
//        deleteStduent();
        getAllStduent();
//        System.out.println(Student.class.toString());
    }

    public static void getStduent(){
        DBOperatorUtils instance = DBOperatorUtils.getInstance();
        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.getStudent("20171699");
        System.out.println(student.toString());
        sqlSession.close();
    }

    public static void getAllStduent(){
        DBOperatorUtils instance = DBOperatorUtils.getInstance();
        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> allStudent = mapper.getAllStudent();
        for (int i = 0; i < allStudent.size(); i++) {
            System.out.println(allStudent.get(i).toString());
        }
        sqlSession.close();
    }

    public static void addStduent(){
        DBOperatorUtils instance = DBOperatorUtils.getInstance();
        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setSno("20198888");
        student.setName("阿龙");
        student.setAge(25);
        student.setSex("男");
        student.setDept_no("2602");
        mapper.addStudent(student);
        sqlSession.commit();
        sqlSession.close();
    }

    public static void deleteStduent(){
        DBOperatorUtils instance = DBOperatorUtils.getInstance();
        SqlSessionFactory sqlSessionFactory = instance.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        mapper.deleteStudent("20198888");
        sqlSession.commit();
        sqlSession.close();
    }


}
