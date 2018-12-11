package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.CourseDetail;
import edu.cs.hrbnu.model.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentMapper {
	Student getStudentById(String studentId) throws Exception;
	void updateStudentPasswordById(String studentId,String password) throws Exception;
	int insertStudent(Student student) throws Exception;

	//更新密码
	void updateStudentPasswordById(HashMap<String,Object> map) throws Exception;
	//更新密码前先验证用户名和密码是否匹配
	String validateStudentIdAndPassword(String studentId) throws Exception;
	//重置密码
	void resetStudentPassword(Student student) throws Exception;
	//重置密码时先获取学生信息
	Student getStudentInfo(Student student) throws Exception;
}
