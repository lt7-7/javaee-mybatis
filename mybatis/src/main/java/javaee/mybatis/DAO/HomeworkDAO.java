package javaee.mybatis.DAO;

import javaee.mybatis.model.Homework;

import java.util.List;

public interface HomeworkDAO {
    public void publishHomework(Homework homework);

    public List<Homework> showHomework();

}
