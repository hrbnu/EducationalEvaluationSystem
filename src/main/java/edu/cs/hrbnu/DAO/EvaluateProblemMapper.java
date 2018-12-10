package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.EvaluateProblem;

import java.util.List;

public interface EvaluateProblemMapper {
    List<EvaluateProblem> getAllTeacherEvaluateProblem() throws Exception;
    List<EvaluateProblem> getAllStudentEvaluateProblem() throws Exception;
}
