package edu.cs.hrbnu.controller;


import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Pagination;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;
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
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Calendar;
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

    /**
     * 学生
     * @param pageNow
     * @param student
     * @return
     */
    @RequestMapping(value = "/searchStudentByCondition")
    public ModelAndView searchStudentByCondition(String pageNow, Student student){
        ModelAndView mav = new ModelAndView();
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
            //防止乱码
            if(student.getDepartment() != null ){
                try {
                    student.setDepartment(new String(student.getDepartment().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
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
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/studentSearch");
        return mav;
    }

    @RequestMapping("/deleteSingleStudent")
    private ModelAndView deleteSingleStudent(String studentId,String pageNow, Student student){
        administratorService.deleteSingleStudent(studentId);
        ModelAndView mav = new ModelAndView();
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
            //防止乱码
            if(student.getDepartment() != null ){
                try {
                    student.setDepartment(new String(student.getDepartment().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
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
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/singleStudentDelete");
        return mav;
    }

    @RequestMapping("/updateSingleStudent")
    private ModelAndView updateSingleStudent(String oldStudentId,String studentId,String pageNow, Student student,String state){
        ModelAndView mav = new ModelAndView();

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
            //防止乱码
            try {
                student.setDepartment(new String(student.getDepartment().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                student.setName(new String(student.getName().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            administratorService.updateSingleStudent(student,oldStudentId);
            studentInfoList = administratorService.selectAllStudentInfo();
            totalCount = administratorService.selectStudentCount();
        }else{
            //防止乱码
            if(student.getDepartment() != null ){
                try {
                    student.setDepartment(new String(student.getDepartment().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
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
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("studentPosList", studentPosList);
        mav.addObject("page",page);
        mav.setViewName("administrator/singleStudentUpdate");
        return mav;
    }

    @RequestMapping(value = "/insertSingleStudent")
    public ModelAndView insertSingleStudent(Student student,String state){
        ModelAndView mav = new ModelAndView();
        if(state != null){
            //防止乱码
            try {
                student.setDepartment(new String(student.getDepartment().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            try {
                student.setName(new String(student.getName().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //自动设置密码为身份证后六位
            //院系为专业
            //默认学生状态为在校
            administratorService.insertStudent(student);
            //返回页面
            mav.setViewName("success");
            return mav;
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
            //防止乱码
            if(teacher.getTitle() != null ){
                try {
                    teacher.setTitle(new String(teacher.getTitle().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
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
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/teacherSearch");
        return mav;
    }

    @RequestMapping("/deleteSingleTeacher")
    private ModelAndView deleteSingleTeacher(String teacherId,String pageNow, Teacher teacher,HttpSession httpSession){
        administratorService.deleteSingleTeacher(teacherId);
        ModelAndView mav = new ModelAndView();
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
            //防止乱码
            if(teacher.getTitle() != null ){
                try {
                    teacher.setTitle(new String(teacher.getTitle().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
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
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/singleTeacherDelete");
        return mav;
    }

    @RequestMapping(value = "/insertSingleTeacher")
    public ModelAndView insertSingleTeacher(Teacher teacher,String state){
        ModelAndView mav = new ModelAndView();
        if(state != null){
            //防止乱码
            try {
                teacher.setTeacherName(new String(teacher.getTeacherName().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //自动设置密码为身份证后六位
            administratorService.insertTeacher(teacher);
            //返回页面
            mav.setViewName("success");
            return mav;
        }
        mav.setViewName("administrator/singleTeacherInsert");
        return mav;
    }

    @RequestMapping("/updateSingleTeacher")
    private ModelAndView updateSingleTeacher(String teacherId,String pageNow, Teacher teacher,String state,String oldTeacherId,HttpSession httpSession){
        ModelAndView mav = new ModelAndView();
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
            //修改教师信息
            //防止乱码
            if(teacher.getTeacherName() != null){
                try {
                    teacher.setTeacherName(new String(teacher.getTeacherName().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(teacher.getTitle() != null){
                try {
                    teacher.setTitle(new String(teacher.getTitle().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(teacher.getHelpTeacherName() != null){
                try {
                    teacher.setHelpTeacherName(new String(teacher.getHelpTeacherName().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if(teacher.getAccepterTeacherName() != null){
                try {
                    teacher.setAccepterTeacherName(new String(teacher.getAccepterTeacherName().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            administratorService.updateSingleTeacher(teacher,oldTeacherId);
            teacherInfoList = administratorService.selectAllTeacherInfo();
            totalCount = administratorService.selectTeacherCount();
        }else{
            //防止乱码
            if(teacher.getTitle() != null ){
                try {
                    teacher.setTitle(new String(teacher.getTitle().getBytes("ISO-8859-1"),"utf-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
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
        httpSession.setAttribute("teacherPosList",teacherPosList);
        mav.addObject("isEmpty", isEmpty);
        mav.addObject("page",page);
        mav.setViewName("administrator/singleTeacherUpdate");
        return mav;
    }

    /**
     * 课程
     */
    @RequestMapping(value = "/insertSingleCourse")
    public ModelAndView insertSingleCourse(Course course, String state){
        ModelAndView mav = new ModelAndView();
        if(state != null){
            //防止乱码
            try {
                course.setCourseName(new String(course.getCourseName().getBytes("ISO-8859-1"),"utf-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //1.根据课号前四位获取年级，通过年级和班级查询所有学生号student(studentId)
            //2.student_course插入学号和课程号
            administratorService.insertSingleCourse(course);
            //返回页面
            mav.setViewName("success");
            return mav;
        }
        mav.setViewName("administrator/singleCourseInsert");
        return mav;
    }
}
