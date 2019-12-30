package com.uniyaz.web.rest;

import com.uniyaz.domain.Complaint;
import com.uniyaz.dao.ComplaintDao;
import com.uniyaz.web.converter.ComplaintConverter;
import com.uniyaz.web.dto.ComplaintDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

@Path("/complaint")
@Provider
public class ComplaintRestService {

    @GET
    @Path("/findAllComplaints")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllComplaints() {
        ComplaintDao complaintDao = new ComplaintDao();
        List<Complaint> complaintList = complaintDao.findAllComplaints();

        ComplaintConverter complaintConverter = new ComplaintConverter();
        List<ComplaintDto> complaintDtoList = complaintConverter.convertToComplaintDtoList(complaintList);

        return Response.ok().entity(complaintDtoList).build();
    }

    @POST
    @Path("/saveComplaint")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveComplaint(ComplaintDto complaintDto) {

        ComplaintConverter complaintConverter = new ComplaintConverter();
        Complaint complaint = complaintConverter.convertToComplaint(complaintDto);

        ComplaintDao complaintDao = new ComplaintDao();
        complaint = complaintDao.saveComplaint(complaint);

        ComplaintDto savedComplaint = complaintConverter.convertToComplaintDto(complaint);

        return Response.ok().entity(savedComplaint).build();
    }

    @GET
    @Path("/findAllComplaintsByName/{clientNameSurname}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllComplaintsByName(@FormParam("clientNameSurname") String clientNameSurname){

        ComplaintDao complaintDao = new ComplaintDao();
        Complaint complaint = complaintDao.findAllComplaintsByName(clientNameSurname);

        ComplaintConverter complaintConverter = new ComplaintConverter();
        ComplaintDto complaintDto = complaintConverter.convertToComplaintDto(complaint);

        return Response.ok().entity(complaintDto).build();
    }

}
