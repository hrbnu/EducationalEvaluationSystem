package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.EvaluateProblemMapper;
import edu.cs.hrbnu.DAO.StudentCourseMapper;
import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
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

    @Override
    public Student login(String studentId, String password){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        Student student = null;
        try {
            student = studentMapper.getStudentById(studentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(password == null || student.getPassword().compareTo(password) == 0){
            return null;
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
    public List<Course> getEvaluateHistoryCourses(String studentId){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        List<String> listHistoryCourseId = null;
        try {
            listHistoryCourseId = studentCourseMapper.getHistoryCourseIdByStudentId(studentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Course> listCourse = new ArrayList<>();
        for(String id : listHistoryCourseId){
            Course course = null;
            try {
                course = courseMapper.getCourseById(id);
            }catch (Exception e){
                e.printStackTrace();
            }
            listCourse.add(course);
        }
        return listCourse;
    }

    @Override
    public List<Course> getEvaluateCurrentCourse(String studentId){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        List<String> listHistoryCourseId = null;
        try{
            listHistoryCourseId = studentCourseMapper.getCourseIdByStudentId(studentId);
        }catch (Exception e){
            e.printStackTrace();
        }
        List<Course> listCourse = new ArrayList<>();
        for(String id : listHistoryCourseId){
            Course course = null;
            try {
                course = courseMapper.getCourseById(id);
            }catch (Exception e){
                e.printStackTrace();
            }
            listCourse.add(course);
        }
        return listCourse;
    }

    /**
     *  应先考虑如何算分，以及分数如何传过来
     * */
    @Override
    public void evaluateHistoryCourses(String studentId,String courseId){
        // TODO
    }

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

    @Override
    public void evaluateCurrentCourse(Student student, String courseId, double courseScores, String evaluateContent) {

    }

    @Override
    public void complaint(Student student,Course course,String message){
        // TODO
    }

}
