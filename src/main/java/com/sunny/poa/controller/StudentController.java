package com.sunny.poa.controller;

import com.sunny.poa.config.JsonResult;
import com.sunny.poa.entity.Student;
import com.sunny.poa.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping(value = "/getList", method = RequestMethod.GET)
    public JsonResult getList()  {
        List<Student> list=studentService.getList();

        return new JsonResult(list);
    }
}
