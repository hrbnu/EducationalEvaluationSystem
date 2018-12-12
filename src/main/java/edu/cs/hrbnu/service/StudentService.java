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
	 * 更新密码 由void改成了boolean
	 */
	boolean updatePassword(String studentId,String oldPassword,String newPassword);

	/**
	 *  重置密码 由void改成了boolean
	 * */
	boolean reset(Student student);

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

	/*
	* 获取评价问题*/
	List<EvaluateProblem> getEvaluateProblem();

	/**
	 * 评价当前课程
	 */
	int evaluateCurrentCourse(String studentId, String courseId, double courseScores, String evaluateContent);
	
	/**
     * 投诉
     * */
	int complaint(String studentId, String courseId, String complaintContent);
}	
