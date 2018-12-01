package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.CourseDetail;
import edu.cs.hrbnu.model.Student;

import java.util.List;

public interface StudentMapper {
	Student getStudentById(String studentId) throws Exception;
	void updateStudentPasswordById(String studentId,String password) throws Exception;
}
