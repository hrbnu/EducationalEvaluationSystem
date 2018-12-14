package edu.cs.hrbnu.DAO;

import edu.cs.hrbnu.model.Complaint;

import java.util.List;

public interface ComplaintMapper {
    int insertComplaintContent(Complaint complaint) throws Exception;
    List<Complaint> getAllComplaint() throws Exception;
}
