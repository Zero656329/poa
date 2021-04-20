package com.sunny.poa.service;

import com.sunny.poa.entity.Student;

import java.util.List;

public interface StudentService {
    Integer insert(Student student);
    List<Student> getList();
}
