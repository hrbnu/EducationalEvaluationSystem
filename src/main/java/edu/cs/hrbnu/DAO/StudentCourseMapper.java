package edu.cs.hrbnu.DAO;

import java.util.List;

import edu.cs.hrbnu.model.StudentCourse;

public interface StudentCourseMapper {
    List<String> getHistoryCourseIdByStudentId(String StudentId) throws Exception;
    List<String> getCourseIdByStudentId(String StudentId) throws Exception;
    List<StudentCourse> getStudentIdByCourseId(String CourseId) throws Exception;
}
