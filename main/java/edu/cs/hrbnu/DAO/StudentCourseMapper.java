package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.Student;

import java.util.List;

public interface StudentCourseMapper {
    List<String> getHistoryCourseIdByStudentId(String StudentId) throws Exception;
    List<String> getCourseIdByStudentId(String StudentId) throws Exception;
    List<Student> getStudentIdByCourseId(String CourseId) throws Exception;
}
