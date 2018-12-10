package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.Course;
import edu.cs.hrbnu.model.EvaluateProblem;
import edu.cs.hrbnu.model.Student;

import java.util.List;

public interface StudentService {
	
	/**
	 * 学生登录验证
	 */
	Student login(String studentId, String password);

    /**
     * 登出
     * */
    void logout(Student student);

	/**
	 * 更新密码
	 */
	void updatePassword(String studentId, String password);

    /**
     *  重置密码
     * */
    void reset(Student student);

    /**
     * 得到需要评价的历史课程
     */
    List<Course> getEvaluateHistoryCourses(String studentId);

    /**
     * 得到当前评价的课程
     */
    List<Course> getEvaluateCurrentCourse(String studentId);

	/**
	 * 评价历史课程
	 */
	void evaluateHistoryCourses(String studentId,String courseId);
	
	/**
	 * 评价当前课程
	 */
	List<EvaluateProblem> evaluateCurrentCourse(String studentId, String courseId);
	
	/**
     * 投诉
     * */
	void complaint(Student student,Course course,String message);
}	
