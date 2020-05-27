package javaee.mybatis.DAO;

import javaee.mybatis.model.StudentHomework;

import java.util.List;

public interface SubmitHomeworkDAO {
    public void submitHomework(StudentHomework studentHomework);

    public List<StudentHomework> showSubmit();

}
