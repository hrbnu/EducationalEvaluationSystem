package edu.cs.hrbnu.DAO;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import edu.cs.hrbnu.model.Evaluate;

public interface EvaluateMapper {
    List<Evaluate> getOtherEvaluateById(String id) throws Exception;
    List<Evaluate> getAllTeacherEvaluate() throws Exception;
    int insertEvaluate(Evaluate evaluate) throws Exception;
    List<Evaluate> getEvaluateByCourseId(String id) throws Exception;
    List<Evaluate> getEvaluateScoreByStudentIdAndCourseId(@Param("studentId") String studentId,@Param("courseId") String courseId) throws Exception;
    List<Evaluate> getEealuateScoreByCourseIdAndFlag(@Param("courseId") String coureserId,@Param("flag") String flag) throws Exception;
}
