package javaee.mybatis.service;

import javaee.mybatis.DAO.HomeworkDAO;
import javaee.mybatis.model.Homework;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkService {

    @Resource
    HomeworkDAO homeworkDAO;

    public void publishHomework(Homework homework){
        homeworkDAO.publishHomework(homework);
    }

    public List<Homework> showHomework(){
        return homeworkDAO.showHomework();
    }
}
