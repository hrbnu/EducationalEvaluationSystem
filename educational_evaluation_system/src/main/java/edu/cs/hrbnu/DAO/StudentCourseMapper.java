package edu.cs.hrbnu.DAO;

import java.util.List;

import edu.cs.hrbnu.model.StudentCourse;

public interface StudentCourseMapper {
    List<StudentCourse> getHistoryCourseIdByStudentId(String StudentId) throws Exception;
    List<StudentCourse> getCurrentCourseIdByStudentId(String StudentId) throws Exception;
    List<StudentCourse> getStudentIdByCourseId(String CourseId) throws Exception;
}
