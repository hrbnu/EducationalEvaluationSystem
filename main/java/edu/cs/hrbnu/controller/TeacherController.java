package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.Complaint;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@SessionAttributes({"TeacherInfo","complaints"})
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

    @RequestMapping("/login")
    public ModelAndView login(String teacherId, String password,ModelMap modelMap){
        //ModelMap参数是将查找到的teacher对象放到后台的session下
        Teacher teacher = teacherService.login(teacherId,password);
        ModelAndView modelAndView = new ModelAndView();
        if(teacher != null){
            modelAndView.setViewName("TeacherInfo");
            modelMap.addAttribute("TeacherInfo",teacher);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentLoginTime = simpleDateFormat.format(new Date());
            Date lastLoginTimed = teacher.getLastLoginTime();
            String lastLoginTime = simpleDateFormat.format(lastLoginTimed);
            List<Complaint> complaints = teacherService.alertComplaint(teacherId,lastLoginTime,currentLoginTime);
            modelMap.addAttribute("complaints",complaints);
            teacherService.updateLastLoginTime(currentLoginTime,teacherId);
        } else{
            String loginMessage = "工号或密码错误";
            modelAndView.addObject("loginMessage",loginMessage);
            modelAndView.setViewName("teacher");
        }

        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(SessionStatus status)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        status.setComplete();
        return modelAndView;
    }
}
