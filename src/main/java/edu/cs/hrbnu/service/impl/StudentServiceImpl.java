package edu.cs.hrbnu.service.impl;

import edu.cs.hrbnu.DAO.CourseMapper;
import edu.cs.hrbnu.DAO.StudentCourseMapper;
import edu.cs.hrbnu.DAO.StudentMapper;
import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentCourseMapper studentCourseMapper;
    @Autowired
    private CourseMapper courseMapper;

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

    @Override
    public void updatePassword(String studentId,String password){

        /**
         *  TODO : 最早写的一点，仅作参考
         * */

        try{
            studentMapper.updateStudentPasswordById(studentId,password);
        }catch (Exception e){
            e.printStackTrace();
        }
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
    public void evaluateCurrentCourse(String studentId,String courseId){
        // TODO
    }

    @Override
    public void complaint(Student student,Course course,String message){
        // TODO
    }

    @Override
    public void reset(Student student){
        // TODO
    }
}
