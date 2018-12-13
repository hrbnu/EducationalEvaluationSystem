package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.EvaluateMapper;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import edu.cs.hrbnu.uitl.ExcelUitl;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

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
}
