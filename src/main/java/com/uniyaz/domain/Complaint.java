package com.uniyaz.domain;

import com.uniyaz.common.BaseDomain;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "COMPLAINT")
public class Complaint extends BaseDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "CLIENT_NAME")
    private String clientNameSurname;

    @Column(name = "COMPLAINT")
    private String complaint;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COMPLAINT_DATE")
    private Date complaintDate;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, name = "STATE")
    private EnumState enumState;

    @Column(name = "EXPLANATION")
    private String explanation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientNameSurname() {
        return clientNameSurname;
    }

    public void setClientNameSurname(String clientNameSurname) {
        this.clientNameSurname = clientNameSurname;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public EnumState getEnumState() {
        return enumState;
    }

    public void setEnumState(EnumState enumState) {
        this.enumState = enumState;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
