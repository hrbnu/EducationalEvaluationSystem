package edu.cs.hrbnu.service;

import edu.cs.hrbnu.model.*;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import java.util.List;

public interface AdministratorService {

    /**
     *  登录
     * */
    Administrator login(Administrator administrator);

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
    boolean insertStudent(Student student);

    /**
     * 修改学生信息
     * */
    void updateSingleStudent(Student student,String oldStudentId);

    /**
     * 删除单条学生信息
     */
    void deleteSingleStudent(String studentId);

    /**
     * excel插入课程表
     * */
    boolean importCourseByExcel(String filePath);

    /**
     * 单独修改某班级课程表
     * */
    void updateCourseByExcel();

    /**
     * 单条插入课程信息
     */
    boolean insertSingleCourse(Course course);

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
    boolean insertTeacher(Teacher teacher);

    /**
     * 修改教师信息
     * */
    void updateSingleTeacher(Teacher teacher,String oldTeacherId);

    /**
     * 删除单条教师信息
     */
    void deleteSingleTeacher(String teacherId);

    /**
     * 按条件查询在校学生
     */
    List<Student> selectStudentByCondition(String department, int grade, int classId);

    /**
     * 按条件查询已毕业学生
     */
    List<Student> selectGraduatedStudentByCondition(String department,boolean isGraduation,int classId);

    /**
     * 查询所有学生信息
     */
    List<Student> selectAllStudentInfo();

    /**
     * 查询单条学生信息
     */
    public Student selectSingleStudentInfo(String studentId);

    /**
     * 查询所有学生总数
     */
    int selectStudentCount();

    /**
     * 按条件查询已毕业学生总数
     */
    int selectGraduatedStudentCountByCondition(String department,boolean isGraduation,int classId);

    /**
     * 按条件查询在校学生总数
     */
    int selectStudentCountByCondition(String department,int grade,int classId);

    /**
     * 查询所有教师信息
     */
    List<Teacher> selectAllTeacherInfo();

    /**
     * 查询所有教师总数
     */
    int selectTeacherCount();

    /**
     * 按条件查询教师
     */
    List<Teacher> selectTeacherByCondition(Teacher teacher);

    /**
     * 按条件查询学教师总数
     */
    int selectTeacherCountByCondition(Teacher teacher);

    /**
     * 查询单条教师信息
     */
    public Teacher selectSingleTeacherInfo(String teacherId);

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
