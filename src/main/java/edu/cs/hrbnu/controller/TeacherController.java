package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.EvaluateMapper;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.SystemService;
import edu.cs.hrbnu.service.TeacherService;
import edu.cs.hrbnu.uitl.ExcelUitl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/reset")
    public ModelAndView reset(Teacher teacher){
        boolean isSuccess = teacherService.reset(teacher);
        ModelAndView modelAndView = new ModelAndView();
        if(isSuccess){
            modelAndView.setViewName("success");
        } else {
            String resetMessage = "工号或身份证号错误";
            modelAndView.addObject("resetMessage",resetMessage);
            modelAndView.setViewName("teacher");
        }
        return modelAndView;
    }
    @RequestMapping("/updatePassword")
    public ModelAndView updatePassword(Teacher teacher, @RequestParam("newPassword") String newPassword){
        boolean isSuccess = teacherService.updatePassword(teacher.getTeacherId(),teacher.getPassword(),newPassword);
        ModelAndView modelAndView = new ModelAndView();
        if(isSuccess){
            modelAndView.setViewName("success");
        } else {
            String updateMessage = "工号或密码错误";
            modelAndView.addObject("updateMessage",updateMessage);
            modelAndView.setViewName("teacher");
        }
        return modelAndView;
    }

    /*教师的评分相关
    *test ip: http://localhost:8080/teacher/evalu?teacherId=100100&courseId=201603001&flag=4*/
    @RequestMapping("/evalu")
    public ModelAndView evaluation(Model model, String teacherId, String courseId, String flag) {
        model.addAttribute("teacherId", teacherId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("flag", flag);
        List<EvaluateProblem> listEvaluateProblem = teacherService.getEvaluateProblem();
        model.addAttribute("listEvaluateProblem", listEvaluateProblem);
        return new ModelAndView("teacher/evalu");
    }

    @RequestMapping("/evaluScoreCaculate")
    public ModelAndView evaluationScoreCaculate(@RequestParam("otherContent")String evaluateContent,
                                                HttpServletRequest request, Model model,
                                                @RequestParam("teacherId") String teacherId,
                                                @RequestParam("courseId") String courseId,
                                                @RequestParam("flag") String flag) {
        double thisCourseScore = 0.0;
        List<EvaluateProblem> listEvaluateProblem = teacherService.getEvaluateProblem();
        for (EvaluateProblem evaluateProblem:listEvaluateProblem) {
            thisCourseScore = thisCourseScore + Double.valueOf(request.getParameter(String.valueOf(evaluateProblem.getId())));
        }
        Evaluate evaluate = new Evaluate();
        evaluate.setCourseId(courseId);
        evaluate.setEvaluateContent(evaluateContent);
        evaluate.setEvaluateScore(thisCourseScore);
        evaluate.setFlag(flag);
        evaluate.setFlagId(teacherId);
        if (teacherService.evaluateTeacher(evaluate) == 0){
            return new ModelAndView("wrong");
        }else {
            return new ModelAndView("success");
        }
    }
}
