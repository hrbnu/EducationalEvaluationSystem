package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.faces.annotation.RequestMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*学生的评分相关
    *test ip: http://localhost:8080/student/evalu?studentId=2016040222&courseId=201603001*/
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

    /*学生的投诉
    * test ip:http://localhost:8080/student/complaint?studentId=2016040222&courseId=201603001
    * 注意测试学生投诉由于表的外键关联，版测试链接美提交一次需要删除一次数据库，下次才可以重新测试*/
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

}
