package com.example.test.Entities;

import com.example.test.Enums.PersonType;

import java.util.Date;

public class Employee extends Person {

    private Date hireTime;
    private Date firedTime;
    private Department department;

    public Employee() {
    }

    public Employee(Date hireTime, Date firedTime, Department department) {
        this.hireTime = hireTime;
        this.firedTime = firedTime;
        this.department = department;
    }

    public Employee(Long uid, byte[] card, PersonType type, Date hireTime, Date firedTime, Department department) {
        super(uid, card, type);
        this.hireTime = hireTime;
        this.firedTime = firedTime;
        this.department = department;
    }

    public Date getHireTime() {
        return hireTime;
    }

    public void setHireTime(Date hireTime) {
        this.hireTime = hireTime;
    }

    public Date getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(Date firedTime) {
        this.firedTime = firedTime;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
