package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.EvaluateMapper;
import edu.cs.hrbnu.DAO.TeacherMapper;
import edu.cs.hrbnu.model.Complaint;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
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

    @Override
    public void reset(Teacher teacher){
        // TODO
    }

    @Override
    public void updatePassword(Teacher teacher){
        // TODO
    }

    @Override
    public List<Evaluate> otherEvaluate(String courseId){

        /**
         *  教师查看自己的评价
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
    public List<Course> getCourseByTeahcer(String teacherId){
        List<Course> courseList = null;
        try{
            courseList = courseMapper.getCourseByTeacherId(teacherId);
        }catch (Exception e){
            e.printStackTrace();
        }

        return courseList;
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

    @Override
    public void evaluateTeacher(Evaluate evaluate){
        // TODO
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
    public void exportEvaluateForm(){
        // TODO
    }

    @Override
    public void alertComplaint(){
        // TODO
    }
}
