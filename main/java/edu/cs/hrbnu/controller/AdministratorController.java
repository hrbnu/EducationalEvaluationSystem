package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.service.AdministratorService;
import edu.cs.hrbnu.uitl.PathUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import java.io.File;

@Controller
@RequestMapping("/admin")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @RequestMapping("addStudentByExcel")
    public ModelAndView addStudentByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile){
        if(!multipartFile.isEmpty()){
            // 获取保存路径并保存
            String path = request.getServletContext().getRealPath("/");
            path = PathUitl.getExcelSavePath(path);
            String name = multipartFile.getOriginalFilename();
            File file = new File(path,name);
            try{
                multipartFile.transferTo(file);
            }catch (Exception ex){
                ex.printStackTrace();
                return new ModelAndView("wrong");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importStudentByExcel(filePath);
            if(flag){
                return new ModelAndView("success");
            }
        }
        return new ModelAndView("wrong");
    }

    @RequestMapping("addTeacherByExcel")
    public ModelAndView addTeacherByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile){
        if(!multipartFile.isEmpty()){
            String path = request.getServletContext().getRealPath("/");
            path = PathUitl.getExcelSavePath(path);
            String name = multipartFile.getOriginalFilename();
            File file = new File(path,name);
            try{
                multipartFile.transferTo(file);
            }catch (Exception ex){
                ex.printStackTrace();
                return new ModelAndView("wrong");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importTeacherByExcel(filePath);
            if(flag){
                return new ModelAndView("success");
            }
        }
        return new ModelAndView("wrong");
    }

    @RequestMapping("addCourseByExcel")
    public ModelAndView addCourseByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile){
        if(!multipartFile.isEmpty()){
            String path = request.getServletContext().getRealPath("/");
            path = PathUitl.getExcelSavePath(path);
            String name = multipartFile.getOriginalFilename();
            File file = new File(path,name);
            try{
                multipartFile.transferTo(file);
            }catch (Exception ex){
                ex.printStackTrace();
                return new ModelAndView("wrong");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importCourseByExcel(filePath);
            if(flag){
                return new ModelAndView("success");
            }
        }
        return new ModelAndView("wrong");
    }
}
