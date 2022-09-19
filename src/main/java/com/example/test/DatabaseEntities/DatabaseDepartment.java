package com.example.test.DatabaseEntities;

import com.example.test.Entities.Department;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "department")
public class DatabaseDepartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false, unique = true)
    private Long uid;
    @Column(length = 32)
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Set<DatabaseEmployee> databaseEmployee;

    public DatabaseDepartment(Long uid, String name) {
        this.uid = uid;
        this.name = name;
    }

    public DatabaseDepartment() {
    }

    public DatabaseDepartment(Department department) {
        this.name = department.getName();
        this.uid = department.getId();
    }

    public DatabaseDepartment(Long uid, String name, Set<DatabaseEmployee> databaseEmployee) {
        this.uid = uid;
        this.name = name;
        this.databaseEmployee = databaseEmployee;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<DatabaseEmployee> getDatabaseEmployee() {
        return databaseEmployee;
    }

    public void setDatabaseEmployee(Set<DatabaseEmployee> databaseEmployee) {
        this.databaseEmployee = databaseEmployee;
    }
}
