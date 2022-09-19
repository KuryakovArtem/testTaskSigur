package com.example.test.RepositoryImpl;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Entities.Employee;
import com.example.test.Enums.PersonType;
import com.example.test.Repos.Custom.EmployeeRepositoryCustom;
import com.example.test.Repos.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

@Repository

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {
    @Autowired
    @Lazy
    private EmployeeRepository employeeRepository;
    @Override
    public DatabaseEmployee saveEmployee(Employee employee) {
        DatabasePerson person = new DatabasePerson();
        person.setCard(employee.getCard());
        person.setType(PersonType.EMPLOYEE);
        DatabaseEmployee databaseEmployee = new DatabaseEmployee();
        DatabaseDepartment databaseDepartment = new DatabaseDepartment(employee.getDepartment());
        databaseEmployee.setDatabaseDepartment(databaseDepartment);
        databaseEmployee.setFiredTime(employee.getFiredTime());
        databaseEmployee.setHiredTime(employee.getHireTime());
        databaseEmployee.setPerson(person);
        return employeeRepository.save(databaseEmployee);
    }



}
