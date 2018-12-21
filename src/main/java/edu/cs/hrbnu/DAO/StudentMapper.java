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
	//查询所有学生的信息
	List<Student> selectAllStudentInfo() throws Exception;
	//查询所有学生总数
	int selectStudentCount() throws Exception;
	//按条件查询在校学生总数
	int selectStudentCountByCondition(HashMap<String,Object> map) throws Exception;
	//删除单条学生信息
	void deleteSingleStudent(String studentId) throws Exception;
	//按条件查询在校学生
	List<Student> selectStudentByCondition(HashMap<String,Object> map) throws Exception;
	//按条件查询已毕业学生总数
	int selectGraduatedStudentCountByCondition(HashMap<String,Object> map) throws Exception;
	//按条件查询已毕业学生
	List<Student> selectGraduatedStudentByCondition(HashMap<String,Object> map) throws Exception;
	//查询单条学生信息
	Student selectSingleStudentInfo(String studentId) throws Exception;
	//修改单条学生信息
	void updateSingleStudent(HashMap<String,Object> map) throws Exception;
	//插入单条学生信息
	void insertSingleStudentInfo(Student student) throws Exception;
	//获取一个同班同学学号
	String selectClassmateInfo(HashMap<String,Object> map) throws Exception;
	//通过年级和班级查询学生学号
	List<String> selectStudentIdsByGradeAndClassId(HashMap<String,Object> map) throws Exception;
}
