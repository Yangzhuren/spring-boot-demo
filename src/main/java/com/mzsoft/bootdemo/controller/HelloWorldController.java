package com.mzsoft.bootdemo.controller;

import com.mzsoft.bootdemo.domain.dao.StudentDao;
import com.mzsoft.bootdemo.domain.entity.Student;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.io.Writer;
import java.util.List;

@RestController
public class HelloWorldController {
    @Autowired
    private StudentDao studentDao;

    @RequestMapping("/")
    public List<Student> index(String name) {
        return studentDao.findAll();
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Serializable welcome(@RequestBody Student student) {
        String name = student.getName();
        String password = student.getPassword();
        Student studentInData = studentDao.findByName(name);
        if (studentInData != null && studentInData.getId() != null && studentInData.getPassword().equals(password)) {
            return studentInData;
        }
        return false;
    }
}
