package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.service.AdministratorService;
import edu.cs.hrbnu.uitl.PathUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
    @RequestMapping("getEvaluateProblems")
    public ModelAndView showProblems(HttpServletRequest request,Model model){
    List<EvaluateProblem> problemList=administratorService.getAllEvaluateProblems();
    if (problemList==null){
        model.addAttribute("problems",null);
    }else{
        model.addAttribute("problems",problemList);
    }
    return new ModelAndView("evaluateProblems");
    }

    @RequestMapping("addEvaluateProblems")
    public ModelAndView addProblems(EvaluateProblem evaluateProblem,Model model){
         administratorService.addProblem(evaluateProblem);

        List<EvaluateProblem> problemList=administratorService.getAllEvaluateProblems();
        if (problemList==null){
            model.addAttribute("problems",null);
        }else{
            model.addAttribute("problems",problemList);
        }

        return new ModelAndView("evaluateProblems") ;
    }

    @RequestMapping("alert/{id}")
    public ModelAndView alertProblem(@PathVariable int id, Model model,@RequestParam(value = "alertText") String alertText){
        List<EvaluateProblem> problemList=administratorService.getAllEvaluateProblems();

        for (int i=0;i< problemList.size();i++) {
            EvaluateProblem evaluateProblem = problemList.get(i);
            if (evaluateProblem.getId()==id){
                System.out.println("in to");
               administratorService.alterProblem(id,alertText);
            }
        }
        List<EvaluateProblem> problemList2=administratorService.getAllEvaluateProblems();
        if (problemList2==null){
            model.addAttribute("problems",null);
        }else{
            model.addAttribute("problems",problemList2);
        }

        return new ModelAndView("evaluateProblems") ;
    }


}
