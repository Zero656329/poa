package com.sunny.poa.service.impl;

import com.sunny.poa.dao.StudentDao;
import com.sunny.poa.entity.Student;
import com.sunny.poa.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;

    @Override
    public Integer insert(Student student) {
        return studentDao.insert(student);
    }

    @Override
    public List<Student> getList() {
        return studentDao.selectList(null);
    }
}
