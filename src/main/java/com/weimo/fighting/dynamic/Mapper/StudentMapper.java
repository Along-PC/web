package com.weimo.fighting.dynamic.Mapper;

import com.weimo.fighting.dynamic.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Select("select * from student where sno=#{sno}")
    @Results({
            @Result(id=true,column ="sno",property = "sno"),
            @Result(column ="name",property = "name"),
            @Result(column ="sex",property = "sex"),
            @Result(column ="age",property = "age"),
            @Result(column ="dept_no",property = "dept_no")
    })
    Student getStudent(String sno);

    @Select("select * from student")
    @Results({
            @Result(id=true,column ="sno",property = "sno"),
            @Result(column ="name",property = "name"),
            @Result(column ="sex",property = "sex"),
            @Result(column ="age",property = "age"),
            @Result(column ="dept_no",property = "dept_no")
    })
    List<Student> getAllStudent();

    @Insert("insert into student(sno,name,sex,age,dept_no) values(#{sno},#{name},#{sex},#{age},#{dept_no})")
    void addStudent(Student student);

    @Delete("delete from student where sno=#{sno}")
    void deleteStudent(String sno);

    @Update("update student set name=#{name} ,sex=#{sex} where sno=#{sno}")
    void updateStudent(Student student);
}
