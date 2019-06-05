package com.weimo.fighting.mapper;

import com.weimo.fighting.model.Student;

import java.util.List;

public interface StudentMapper {

    public Student getStudent(int id);

    public List<Student> getAllStudent();

    public void addStudent(Student student);
}
