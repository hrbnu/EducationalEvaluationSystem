package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Evaluate;

import java.util.List;

public interface EvaluateMapper {
    List<Evaluate> getOtherEvaluateById(String id) throws Exception;
    List<Evaluate> getAllTeacherEvaluate() throws Exception;
    int insertEvaluate(Evaluate evaluate) throws Exception;
}
