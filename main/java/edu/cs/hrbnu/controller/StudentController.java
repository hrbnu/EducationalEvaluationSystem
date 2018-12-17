package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/student")
@SessionAttributes("StudentInfo")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*学生的评分相关*/
    @RequestMapping("/evalu")
    public ModelAndView evaluation(Model model, String studentId, String courseId) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("courseId", courseId);
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        model.addAttribute("listEvaluateProblem", listEvaluateProblem);
        return new ModelAndView("student/evalu");
    }

    @RequestMapping("/evaluScoreCaculate")
    public ModelAndView evaluationScoreCaculate(@RequestParam("otherContent")String evaluateContent,
                                                HttpServletRequest request, Model model,
                                                @RequestParam("studentId") String studentId,
                                                @RequestParam("courseId") String courseId) {
        double thisCourseScore = 0.0;
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        for (EvaluateProblem evaluateProblem:listEvaluateProblem) {
            thisCourseScore = thisCourseScore + Double.valueOf(request.getParameter(String.valueOf(evaluateProblem.getId())));
        }
        if (studentService.evaluateCurrentCourse(studentId, courseId, thisCourseScore, evaluateContent) == 0){
            return new ModelAndView("wrong");
        }else {
            return new ModelAndView("success");
        }
    }

    /*学生的投诉*/
    @RequestMapping("/complaint")
    public ModelAndView complaint(Model model, String studentId, String courseId) {
//        studentId = "2016040888";
//        courseId = "201601002";
//        System.out.println(studentId + courseId);
        model.addAttribute("studentId", studentId);
        model.addAttribute("courseId", courseId);
        return new ModelAndView("student/compl");
    }

    @RequestMapping("/submitComplaint")
    public ModelAndView submitComplaint(@RequestParam("complaintContent")String complaintContent,
                                        @RequestParam("studentId") String studentId,
                                        @RequestParam("courseId") String courseId) {
//        System.out.println(studentId + courseId);
        if (studentService.complaint(studentId, courseId, complaintContent) == 0) {
            return new ModelAndView("wrong");
        }else {
            return new ModelAndView("success");
        }

    }




    @RequestMapping(value = "/reset")
    public ModelAndView reset(Student student){
        boolean isSuccess = studentService.reset(student);
        ModelAndView modelAndView = new ModelAndView();
        if(isSuccess){
            modelAndView.setViewName("success");
        } else {
            String resetMessage = "学号或身份证号错误";
            modelAndView.addObject("resetMessage",resetMessage);
            modelAndView.setViewName("student");
        }
        return modelAndView;
    }

    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(Student student,@RequestParam("newPassword") String newPassword){
        boolean isSuccess = studentService.updatePassword(student.getStudentId(),student.getPassword(),newPassword);
        ModelAndView modelAndView = new ModelAndView();
        if(isSuccess){
            modelAndView.setViewName("success");
        } else {
            String updateMessage = "学号或密码错误";
            modelAndView.addObject("updateMessage",updateMessage);
            modelAndView.setViewName("student");
        }
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(String studentId, String password, ModelMap modelMap){
        Student student = studentService.login(studentId,password);
        ModelAndView modelAndView = new ModelAndView();
        if(student == null){
            String loginMessage = "学号或密码错误！";
            modelAndView.addObject("loginMessage",loginMessage);
            modelAndView.setViewName("student");
        }else{

            modelMap.addAttribute("StudentInfo",student);
            modelAndView.setViewName("StudentInfo");
        }
        return modelAndView;
    }

    @RequestMapping("logout")
    public ModelAndView logout(SessionStatus status)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        status.setComplete();
        return modelAndView;
    }

}
