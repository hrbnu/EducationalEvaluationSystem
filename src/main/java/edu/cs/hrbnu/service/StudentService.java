package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.*;

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
	List<StudentCourseTemp> getEvaluateHistoryCourses(String studentId);

    /**
     * 得到当前评价的课程
     */
    List<StudentCourseTemp> getEvaluateCurrentCourse(String studentId);

	/**
	 * 评价历史课程
	 */
	void evaluateHistoryCourses(String studentId,String courseId);

	/*
	* 获取评价问题*/
	List<EvaluateProblem> getEvaluateProblem();

	/**
	 * 评价当前课程和历史课程
	 */
	int evaluateCurrentCourse(String studentId, String courseId, double courseScores, String evaluateContent, String flag);
	
	/**
     * 投诉
     * */
	int complaint(String studentId, String courseId, String complaintContent);

	/*
	* 更新评价次数*/
	int updateCourseTimeByStudentIdAndCourseId(String studentId, String courseId);

	/*更新历史评次数*/
	int updateHistoryByStudentIdAndCourseId(String studentId, String courseId);

	List<Complaint> getComplaintByStudentId(String studentId);
}	
