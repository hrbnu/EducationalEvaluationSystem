package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.*;
import edu.cs.hrbnu.model.*;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    EvaluateProblemMapper evaluateProblemMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public Teacher login(String teacherId, String password){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        Teacher teacher = null;
        try {
            teacher = teacherMapper.getTeacherById(teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(password == null || teacher.getPassword().compareTo(password) == 0){
            return null;
        }
        return teacher;
    }

    @Override
    public void logout(){
        // TODO
    }

    //重置密码
    @Override
    public boolean reset(Teacher teacher){
        boolean isSuccess = false;
        try {
            Teacher teacherInformation = teacherMapper.getTeacherInformation(teacher);
            if(teacherInformation != null){
                Teacher teacherRest = new Teacher();
                teacherRest.setTeacherId(teacherInformation.getTeacherId());
                teacherRest.setPassword(teacherInformation.getIdCard().substring(12));
                teacherMapper.resetTeacherPassword(teacherRest);
                isSuccess = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    //更新密码
    @Override
    public boolean updatePassword(String teacherId, String oldPassword, String newPassword){
        boolean isSuccess = false;
        try{
            String password = teacherMapper.validateTeacherIdAndPassword(teacherId);
            if(password.equals(oldPassword)){
                HashMap<String,Object> map = new HashMap<String, Object>();
                map.put("teacherId",teacherId);
                map.put("password",newPassword);
                teacherMapper.updateTeacherPasswordById(map);
                isSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }
    @Override
    public List<Evaluate> otherEvaluate(String courseId){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        List<Evaluate> evaluateList = null;
        try {
            evaluateList = evaluateMapper.getEvaluateByCourseId(courseId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return evaluateList;
    }

    @Override
    public void setHelp(String teacherId,String isHelpedTeacherId){

        /**
         *  TODO : 最早写的一点，仅作参考，现在暂时不考虑实现
         * */

        /*
        try {
            teacherMapper.updateHelpByHelperId(teacherId,isHelpedTeacherId);
            teacherMapper.updateHelpByAccepterId(isHelpedTeacherId,teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }
        */
    }

    @Override
    public void submitListen(String teacherId,String isListenedTeacherId){
        // TODO
    }

    @Override
    public void confirm(Teacher teacher){
        // TODO
    }

    /*该方法用于获取数据库中的存放的用于老师给老师评分时的标准*/
    @Override
    public List<EvaluateProblem> getEvaluateProblem() {
        // TODO
        List<EvaluateProblem> listTeacherEvaluateProblem = null;
        try{
            listTeacherEvaluateProblem = evaluateProblemMapper.getAllTeacherEvaluateProblem();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listTeacherEvaluateProblem;
    }

    @Override
    public int evaluateTeacher(Evaluate evaluate){
        // TODO
        try {
            evaluateMapper.insertEvaluate(evaluate);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public List<Evaluate> viewAllTeacherEvaluate(){
        // TODO
        return null;
    }

    @Override
    public List<Complaint> viewAllComplaint(){
        // TODO
        return null;
    }

    @Override
    public Complaint viewMyComplaint(){
        // TODO
        return null;
    }

    @Override
    public List<Evaluate> exportEvaluateForm(String teacherId){
        List<Course> courseList = null;
        try {
            courseList = courseMapper.getCourseByTeacherId(teacherId);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        if(courseList == null || courseList.size() == 0){
            return null;
        }

        List<Evaluate> allEvaluate = new ArrayList<>();
        for(Course course : courseList){
            String courseId = course.getCourseId();
            List<Evaluate> evaluateList = null;
            try{
                evaluateList = evaluateMapper.getEvaluateByCourseId(courseId);
            }catch (Exception ex){
                ex.printStackTrace();
            }
            if(evaluateList != null){
                allEvaluate.addAll(evaluateList);
            }
        }
        return allEvaluate;
    }

    @Override
    public void alertComplaint(){
        // TODO
    }

    //获取教师所教授课程
    @Override
    public List<Course> getCourseByTeahcer(String teacherId){
        List<Course> courseList = null;
        try{
            courseList = courseMapper.getCourseByTeacherId(teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return courseList;
    }
    //获取所有教师名字
    @Override
    public List<Teacher> getAllTeacherName(){
        /**
         *  获取教师名字 用来给领导查看所有的教师评价
         * */
        List<Teacher> teacherList = null;
        try{
            teacherList = teacherMapper.getTeacherName();

        }catch (Exception e){
            e.printStackTrace();
        }
        return teacherList;
    }

    @Override
    public List<Complaint> getComplaintByCourseId(String courseId){
        List<Complaint> complaintList = null;
        try{
            complaintList = complaintMapper.getComplaintByCourseId(courseId);

        }catch (Exception e){
            e.printStackTrace();
        }
        return complaintList;
    }
}
