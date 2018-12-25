package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.*;
import edu.cs.hrbnu.model.*;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private EvaluateProblemMapper evaluateProblemMapper;
    @Autowired
    private EvaluateMapper evaluateMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Student login(String studentId, String password){

        Student student = null;
        try {
            student = studentMapper.getStudentById(studentId);
        }catch (Exception e){
            e.printStackTrace();
        }

        if(student == null){
            return null;
        }else{
            if(!student.getPassword().equals(password)){
                return null;
            }
        }
        return student;
    }

    //更新密码 通过学号、旧密码和新密码
    @Override
    public boolean updatePassword(String studentId,String oldPassword,String newPassword){
        boolean isSuccess = false;
        try{
            String password = studentMapper.validateStudentIdAndPassword(studentId);
            if(password.equals(oldPassword)){
                HashMap<String,Object> map = new HashMap<String, Object>();
                map.put("studentId",studentId);
                map.put("password",newPassword);
                studentMapper.updateStudentPasswordById(map);
                isSuccess = true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    //重置密码  通过学号和身份证号验证
    @Override
    public boolean reset(Student student){
        boolean isSuccess = false;
        try {
            Student studentInformation = studentMapper.getStudentInfo(student);
            if(studentInformation != null){
                Student studentRest = new Student();
                studentRest.setStudentId(studentInformation.getStudentId());
                studentRest.setPassword(studentInformation.getIdCard().substring(12));
                studentMapper.resetStudentPassword(studentRest);
                isSuccess = true;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return isSuccess;
    }

    @Override
    public void logout(Student student){
        // TODO
    }

    @Override
    public List<StudentCourseTemp> getEvaluateHistoryCourses(String studentId){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        List<StudentCourseTemp> historyCourse = new ArrayList<StudentCourseTemp>();
        List<StudentCourse> currentDetail = null;
        try{
            currentDetail = studentCourseMapper.getHistoryCourseIdByStudentId(studentId);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(StudentCourse studentCourse:currentDetail){
            try{
                StudentCourseTemp studentCourseTemp = new StudentCourseTemp();
                studentCourseTemp.setStudentCourse(studentCourse);
                studentCourseTemp.setCourse(courseMapper.getCourseById(studentCourse.getCourseId()));
                studentCourseTemp.setTeacher(teacherMapper.getTeacherById(studentCourseTemp.getCourse().getTeacherId()));
                historyCourse.add(studentCourseTemp);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return historyCourse;
    }

    @Override
    public List<StudentCourseTemp> getEvaluateCurrentCourse(String studentId){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */
        List<StudentCourseTemp> currentCourse = new ArrayList<StudentCourseTemp>();
        List<StudentCourse> currentDetail = null;
        try{
            currentDetail = studentCourseMapper.getCurrentCourseIdByStudentId(studentId);
        }catch(Exception e){
            e.printStackTrace();
        }

        for(StudentCourse studentCourse:currentDetail){
            try{
                StudentCourseTemp studentCourseTemp = new StudentCourseTemp();
                studentCourseTemp.setStudentCourse(studentCourse);
                studentCourseTemp.setCourse(courseMapper.getCourseById(studentCourse.getCourseId()));
                studentCourseTemp.setTeacher(teacherMapper.getTeacherById(studentCourseTemp.getCourse().getTeacherId()));
                currentCourse.add(studentCourseTemp);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        return currentCourse;
    }

    /**
     *  应先考虑如何算分，以及分数如何传过来
     * */
    @Override
    public void evaluateHistoryCourses(String studentId,String courseId){
        // TODO
    }

    /*该方法用于获取数据库中的存放的用于学生给老师评分时的标准*/
    @Override
    public List<EvaluateProblem> getEvaluateProblem() {
        // TODO
        List<EvaluateProblem> listStudentEvaluateProblem = null;
        try{
            listStudentEvaluateProblem = evaluateProblemMapper.getAllStudentEvaluateProblem();
        }catch (Exception e){
            e.printStackTrace();
        }
        return listStudentEvaluateProblem;
    }

    /*yaque 私有方法，勿动。用于向数据库中写入一次学生的评价*/
    @Override
    public int evaluateCurrentCourse(String studentId, String courseId, double courseScores, String evaluateContent, String flag) {
        Evaluate evaluate = new Evaluate();
        evaluate.setCourseId(courseId);
        evaluate.setEvaluateContent(evaluateContent);
        evaluate.setEvaluateScore(courseScores);
        evaluate.setFlag(flag);
        evaluate.setFlagId(studentId);
        try {
            evaluateMapper.insertEvaluate(evaluate);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /*yaque的私有方法 勿动。用于向数据库中写入一次学生的投诉*/
    @Override
    public int complaint(String studentId, String courseId, String complaintContent){
        // TODO
        Complaint complaint = new Complaint();
        complaint.setStudentId(studentId);
        complaint.setCourseId(courseId);
        complaint.setMessage(complaintContent);
        complaint.setComplaintTime(new Date());
        try {
            complaintMapper.insertComplaintContent(complaint);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /*yaque的私有方法 勿动。用于更新评价次数*/
    @Override
    public int updateCourseTimeByStudentIdAndCourseId(String studentId, String courseId) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        try {
            studentCourseMapper.updateCourseTimeByStudentIdAndCourseId(studentCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    @Override
    public int updateHistoryByStudentIdAndCourseId(String studentId, String courseId) {
        StudentCourse studentCourse = new StudentCourse();
        studentCourse.setStudentId(studentId);
        studentCourse.setCourseId(courseId);
        try {
            studentCourseMapper.updateHistoryByStudentIdAndCourseId(studentCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    /*yaque的私有方法 勿动。*/
    public List<Complaint> getComplaintByStudentId(String studentId) {
        List<Complaint> complaintList = null;
        try {
            complaintList = complaintMapper.getComplaintByStudentId(studentId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return complaintList;
    }
}
