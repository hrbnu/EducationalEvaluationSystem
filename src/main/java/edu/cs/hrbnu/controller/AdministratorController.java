package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.*;
import edu.cs.hrbnu.service.AdministratorService;
import edu.cs.hrbnu.uitl.PathUitl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/admin")
@SessionAttributes("administratorInfo")
public class AdministratorController {
    @Autowired
    AdministratorService administratorService;

    @RequestMapping("addStudentByExcel")
    public ModelAndView addStudentByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile,Model model){
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
                model.addAttribute("retStatus",1);
                return new ModelAndView("/administrator/importStudent");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importStudentByExcel(filePath);
            if(flag){
                model.addAttribute("retStatus",2);
                return new ModelAndView("/administrator/importStudent");
            }
        }
        model.addAttribute("retStatus",1);
        return new ModelAndView("/administrator/importStudent");
    }

    @RequestMapping("addTeacherByExcel")
    public ModelAndView addTeacherByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile,Model model){
        if(!multipartFile.isEmpty()){
            String path = request.getServletContext().getRealPath("/");
            path = PathUitl.getExcelSavePath(path);
            String name = multipartFile.getOriginalFilename();
            File file = new File(path,name);
            try{
                multipartFile.transferTo(file);
            }catch (Exception ex){
                ex.printStackTrace();
                model.addAttribute("retStatus",1);
                return new ModelAndView("/administrator/importTeacher");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importTeacherByExcel(filePath);
            if(flag){
                model.addAttribute("retStatus",2);
                return new ModelAndView("/administrator/importTeacher");
            }
        }
        model.addAttribute("retStatus",1);
        return new ModelAndView("/administrator/importTeacher");
    }

    @RequestMapping("addCourseByExcel")
    public ModelAndView addCourseByExcel(ServletRequest request, @RequestParam(value = "excel") MultipartFile multipartFile,Model model){
        if(!multipartFile.isEmpty()){
            String path = request.getServletContext().getRealPath("/");
            path = PathUitl.getExcelSavePath(path);
            String name = multipartFile.getOriginalFilename();
            File file = new File(path,name);
            try{
                multipartFile.transferTo(file);
            }catch (Exception ex){
                ex.printStackTrace();
                model.addAttribute("retStatus",1);
                return new ModelAndView("/administrator/importCourse");
            }

            String filePath = path+"/"+name;
            boolean flag = administratorService.importCourseByExcel(filePath);
            if(flag){
                model.addAttribute("retStatus",2);
                return new ModelAndView("/administrator/importCourse");
            }
        }
        model.addAttribute("retStatus",1);
        return new ModelAndView("/administrator/importCourse");
    }

    @RequestMapping("getEvaluateProblems")
    public ModelAndView showProblems(HttpServletRequest request, Model model){
        List<EvaluateProblem> problemList=administratorService.getAllEvaluateProblems();
        if (problemList==null){
            model.addAttribute("problems",null);
        }else{
            model.addAttribute("problems",problemList);
        }
        return new ModelAndView("/administrator/evaluateProblems");
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

        return new ModelAndView("/administrator/evaluateProblems") ;
    }

    @RequestMapping("alert/{id}")
    public ModelAndView alertProblem(@PathVariable int id, Model model, @RequestParam(value = "alertText") String alertText){
        List<EvaluateProblem> problemList=administratorService.getAllEvaluateProblems();

        for (int i=0;i< problemList.size();i++) {
            EvaluateProblem evaluateProblem = problemList.get(i);
            if (evaluateProblem.getId()==id){
                model.addAttribute("flag",true);
                administratorService.alterProblem(id,alertText);
                System.out.println("修改成功");
            }else
                model.addAttribute("flag",false);
        }
        List<EvaluateProblem> problemList2=administratorService.getAllEvaluateProblems();
        if (problemList2==null){
            model.addAttribute("problems",null);
        }else{
            model.addAttribute("problems",problemList2);
        }

        return new ModelAndView("/administrator/evaluateProblems") ;
    }


    /**
     * 学生
     * @param pageNow
     * @param student
     * @return
     */
    @RequestMapping(value = "/searchStudentByCondition")
    public ModelAndView searchStudentByCondition(String pageNow, Student student,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        List<Student> studentInfoList = new ArrayList<Student>();
        List<Student> studentPosList = new ArrayList<Student>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有学生的信息
        if(student.getDepartment() == null && student.getGrade() == 0
                && student.getClassId() == 0){
            studentInfoList = administratorService.selectAllStudentInfo();
            totalCount = administratorService.selectStudentCount();
        } else {
            if(student.getGrade() != 0 && student.getGrade() < 5){
                //将学生的年级转化为2016的格式
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH) + 1;
                if(currentMonth < 9){
                    student.setGrade(currentYear - student.getGrade());
                } else {
                    student.setGrade(currentYear - student.getGrade() + 1);
                }
            }
            if(student.getGrade() == 5){
                student.setGraduation(true);
                studentInfoList = administratorService.selectGraduatedStudentByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
                totalCount = administratorService.selectGraduatedStudentCountByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
            } else{
                studentInfoList = administratorService.selectStudentByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
                totalCount = administratorService.selectStudentCountByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
            }
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            studentPosList.add(studentInfoList.get(i));
        }
        boolean isEmpty = false;
        if(studentInfoList.isEmpty()){
            isEmpty = true;
        }
        if(student.getGrade() != 0 && student.getGrade() != 5){
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            if(currentMonth < 9){
                student.setGrade(currentYear - student.getGrade());
            } else {
                student.setGrade(currentYear - student.getGrade() + 1);
            }
        }
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/studentSearch");
        return mav;
    }

    @RequestMapping("/deleteSingleStudent")
    private ModelAndView deleteSingleStudent(String studentId,String pageNow, Student student,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        administratorService.deleteSingleStudent(studentId);
        List<Student> studentInfoList = new ArrayList<Student>();
        List<Student> studentPosList = new ArrayList<Student>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有学生的信息
        if(student.getDepartment() == null && student.getGrade() == 0
                && student.getClassId() == 0){
            studentInfoList = administratorService.selectAllStudentInfo();
            totalCount = administratorService.selectStudentCount();
        } else {
            if(student.getGrade() != 0 && student.getGrade() < 5){
                //将学生的年级转化为2016的格式
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH) + 1;
                if(currentMonth < 9){
                    student.setGrade(currentYear - student.getGrade());
                } else {
                    student.setGrade(currentYear - student.getGrade() + 1);
                }
            }
            if(student.getGrade() == 5){
                student.setGraduation(true);
                studentInfoList = administratorService.selectGraduatedStudentByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
                totalCount = administratorService.selectGraduatedStudentCountByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
            } else{
                studentInfoList = administratorService.selectStudentByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
                totalCount = administratorService.selectStudentCountByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
            }
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            studentPosList.add(studentInfoList.get(i));
        }
        boolean isEmpty = false;
        if(studentInfoList.isEmpty()){
            isEmpty = true;
        }
        if(student.getGrade() != 0 && student.getGrade() != 5){
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            if(currentMonth < 9){
                student.setGrade(currentYear - student.getGrade());
            } else {
                student.setGrade(currentYear - student.getGrade() + 1);
            }
        }
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/studentSearch");
        return mav;
    }

    @RequestMapping("/updateSingleStudent")
    private ModelAndView updateSingleStudent(String oldStudentId,String studentId,String pageNow,
                                             Student student,String state,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        //修改单条学生页面
        if(studentId != null && state == null){
            Student studentInfo = administratorService.selectSingleStudentInfo(studentId);
            mav.setViewName("administrator/singleStudentUpdatePage");
            mav.addObject("studentInfo",studentInfo);
            return mav;
        }
        List<Student> studentInfoList = new ArrayList<Student>();
        List<Student> studentPosList = new ArrayList<Student>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有学生的信息
        if(student.getDepartment() == null && student.getGrade() == 0
                && student.getClassId() == 0 && state == null){
            studentInfoList = administratorService.selectAllStudentInfo();
            totalCount = administratorService.selectStudentCount();
        } else if(state != null) {
            //修改学生信息
            administratorService.updateSingleStudent(student,oldStudentId);
            studentInfoList = administratorService.selectAllStudentInfo();
            totalCount = administratorService.selectStudentCount();
        }else{
            if(student.getGrade() != 0 && student.getGrade() < 5){
                //将学生的年级转化为2016的格式
                Calendar calendar = Calendar.getInstance();
                int currentYear = calendar.get(Calendar.YEAR);
                int currentMonth = calendar.get(Calendar.MONTH) + 1;
                if(currentMonth < 9){
                    student.setGrade(currentYear - student.getGrade());
                } else {
                    student.setGrade(currentYear - student.getGrade() + 1);
                }
            }
            if(student.getGrade() == 5){
                student.setGraduation(true);
                studentInfoList = administratorService.selectGraduatedStudentByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
                totalCount = administratorService.selectGraduatedStudentCountByCondition(student.getDepartment(),
                        student.isGraduation(),student.getClassId());
            } else{
                studentInfoList = administratorService.selectStudentByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
                totalCount = administratorService.selectStudentCountByCondition(student.getDepartment(),
                        student.getGrade(),student.getClassId());
            }
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            studentPosList.add(studentInfoList.get(i));
        }
        boolean isEmpty = false;
        if(studentInfoList.isEmpty()){
            isEmpty = true;
        }
        if(student.getGrade() != 0 && student.getGrade() != 5){
            Calendar calendar = Calendar.getInstance();
            int currentYear = calendar.get(Calendar.YEAR);
            int currentMonth = calendar.get(Calendar.MONTH) + 1;
            if(currentMonth < 9){
                student.setGrade(currentYear - student.getGrade());
            } else {
                student.setGrade(currentYear - student.getGrade() + 1);
            }
        }
        String update = "update";
        mav.addObject("update",update);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/studentSearch");
        return mav;
    }

    @RequestMapping(value = "/insertSingleStudent")
    public ModelAndView insertSingleStudent(Student student,String state,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        if(student.getStudentId() == "" && state != null){
            String message = "请输入正确的信息";
            mav.addObject("message",message);
        }else if(state != null){
            //自动设置密码为身份证后六位
            //院系为专业
            //默认学生状态为在校
            boolean isSuccess = administratorService.insertStudent(student);
            String successMessage;
            if(!isSuccess){
                successMessage = "学生信息已存在！";
            } else {
                //返回页面
                successMessage = "添加学生信息成功！";
            }
            mav.addObject("successMessage",successMessage);
        }
        mav.setViewName("administrator/singleStudentInsert");
        return mav;
    }

    /**
     * 教师
     */
    @RequestMapping(value = "/searchTeacherByCondition")
    public ModelAndView searchTeacherByCondition(String pageNow, Teacher teacher, HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        List<Teacher> teacherInfoList = new ArrayList<Teacher>();
        List<Teacher> teacherPosList = new ArrayList<Teacher>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有教师的信息
        if(teacher.getTitle() == null && !teacher.isLeaderType() && !teacher.isMonitorType() && !teacher.isTeacherType()){
            teacherInfoList = administratorService.selectAllTeacherInfo();
            totalCount = administratorService.selectTeacherCount();
        } else {
            //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
            if(teacher.getTitle().equals("teachingStar")){
                teacher.setTitle("教学新星");
            }
            if(teacher.getTitle().equals("fastestProgress")){
                teacher.setTitle("进步最快");
            }
            if(teacher.getTitle().equals("lastHelp")){
                teacher.setTitle("末位帮扶");
            }
            teacherInfoList = administratorService.selectTeacherByCondition(teacher);
            totalCount = administratorService.selectTeacherCountByCondition(teacher);
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            teacherPosList.add(teacherInfoList.get(i));
        }
        boolean isEmpty = false;
        if(teacherInfoList.isEmpty()){
            isEmpty = true;
        }
        //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
        if(teacher.getTitle() != null){
            if(teacher.getTitle().equals("教学新星")){
                teacher.setTitle("teachingStar");
            }
            if(teacher.getTitle().equals("进步最快")){
                teacher.setTitle("fastestProgress");
            }
            if(teacher.getTitle().equals("末位帮扶")){
                teacher.setTitle("lastHelp");
            }
        }
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/teacherSearch");
        return mav;
    }

    @RequestMapping("/deleteSingleTeacher")
    private ModelAndView deleteSingleTeacher(String teacherId,String pageNow, Teacher teacher,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        administratorService.deleteSingleTeacher(teacherId);
        List<Teacher> teacherInfoList = new ArrayList<Teacher>();
        List<Teacher> teacherPosList = new ArrayList<Teacher>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有教师的信息
        if(teacher.getTitle() == null && !teacher.isLeaderType() && !teacher.isMonitorType() && !teacher.isTeacherType()){
            teacherInfoList = administratorService.selectAllTeacherInfo();
            totalCount = administratorService.selectTeacherCount();
        } else {
            //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
            if(teacher.getTitle().equals("teachingStar")){
                teacher.setTitle("教学新星");
            }
            if(teacher.getTitle().equals("fastestProgress")){
                teacher.setTitle("进步最快");
            }
            if(teacher.getTitle().equals("lastHelp")){
                teacher.setTitle("末位帮扶");
            }
            teacherInfoList = administratorService.selectTeacherByCondition(teacher);
            totalCount = administratorService.selectTeacherCountByCondition(teacher);
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            teacherPosList.add(teacherInfoList.get(i));
        }
        boolean isEmpty = false;
        if(teacherInfoList.isEmpty()){
            isEmpty = true;
        }
        //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
        if(teacher.getTitle() != null){
            if(teacher.getTitle().equals("教学新星")){
                teacher.setTitle("teachingStar");
            }
            if(teacher.getTitle().equals("进步最快")){
                teacher.setTitle("fastestProgress");
            }
            if(teacher.getTitle().equals("末位帮扶")){
                teacher.setTitle("lastHelp");
            }
        }
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/teacherSearch");
        return mav;
    }

    @RequestMapping(value = "/insertSingleTeacher")
    public ModelAndView insertSingleTeacher(Teacher teacher,String state,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        if(teacher.getTeacherId() == "" && state != null){
            String message = "请输入正确的信息";
            mav.addObject("message",message);
        } else if(state != null){
            //自动设置密码为身份证后六位
            //返回页面
            String successMessage;
            boolean isSuccess =  administratorService.insertTeacher(teacher);
            if(!isSuccess){
                successMessage = "教师信息已存在！";
            } else {
                //返回页面
                successMessage = "添加教师信息成功！";
            }
            mav.addObject("successMessage",successMessage);
        }
        mav.setViewName("administrator/singleTeacherInsert");
        return mav;
    }

    @RequestMapping("/updateSingleTeacher")
    private ModelAndView updateSingleTeacher(String teacherId,String pageNow, Teacher teacher,
                                             String state,String oldTeacherId,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        //修改单条教师页面
        if(teacherId != null && state == null){
            Teacher teacherInfo = administratorService.selectSingleTeacherInfo(teacherId);
            mav.setViewName("administrator/singleTeacherUpdatePage");
            mav.addObject("teacherInfo",teacherInfo);
            return mav;
        }
        List<Teacher> teacherInfoList = new ArrayList<Teacher>();
        List<Teacher> teacherPosList = new ArrayList<Teacher>();
        //获取当前页数
        String currentPage = pageNow;
        //获取总页数
        int totalCount = 0;
        //获取所有教师的信息
        if(teacher.getTitle() == null && !teacher.isLeaderType()
                && !teacher.isMonitorType() && !teacher.isTeacherType() && state == null){
            teacherInfoList = administratorService.selectAllTeacherInfo();
            totalCount = administratorService.selectTeacherCount();
        }else if(state != null) {
            //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
            if(teacher.getTitle().equals("teachingStar")){
                teacher.setTitle("教学新星");
            }
            if(teacher.getTitle().equals("fastestProgress")){
                teacher.setTitle("进步最快");
            }
            if(teacher.getTitle().equals("lastHelp")){
                teacher.setTitle("末位帮扶");
            }
            administratorService.updateSingleTeacher(teacher,oldTeacherId);
            teacherInfoList = administratorService.selectAllTeacherInfo();
            totalCount = administratorService.selectTeacherCount();
        }else{
            teacherInfoList = administratorService.selectTeacherByCondition(teacher);
            totalCount = administratorService.selectTeacherCountByCondition(teacher);
        }
        Pagination page = null;
        int lastPos = 0;
        if (currentPage!=null) {
            page = new Pagination(Integer.parseInt(currentPage), totalCount);
        }else {
            page=new Pagination(1, totalCount);
        }
        if((page.getStartPos() + page.getPageSize()) > totalCount){
            lastPos = totalCount;
        } else {
            lastPos = page.getStartPos() + page.getPageSize();
        }
        for(int i = page.getStartPos(); i < lastPos; i++){
            teacherPosList.add(teacherInfoList.get(i));
        }
        boolean isEmpty = false;
        if(teacherInfoList.isEmpty()){
            isEmpty = true;
        }
        //教学新星teachingStar 进步最快fastestProgress 末位帮扶lastHelp
        if(teacher.getTitle() != null){
            if(teacher.getTitle().equals("教学新星")){
                teacher.setTitle("teachingStar");
            }
            if(teacher.getTitle().equals("进步最快")){
                teacher.setTitle("fastestProgress");
            }
            if(teacher.getTitle().equals("末位帮扶")){
                teacher.setTitle("lastHelp");
            }
        }
        String update = "update";
        mav.addObject("update",update);
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/teacherSearch");
        return mav;
    }

    /**
     * 课程
     */
    @RequestMapping(value = "/insertSingleCourse")
    public ModelAndView insertSingleCourse(Course course, String state,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
        Administrator administrator = (Administrator) httpSession.getAttribute("administratorInfo");
        if(administrator == null){
            mav.setViewName("administrator");
            return mav;
        }
        if(course.getCourseId() == "" && state != null){
            String message = "请输入正确的信息";
            mav.addObject("message",message);
        }else if(state != null){
            //1.根据课号前四位获取年级，通过年级和班级查询所有学生号student(studentId)
            //2.student_course插入学号和课程号
            //返回页面
            String successMessage;
            boolean isSuccess =  administratorService.insertSingleCourse(course);
            if(!isSuccess){
                successMessage = "课程信息已存在！";
            } else {
                //返回页面
                successMessage = "添加课程信息成功！";
            }
            mav.addObject("successMessage",successMessage);
        }
        mav.setViewName("administrator/singleCourseInsert");
        return mav;
    }

    @RequestMapping("/login")
    public ModelAndView login(Administrator administrator, ModelMap modelMap){
        Administrator admin = administratorService.login(administrator);
        ModelAndView modelAndView = new ModelAndView();
        if(admin == null){
            modelAndView.setViewName("administrator/loginA");
            String message = "账号或密码错误！";
            modelAndView.addObject("message",message);
        }else{
            modelMap.addAttribute("administratorInfo",admin);
            modelAndView.setViewName("administrator/admin");
        }
        return modelAndView;
    }

    @RequestMapping("/logout")
    public ModelAndView logout(SessionStatus sessionStatus){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        sessionStatus.setComplete();
        return modelAndView;
    }
}
