package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Complaint;

import java.util.List;

public interface ComplaintMapper {
    List<Complaint> getAllComplaint() throws Exception;
}

// test
