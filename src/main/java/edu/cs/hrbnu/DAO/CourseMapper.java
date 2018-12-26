package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    Course getCourseById(String id) throws Exception;
    List<Course> getAllCourses() throws Exception;
    int updateCourseScoreByCourseId(@Param("courseId") String courseId,@Param("score") double score) throws Exception;
    int insertCourse(Course course) throws Exception;
    List<Course> getCourseByTeacherId(String id) throws Exception;
    //根据教师号获取所有课程号
    List<String> selectCourseIdsByTeacherId(String teacherId) throws Exception;
    //根据教师号删除课程信息
    void deleteCoursesByTeacherId(String teacherId) throws Exception;
    //修改教师工号
    void updateTeacherId(String oldTeacherId) throws Exception;
    //插入单条课程信息
    void insertSingleCourse(Course course) throws Exception;

    List<Course> getCurrentMyselfEvaluate(String teacherId);
}
