package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

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
}
