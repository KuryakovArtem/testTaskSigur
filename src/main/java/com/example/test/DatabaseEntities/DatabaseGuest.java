package com.example.test.DatabaseEntities;
import com.sun.istack.NotNull;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "guest")
public class DatabaseGuest {
    @Id
    @GeneratedValue
    private Long id;
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date visitDate;
    private Long empId;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "uid")
    @MapsId
    private DatabasePerson person;

    public DatabaseGuest() {
    }

    public DatabaseGuest(Date visitDate, Long empId) {
        this.visitDate = visitDate;
        this.empId = empId;
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

    public DatabasePerson getPerson() {
        return person;
    }

    public void setPerson(DatabasePerson newDatabasePerson) {
        this.person = newDatabasePerson;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DatabaseGuest(Long id, Date visitDate, Long empId, DatabasePerson person) {
        this.id = id;
        this.visitDate = visitDate;
        this.empId = empId;
        this.person = person;
    }
}
