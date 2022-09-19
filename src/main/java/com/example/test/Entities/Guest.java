package com.example.test.Entities;

import com.example.test.Enums.PersonType;

import java.util.Date;

public class Guest extends Person {
    private Date visitDate;
    private Long empId;

    public Guest(Long uid, byte[] card, PersonType type, Date visitDate, Long empId) {
        super(uid, card, type);
        this.visitDate = visitDate;
        this.empId = empId;
    }

    public Guest(Date visitDate, Long empId) {
        this.visitDate = visitDate;
        this.empId = empId;
    }

    public Guest() {

    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }


}
