package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

//    @RequestMapping("/form")
//    public String evaluateForm(ServletRequest request, String courseId){
//
//        /**
//         * 思路:首先根据教师id获取所授课程id扔进一个list中，再根据课程id查找对应课程评价
//         * */
//        //courseId = "201603001";
//        Course course1 = new Course();
//        course1.setCourseId("201603001");
//        course1.setCourseName("土木工程");
//        courseId = course.getCourseId();
//        List<Evaluate> evaluateList = null;
//        evaluateList = teacherService.otherEvaluate(courseId);
//
//        request.setAttribute("coursename",course1);
//        request.setAttribute("evaluateform",evaluateList);
//        return "evaluateForm";
//    }
    @RequestMapping("/courseform")
    public String courseForm(ServletRequest request,String teacherId){
        /**
         * 根据教师id获取教师所授课程
         * */

        //teacherId = ;

        List<Course> courseList = null;
        courseList = teacherService.getCourseByTeahcer("100101");
        request.setAttribute("courseform",courseList);
        return "courseForm";
    }

    @RequestMapping("courseform/{courseId}")
    public ModelAndView test(@PathVariable String courseId,ServletRequest request){
        List<Evaluate> evaluateList = null;
        evaluateList = teacherService.otherEvaluate(courseId);
        request.setAttribute("evaluateform",evaluateList);
        return new ModelAndView("evaluateForm");
    }
}
