package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.util.List;

public interface AdministratorService {

    /**
     *  登录
     * */
    void login(Administrator administrator);

    /**
     *  登出
     * */
    void logout(Administrator administrator);

    /**
     *  excel导入学生信息
     * */
    boolean importStudentByExcel(String filePath);

    /**
     *  单条添加学生信息
     * */
    void insertStudent(Student student);

    /**
     * 修改学生信息
     * */
    void updateStudent(Student student);

    /**
     * 单条删除学生信息
     * */
    void deleteStudent(Student student);

    /**
     * excel插入课程表
     * */
    boolean importCourseByExcel(String filePath);

    /**
     * 单独修改某班级课程表
     * */
    void updateCourseByExcel();

    /**
     * 修改评分标准
     * @param weight 
     * */
    void updateGrading(Weight weight);

    /**
     * 管理员期末总评
     * @param weight 
     * */
    void generalComment(Weight weight);

    /**
     * excel导入教师
     * */
    boolean importTeacherByExcel(String filePath);

     /**
     * 单条插入教师信息
     * */
    void insertTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * */
    void updateTeacher(Teacher teacher);

    /**
     * 单条删除教师信息
     * */
    void deleteTeacher(Teacher teacher);

    /**
     *  获取所有的评价问题信息
     * */
    List<EvaluateProblem> getAllEvaluateProblems();

    /**
     *  添加评价问题信息
     * */
    void addProblem(EvaluateProblem problem);
    /**
     *  修改评价问题信息
     * */
    void alterProblem(int id,String context);

}
