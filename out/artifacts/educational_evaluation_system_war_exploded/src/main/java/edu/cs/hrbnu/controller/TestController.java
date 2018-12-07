package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("test")
    public ModelAndView test(){
        Student student = new Student();
        student.setPassword("12345");
        student.setClassId(1);
        student.setDepartment("软件工程");
        student.setGrade(2016);
        student.setGraduation(false);
        student.setName("老王");
        student.setStudentId("2016040888");
        student.setIdCard("410326199901111234");
        try {
            studentMapper.insertStudent(student);
            System.out.println("test");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return new ModelAndView("test");
    }
}
