package com.uniyaz.web.converter;

import com.uniyaz.domain.Complaint;
import com.uniyaz.web.dto.ComplaintDto;

import java.util.ArrayList;
import java.util.List;

public class ComplaintConverter {

    /// ComplaintDto'yu Complaint'e çevirme
    public Complaint convertToComplaint(ComplaintDto complaintDto){

        Complaint complaint = new Complaint();
        complaint.setClientNameSurname(complaintDto.getClientNameSurname());
        complaint.setComplaint(complaintDto.getComplaint());
        complaint.setComplaintDate(complaintDto.getComplaintDate());
        complaint.setEnumState(complaintDto.getEnumState());
        complaint.setExplanation(complaintDto.getExplanation());
        complaint.setId(complaintDto.getId());
        return complaint;
    }

    /// Complaint'i ComplaintDto'ya çevirme
    public ComplaintDto convertToComplaintDto(Complaint complaint){

        ComplaintDto complaintDto = new ComplaintDto();
        complaintDto.setId(complaint.getId());
        complaintDto.setClientNameSurname(complaint.getClientNameSurname());
        complaintDto.setComplaint(complaint.getComplaint());
        complaintDto.setComplaintDate(complaint.getComplaintDate());
        complaintDto.setEnumState(complaint.getEnumState());
        complaintDto.setExplanation(complaint.getExplanation());
        return complaintDto;
    }

    public List<ComplaintDto> convertToComplaintDtoList(List<Complaint> complaintList) {

        List<ComplaintDto> complaintDtoList = new ArrayList<>();
        for (Complaint complaint : complaintList) {
            ComplaintDto categoryDto = (ComplaintDto) convertToComplaintDto(complaint);
            complaintDtoList.add(categoryDto);
        }
        return complaintDtoList;
    }
}
