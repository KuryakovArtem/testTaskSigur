package com.example.test.DatabaseEntities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
public class DatabaseEmployee {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date hiredTime;
    @Temporal(TemporalType.DATE)
    private Date firedTime;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "uid")
    @MapsId
    private DatabasePerson person;


    @ManyToOne
    private DatabaseDepartment databaseDepartment;

    public DatabaseEmployee(Long id, Date hiredTime, Date firedTime, DatabaseDepartment databaseDepartment, DatabasePerson person) {
        this.id = id;
        this.hiredTime = hiredTime;
        this.firedTime = firedTime;
        this.databaseDepartment = databaseDepartment;
        this.person = person;
    }

    public DatabaseEmployee() {
    }

    public Date getFiredTime() {
        return firedTime;
    }

    public void setFiredTime(Date firedTime) {
        this.firedTime = firedTime;
    }

    public DatabasePerson getPerson() {
        return person;
    }

    public void setPerson(DatabasePerson person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getHiredTime() {
        return hiredTime;
    }

    public void setHiredTime(Date hiredTime) {
        this.hiredTime = hiredTime;
    }

    public DatabaseDepartment getDatabaseDepartment() {
        return databaseDepartment;
    }

    public void setDatabaseDepartment(DatabaseDepartment databaseDepartment) {
        this.databaseDepartment = databaseDepartment;
    }

}
