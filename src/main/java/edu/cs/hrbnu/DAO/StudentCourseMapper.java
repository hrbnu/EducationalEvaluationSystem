package edu.cs.hrbnu.DAO;

import java.util.HashMap;
import java.util.List;

import edu.cs.hrbnu.model.StudentCourse;

public interface StudentCourseMapper {
    List<StudentCourse> getHistoryCourseIdByStudentId(String StudentId) throws Exception;
    List<StudentCourse> getCurrentCourseIdByStudentId(String StudentId) throws Exception;
    List<StudentCourse> getStudentIdByCourseId(String CourseId) throws Exception;
    //删除单条学生课程信息
    void deleteSingleStudentCourses(String studentId) throws Exception;
    //根据学号获取所有的课程号
    List<String> selectCourseIdsByClassmateId(HashMap<String,Object> map) throws Exception;
    //插入学生时同时插入所有的课程号
    void insertSingleStudentCourses(List<StudentCourse> studentCourses) throws Exception;
    //根据课程号删除课程信息
    void deleteStudentCoursesByCourseId(String courseId) throws Exception;
    //插入信息
    void insertStudentCourses(List<StudentCourse> studentCourse) throws Exception;
    //修改单条学生学号
    void updateSingleStudentId(HashMap<String,Object> map) throws Exception;

    //更新评价次数
    int updateCourseTimeByStudentIdAndCourseId(StudentCourse studentCourse) throws Exception;
    //更新历史评价次数
    int updateHistoryByStudentIdAndCourseId(StudentCourse studentCourse) throws Exception;
}
