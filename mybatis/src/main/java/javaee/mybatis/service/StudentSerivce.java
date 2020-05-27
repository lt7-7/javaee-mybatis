package javaee.mybatis.service;

import javaee.mybatis.DAO.StudentDAO;
import javaee.mybatis.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

@Service
public class StudentSerivce  {

    @Resource
    private StudentDAO studentDAO;

    public void addStudent(Student student){
        studentDAO.addStudent(student);
    }

}
