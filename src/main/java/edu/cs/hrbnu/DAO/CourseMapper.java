package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    Course getCourseById(String id) throws Exception;
    List<Course> getAllCourses() throws Exception;
    int updateCourseScoreByCourseId(@Param("courseId") String courseId,@Param("score") double score) throws Exception;
    int insertCourse(Course course) throws Exception;
}
