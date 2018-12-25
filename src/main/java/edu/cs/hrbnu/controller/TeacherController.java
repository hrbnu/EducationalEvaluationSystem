package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.*;
import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.EvaluateMapper;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.service.SystemService;
import edu.cs.hrbnu.service.TeacherService;
import edu.cs.hrbnu.uitl.ExcelUitl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.OutputStream;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@SessionAttributes({"TeacherInfo","complaints"})
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
            modelAndView.setViewName("teacher/reset");
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
        Course course = teacherService.getCourseById(courseId);
        model.addAttribute("course", course);
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
        if (flag.equals("2") || flag.equals("3") || flag.equals("4")){
            if (teacherService.evaluateTeacher(evaluate) == 1){
                model.addAttribute("message", "评价成功");
                model.addAttribute("url", "/teacher/getNeedToEvaluateCourseByTeacher");
                return new ModelAndView("showMessage");
            }
        }
        model.addAttribute("message", "评价失败");
        model.addAttribute("url", "/teacher/getNeedToEvaluateCourseByTeacher");
        return new ModelAndView("showMessage");

    }
    
    @RequestMapping("exportEvaluate/{teacherId}")
    public ModelAndView exportEvaluate(@PathVariable String teacherId, HttpServletResponse response){
        List<Evaluate> evaluateList = teacherService.exportEvaluateForm(teacherId);
        if(evaluateList == null || evaluateList.size() == 0){
            return new ModelAndView("wrong");
        }

        // 标题
        String[] title = {"课程编号","课程评价","课程评分"};
        // 唯一化excel表名
        String fileName = teacherId+"评价表"+System.currentTimeMillis()+".xlsx";
        String sheetName = "Sheet1";

        // 构造excel主要内容
        String[][] content = new String[evaluateList.size()][title.length];
        for(int i = 0;i < evaluateList.size();i++){
            Evaluate evaluate = evaluateList.get(i);
            content[i][0] = evaluate.getCourseId();
            content[i][1] = evaluate.getEvaluateContent();
            content[i][2] = ""+evaluate.getEvaluateScore();
        }

        // 工具类获取Workbook对象
        XSSFWorkbook wb = ExcelUitl.getXSSFWorkbook(sheetName,title,content);

        // 下载-因为IO流，name需要额外转换
        try{
            fileName = new String(fileName.getBytes(),"ISO8859-1");
        }catch (Exception ex){
            ex.printStackTrace();
        }

        // 下载-响应头设置
        response.setContentType("application/octet-stream;charset=ISO8859-1");
        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");

        // 直接在原页面下载，所以返回值为空即可
        try{
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return null;
    }

    @RequestMapping("/login")
    public ModelAndView login(String teacherId, String password, ModelMap modelMap,HttpSession session){
        //ModelMap参数是将查找到的teacher对象放到后台的session下
        Teacher teacher = teacherService.login(teacherId,password);
        ModelAndView modelAndView = new ModelAndView();
        if(teacher != null){
            modelAndView.setViewName("teacher/admin");
            modelMap.addAttribute("TeacherInfo",teacher);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentLoginTime = simpleDateFormat.format(new Date());
            Date lastLoginTimed = teacher.getLastLoginTime();
            String lastLoginTime = simpleDateFormat.format(lastLoginTimed);
            List<Complaint> complaints = teacherService.alertComplaint(teacherId,lastLoginTime,currentLoginTime);
            System.out.println(complaints.size());
            modelMap.addAttribute("complaints",complaints);
            session.setAttribute("teacherId",teacherId);
            teacherService.updateLastLoginTime(currentLoginTime,teacherId);
        } else{
            String loginMessage = "工号或密码错误";
            modelAndView.addObject("loginMessage",loginMessage);
            modelAndView.setViewName("teacher/loginC");
        }

        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(SessionStatus status)
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("teacher/loginC");
        status.setComplete();
        return modelAndView;
    }

    //插入评价请求
    @RequestMapping("/insertListenClass")
    public String insertListen(String isListeneredTeacherId,String courseName,Model model,HttpSession session){

        if(teacherService.submitListen((String)session.getAttribute("teacherId"),isListeneredTeacherId,courseName)){
            return "teacher/requestInsertSuccess";
        }
        model.addAttribute("teachers",removeCurrentTeacher((String)session.getAttribute("teacherId")));
        model.addAttribute("msg",false);
        return "teacher/ClassRequestInsert";
    }

    //得到申请信息
    @RequestMapping("/confirm")
    public String confirmClassListen(HttpSession session,Model model ){
        String teacherId = (String)session.getAttribute("teacherId");
        model.addAttribute("confimMessage",teacherService.confirm(teacherId));
        return "teacher/confirm";
    }
    //保存评价请求
    @RequestMapping("/saveRequest")
    public String addTeacherEvaluateRecord(String courseId,String evaluateTeacherId,int classRequestRecordId,HttpSession session,Model model){
        Evaluate evaluate  = new Evaluate();
        evaluate.setCourseId(courseId);
        evaluate.setFlagId(evaluateTeacherId);
        evaluate.setAlreadyEvaluate(false);
        evaluate.setFlag("2");
        teacherService.updateListen(classRequestRecordId);
        teacherService.evaluateTeacher(evaluate);
        String teacherId = (String)session.getAttribute("teacherId");
        model.addAttribute("confimMessage",teacherService.confirm(teacherId));
        return "teacher/confirmSuccess";
    }
    //获取老师待评价的课程
    @RequestMapping("/getNeedToEvaluateCourseByTeacher")
    public String getNeedToEvaluateCourseByTeacher(Model model,HttpSession session){
        String teacherId = (String)session.getAttribute("teacherId");
        model.addAttribute("tempMessage",teacherService.getNeedToEvaluateMessage(teacherId));
        return "teacher/teachNeedToEvaluateCourse";
    }
    //申请听课
    @RequestMapping("/applicatinListen")
    public String applicationListen(Model model,HttpSession session){
        List<Teacher> teachers = teacherService.getAllTeacherName();
        model.addAttribute("teachers",removeCurrentTeacher((String)session.getAttribute("teacherId")));
        return "teacher/ClassRequestInsert";
    }
    //得到教师所教授的课程 (还不会异步，目前直接刷新界面）
    @RequestMapping("/getCourse")
    public String getCourseByTeacherId(Model model,String isListeneredTeacherId,HttpSession session){
        model.addAttribute("courses",teacherService.getCourseByTeahcer(isListeneredTeacherId));

        model.addAttribute("teachers",removeCurrentTeacher((String)session.getAttribute("teacherId")));
        model.addAttribute("selectTeacher",teacherService.getSingleTeacherInfo(isListeneredTeacherId));
        return "teacher/ClassRequestInsert";
    }

    //选择评价老师时，移除自身
    public List<Teacher> removeCurrentTeacher(String teacherAccount){
        List<Teacher> teachers = teacherService.getAllTeacherName();
        Iterator<Teacher> iterable = teachers.iterator();
        //移除自身
        while(iterable.hasNext()){
            if(iterable.next().getTeacherId().equals(teacherAccount)){
                iterable.remove();
            }
        }

        return teachers;
    }
}
