package com.example.test.Repos.Custom;

import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.Entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeRepositoryCustom {
    public DatabaseEmployee saveEmployee(Employee employee);



//    public DatabaseEmployee findRandomDatabaseEmployee();
}
