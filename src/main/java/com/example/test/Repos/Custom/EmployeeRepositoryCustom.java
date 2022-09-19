package com.example.test.Repos.Custom;

import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.Entities.Employee;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepositoryCustom {
    public DatabaseEmployee saveEmployee(Employee employee);
}
