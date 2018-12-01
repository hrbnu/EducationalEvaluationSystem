package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.Administrator;
import edu.cs.hrbnu.model.Student;
import edu.cs.hrbnu.model.Teacher;

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
    void importStudentByExcel();

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
    void importCourseByExcel();

    /**
     * 单独修改某班级课程表
     * */
    void updateCourseByExcel();

    /**
     * 修改评分标准
     * */
    void updateGrading();

    /**
     * 管理员期末总评
     * */
    void generalComment();

    /**
     * excel导入教师
     * */
    void importTeacherByExcel();

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
}
