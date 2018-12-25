package edu.cs.hrbnu.controller;

import edu.cs.hrbnu.model.*;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/student")
@SessionAttributes("StudentInfo")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /*学生的评分相关
    *test ip: http://localhost:8080/student/evalu?studentId=2016040222&courseId=201603001&flag=1
    *history: http://localhost:8080/student/evalu?studentId=2016040222&courseId=201603001&flag=5*/
    @RequestMapping("/evalu")
    public ModelAndView evaluation(Model model, String studentId, String courseId, String flag) {
        model.addAttribute("studentId", studentId);
        model.addAttribute("courseId", courseId);
        model.addAttribute("flag", flag);
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        model.addAttribute("listEvaluateProblem", listEvaluateProblem);
        return new ModelAndView("student/evalu");
    }

    @RequestMapping("/evaluScoreCaculate")
    public ModelAndView evaluationScoreCaculate(@RequestParam("otherContent")String evaluateContent,
                                                HttpServletRequest request, Model model,
                                                @RequestParam("studentId") String studentId,
                                                @RequestParam("courseId") String courseId,
                                                @RequestParam("flag") String flag) {
        double thisCourseScore = 0.0;
        List<EvaluateProblem> listEvaluateProblem = studentService.getEvaluateProblem();
        for (EvaluateProblem evaluateProblem:listEvaluateProblem) {
            thisCourseScore = thisCourseScore + Double.valueOf(request.getParameter(String.valueOf(evaluateProblem.getId())));
        }
        if (flag.equals("1") || flag.equals("5")) {
            if (studentService.evaluateCurrentCourse(studentId, courseId, thisCourseScore, evaluateContent, flag) == 1){
                if (flag.equals("5")) {
                    studentService.updateHistoryByStudentIdAndCourseId(studentId, courseId);
                }else{
                    studentService.updateCourseTimeByStudentIdAndCourseId(studentId, courseId);
                }
                model.addAttribute("message", "评价成功");
                model.addAttribute("url", "/student/getCurrentCourse");
                return new ModelAndView("showMessage");
            }
        }
        model.addAttribute("message", "失败成功");
        model.addAttribute("url", "/student/getCurrentCourse");
        return new ModelAndView("showMessage");
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
                                        @RequestParam("courseId") String courseId,
                                        Model model) {
//        System.out.println(studentId + courseId);
        if (studentService.complaint(studentId, courseId, complaintContent) == 0) {
            model.addAttribute("message", "投诉成功");
            model.addAttribute("url", "/student/getCurrentCourseToComplain");
            return new ModelAndView("showMessage");
        }else {
            model.addAttribute("message", "投诉成功");
            model.addAttribute("url", "/student/getCurrentCourseToComplain");
            return new ModelAndView("showMessage");
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
            modelAndView.setViewName("student/reset");
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
            modelAndView.setViewName("student/updatePassword");
        }
        return modelAndView;
    }

    @RequestMapping("/login")
    public ModelAndView login(String studentId, String password, ModelMap modelMap,HttpSession session){
        Student student = studentService.login(studentId,password);
        ModelAndView modelAndView = new ModelAndView();
        if(student == null){
            String loginMessage = "学号或密码错误！";
            modelAndView.addObject("loginMessage",loginMessage);
            modelAndView.setViewName("student/loginB");
        }else{
            session.setAttribute("studentId", studentId);
            modelMap.addAttribute("StudentInfo",student);
            modelAndView.setViewName("student/admin");
        }
        return modelAndView;
    }

    @RequestMapping("/studentLogin")
    public String studentLogin(String studentId, String password, HttpSession httpSession, Model model){
        Student student = studentService.login(studentId, password);
        if(student ==null){
            model.addAttribute("loginState", false);
            return "../index";
        }else{
            httpSession.setAttribute("studentId", studentId);
            return "studentLogin";
        }
    }

    @RequestMapping("logout")
    public ModelAndView logout(SessionStatus status) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("student/loginB");
        status.setComplete();
        return modelAndView;
    }



    @RequestMapping("/getCurrentCourse")
    public String getCurrentCourse(HttpServletRequest request, Model model){
        String studentId = (String)request.getSession().getAttribute("studentId");
        System.out.println(studentId);
        model.addAttribute("currentCourse", studentService.getEvaluateCurrentCourse(studentId));
        return "student/currentCourseEvaluate";

    }

    /*yaque
    ================*/
    @RequestMapping("/getCurrentCourseToComplain")
    public String getCurrentCourseToComplain(HttpServletRequest request, Model model){
        String studentId = (String)request.getSession().getAttribute("studentId");
        List<Complaint> complaintList = studentService.getComplaintByStudentId(studentId);
        List<StudentCourseTemp> studentCourseTempList = studentService.getEvaluateCurrentCourse(studentId);
        System.out.println(studentCourseTempList.size() + "  " +complaintList.size());
        for (int i = 0; i < studentCourseTempList.size(); i ++) {
            for (Complaint complaint : complaintList) {
                if (studentCourseTempList.get(i).getStudentCourse().getCourseId().equals(complaint.getCourseId())) {
                    studentCourseTempList.remove(i);
                }
            }
        }
        model.addAttribute("currentCourseToComplain",studentCourseTempList);
        return "student/currentCourseComplain";
    }

    /*================*/

    @RequestMapping("/getHistoryCourse")
    public String getHistoryCourse(Model model,HttpServletRequest request){
        String studentId = (String)request.getSession().getAttribute("studentId");
        model.addAttribute("historyCourse", studentService.getEvaluateHistoryCourses(studentId));
        return "student/historyCourseEvaluate";
    }

}
