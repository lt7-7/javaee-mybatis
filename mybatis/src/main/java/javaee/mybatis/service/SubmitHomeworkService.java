package javaee.mybatis.service;

import javaee.mybatis.DAO.SubmitHomeworkDAO;
import javaee.mybatis.model.StudentHomework;

import javax.annotation.Resource;
import java.util.List;

public class SubmitHomeworkService {

    @Resource
    SubmitHomeworkDAO submitHomeworkDAO;

    public void submitHomework(StudentHomework studentHomework){
        submitHomeworkDAO.submitHomework(studentHomework);
    }

    public List<StudentHomework> showSubmit(){
        return submitHomeworkDAO.showSubmit();
    }

}
