package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.EvaluateMapper;
import edu.cs.hrbnu.DAO.TeacherMapper;
import edu.cs.hrbnu.model.Complaint;
import edu.cs.hrbnu.model.Evaluate;
import edu.cs.hrbnu.model.Teacher;
import edu.cs.hrbnu.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;


    public Teacher login(String teacherId, String password) {

        Teacher teacher = null;
        try {
            teacher = teacherMapper.getTeacherById(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (teacher == null) {
            return null;
        } else {
            if (!teacher.getPassword().equals(password)) {
                return null;
            }
        }
        return teacher;
    }

    @Override
    public void logout() {
    }

    //重置密码
    @Override
    public boolean reset(Teacher teacher) {
        boolean isSuccess = false;
        try {
            Teacher teacherInformation = teacherMapper.getTeacherInformation(teacher);
            if (teacherInformation != null) {
                Teacher teacherRest = new Teacher();
                teacherRest.setTeacherId(teacherInformation.getTeacherId());
                teacherRest.setPassword(teacherInformation.getIdCard().substring(12));
                teacherMapper.resetTeacherPassword(teacherRest);
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    //更新密码
    @Override
    public boolean updatePassword(String teacherId, String oldPassword, String newPassword) {
        boolean isSuccess = false;
        try {
            String password = teacherMapper.validateTeacherIdAndPassword(teacherId);
            if (password.equals(oldPassword)) {
                HashMap<String, Object> map = new HashMap<String, Object>();
                map.put("teacherId", teacherId);
                map.put("password", newPassword);
                teacherMapper.updateTeacherPasswordById(map);
                isSuccess = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public List<Evaluate> otherEvaluate(String teacherId) {

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        List<Evaluate> evaluateList = null;
        try {
            evaluateList = evaluateMapper.getOtherEvaluateById(teacherId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return evaluateList;
    }

    @Override
    public void setHelp(String teacherId, String isHelpedTeacherId) {

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
    public void submitListen(String teacherId, String isListenedTeacherId) {
        // TODO
    }

    @Override
    public void confirm(Teacher teacher) {
        // TODO
    }

    @Override
    public void evaluateTeacher(Evaluate evaluate) {
        // TODO
    }

    @Override
    public List<Evaluate> viewAllTeacherEvaluate() {
        // TODO
        return null;
    }

    @Override
    public List<Complaint> viewAllComplaint() {
        // TODO
        return null;
    }

    @Override
    public Complaint viewMyComplaint() {
        // TODO
        return null;
    }

    @Override
    public void exportEvaluateForm() {
        // TODO
    }

    @Override
    public List<Complaint> alertComplaint(String teacherId, String lastLoginTime, String currentLoginTime) {
        List<String> courseIds = teacherMapper.getTeacherCoursesById(teacherId);
        List<Complaint> complaints = teacherMapper.getUnbrowsedComplaintsByCourseId(courseIds,lastLoginTime,currentLoginTime);
        return complaints;
    }

    @Override
    public void updateLastLoginTime(String currentLoginTime,String teacherId){
        try {
            teacherMapper.updateLastLoginTime(currentLoginTime,teacherId);
        } catch (Exception e) {
            e.printStackTrace();e.printStackTrace();
        }
    }
}
