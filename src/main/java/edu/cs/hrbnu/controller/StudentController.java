package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/evalu")
    public ModelAndView evaluation(Model model, Student student, Course course) {
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        model.addAttribute("listEvaluateProblem", listEvaluateProblem);
        return new ModelAndView("evalu/evalu");
    }

    @RequestMapping("/evaluScoreCaculate")
    public ModelAndView evaluationScoreCaculate(HttpServletRequest request, Model model, Student student, Course course) {
        double thisCourseCores = 0.0;
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        for (EvaluateProblem evaluateProblem:listEvaluateProblem) {
            thisCourseCores = thisCourseCores + Double.valueOf(request.getParameter(String.valueOf(evaluateProblem.getId())));
        }
        return new ModelAndView("success");
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

}
