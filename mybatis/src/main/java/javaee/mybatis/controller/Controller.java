package javaee.mybatis.controller;


import javaee.mybatis.jdbc.StudentHomeworkJdbc;
import javaee.mybatis.model.Homework;
import javaee.mybatis.model.Student;
import javaee.mybatis.model.StudentHomework;
import javaee.mybatis.service.HomeworkService;
import javaee.mybatis.service.StudentSerivce;
import javaee.mybatis.service.SubmitHomeworkService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentHomeworkJdbc.class);
    StudentHomeworkJdbc jdbc = (StudentHomeworkJdbc) applicationContext.getBean("jdbc");

    @Resource
    StudentSerivce studentSerivce;

    @Resource
    HomeworkService homeworkService;

    @Resource
    SubmitHomeworkService submitHomeworkService;

    @RequestMapping(path = "showHomework", method = RequestMethod.GET)
    public ModelAndView showHomework() {
        List<Homework> list = homeworkService.showHomework();
        return new ModelAndView("showHomework.jsp", "list", list);
    }

    @RequestMapping(path = "showSubmit", method = RequestMethod.GET)
    public ModelAndView showSubmit() {
        List<StudentHomework> list = submitHomeworkService.showSubmit();
        return new ModelAndView("showSubmit.jsp", "list", list);
    }

    @RequestMapping(path = "/publishHomework", method = RequestMethod.POST)
    public String addHomework() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Homework homework = new Homework();

        homework.setTitle(req.getParameter("title"));
        homework.setContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        homework.setCreate_time(date);
//
//        if(new StudentHomeworkJdbc().addHomework(homework)){
        String resp = "<script>alert(\"添加成功!\");</script>";
//            return resp;
//        }
//        String resp = "<script>alert(\"添加失败!\");</script>";
        homeworkService.publishHomework(homework);
        return resp;

    }

    @RequestMapping(path = "/addStudent", method = RequestMethod.POST)
    public String addStudent() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        Student s = new Student();
        s.setName(req.getParameter("name"));
//        if(new StudentHomeworkJdbc().addStudent(s)){
        String resp = ("<script>alert(\"添加成功!\");</script>");
//            return resp;
//        }
//        String resp = "<script>alert(\"添加失败!\");</script>";
//        return resp;
        studentSerivce.addStudent(s);
        return resp;
    }

    @RequestMapping(path = "/submitHomework", method = RequestMethod.POST)
    public String submitHomework() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = attributes.getRequest();
        StudentHomework studentHomework = new StudentHomework();
        studentHomework.setStudentId(Integer.parseInt(req.getParameter("student_id")));
        studentHomework.setHomeworkId(Integer.parseInt(req.getParameter("homework_id")));
        studentHomework.setHomeworkTitle(req.getParameter("title"));
        studentHomework.setHomeworkContent(req.getParameter("content"));
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());// new Date()为获取当前系统时间
        studentHomework.setCreateTime(date);
//        if(new StudentHomeworkJdbc().submitHomework(studentHomework)){
        String resp = ("<script>alert(\"提交成功!\");</script>");
//          return resp;
//        }
//        String resp = ("<script>alert(\"提交失败!\");</script>") ;
//        return resp;
//    }
        submitHomeworkService.submitHomework(studentHomework);
        return resp;
    }
}
