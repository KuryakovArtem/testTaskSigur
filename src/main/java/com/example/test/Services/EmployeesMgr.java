package com.example.test.Services;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.Entities.Department;
import com.example.test.Entities.Employee;
import com.example.test.Repos.DepartmentRepository;
import com.example.test.Repos.EmployeeRepository;
import com.example.test.Repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class EmployeesMgr {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void generateEmployee(Calendar hiringPeriod, int hireNumber) {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        Calendar hiringPeriod = Calendar.getInstance();
//        String startDate = "01-01-2022";
//        hiringPeriod.setTime(simpleDateFormat.parse(startDate));
//
//
//        Calendar endOfHiringPeriod = Calendar.getInstance();
//        String endDate = "01-01-2023";
//        endOfHiringPeriod.setTime(simpleDateFormat.parse(endDate));

        hireEmployee(hiringPeriod);
        if (hireNumber % 5 == 0) {
            fireEmployees(hiringPeriod);
        }
    }
    public void hireEmployee(Calendar hiringPeriod) {
        Employee employee = new Employee();
        employee.setHireTime(hiringPeriod.getTime());
        Random random = new Random();
        byte[] card = new byte[16];
        random.nextBytes(card);
        employee.setCard(card);
        employee.setDepartment(getRandomDepartment());
        employeeRepository.saveEmployee(employee);
        //logInConsole(employee, hiringPeriod, true);
    }


    public void fireEmployees(Calendar firingPeriod) {
        List<DatabaseEmployee> allDatabaseEmployees = employeeRepository.findAll();
        if (allDatabaseEmployees.size() == 0) return;
        int numberEmployeeToFire = ThreadLocalRandom.current().nextInt(1, 4);

        List<Long> employeesToFire = new ArrayList<>();

        for (int i = 0; i < numberEmployeeToFire; i++) {
            int employeeToFireIdx = ThreadLocalRandom.current().nextInt(0, allDatabaseEmployees.size());

            DatabaseEmployee databaseEmployeeToFire = allDatabaseEmployees.get(employeeToFireIdx);
            employeesToFire.add(databaseEmployeeToFire.getId());
            allDatabaseEmployees.remove(employeeToFireIdx);
            for (Long id: employeesToFire) {
                employeeRepository.setFiredTime(firingPeriod.getTime(), id);
                logInConsole(id, firingPeriod, false);
            }
        }
    }

    public Department getRandomDepartment() {
        List<DatabaseDepartment> allDatabaseDepartment = departmentRepository.findAll();
        DatabaseDepartment databaseDepartment = allDatabaseDepartment.get(ThreadLocalRandom
                .current()
                .nextInt(0, allDatabaseDepartment.size()));
        Department department = new Department();
        department.setName(databaseDepartment.getName());
        department.setId(databaseDepartment.getUid());
        return department;
    }

    public void logInConsole(Long id, Calendar Date, boolean isHired) {
        Optional<DatabaseEmployee> databaseEmployee = employeeRepository.findById(id);
        Optional<DatabaseDepartment> department = departmentRepository.findById(databaseEmployee.get().getDatabaseDepartment().getUid());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Date.getTime() + ". Сотрудник " + databaseEmployee.get().getPerson().getUid());
        if (isHired) {
            stringBuilder.append(" нанят " + databaseEmployee.get().getHiredTime() +
                    ". Отдел: " + department.get().getName());
        } else {
            if (databaseEmployee.get().getFiredTime() != null) {
                long timeDiff = databaseEmployee.get().getFiredTime().getTime() - databaseEmployee.get().getHiredTime().getTime();
                long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
                stringBuilder.append(" уволен " + databaseEmployee.get().getFiredTime() +
                        ". Отдел: " + department.get().getName()
                        + " Проработал: " + daysDiff);
            }
        }
        System.out.println(stringBuilder);
    }
}