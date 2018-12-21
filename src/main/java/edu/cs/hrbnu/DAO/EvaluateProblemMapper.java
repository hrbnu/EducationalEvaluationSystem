package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.EvaluateProblem;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EvaluateProblemMapper {
    List<EvaluateProblem> getAllTeacherEvaluateProblem() throws Exception;
    List<EvaluateProblem> getAllStudentEvaluateProblem() throws Exception;
    List<EvaluateProblem> getAllEvaluateProblem() throws Exception;
    void addEvaluateProblem(@Param("problemContext") String problemContext, @Param("forWho") int forWho, @Param("score") int score) throws Exception;
    void alterProblem(@Param("id")int id,@Param("context")String context);
}
