package com.example.test.Services;


import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.DatabaseEntities.DatabaseGuest;
import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Entities.Guest;
import com.example.test.Entities.Person;
import com.example.test.Enums.PersonType;
import com.example.test.Repos.EmployeeRepository;
import com.example.test.Repos.GuestRepository;
import com.example.test.Repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Service
public class GuestsMgr {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private GuestRepository guestRepository;

    public void createGuestsVisit() {
        List<DatabaseEmployee> allDatabaseEmployees = employeeRepository.findAll();
        List<Long> allEmployeesIds = new ArrayList<>();
        for (DatabaseEmployee allDatabaseEmployee : allDatabaseEmployees) {
            allEmployeesIds.add(allDatabaseEmployee.getPerson().getUid());
        }
        for (Long employeeId : allEmployeesIds) {
            if (new Random().nextInt(2) == 0) {
                generateGuest(employeeId);
            }
        }
    }

    public void generateGuest(Long employeeId) {
        Guest guest = new Guest();
        guest.setEmpId(employeeId);
        byte[] card = new byte[16];
        new Random().nextBytes(card);
        guest.setCard(card);
        Optional<DatabaseEmployee> employee = employeeRepository.findById(employeeId);
        guest.setVisitDate(generateRandomVisitDate(employee.get().getHiredTime()));
        DatabaseGuest databaseGuest = guestRepository.saveGuest(guest);
        logInConsole(databaseGuest, employee);
    }

    private Date generateRandomVisitDate(Date employeeHireDate) {
        long startDate = employeeHireDate.getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(employeeHireDate);
        calendar.add(Calendar.DATE, new Random().nextInt(179) + 1);
        long endDate = calendar.getTime().getTime();
        return new Date(ThreadLocalRandom.current().nextLong(startDate, endDate));
    }

    private void logInConsole(DatabaseGuest databaseGuest, Optional<DatabaseEmployee> employee) {
        long timeDiff = databaseGuest
                .getVisitDate()
                .getTime()
                - employeeRepository.findById(
                        databaseGuest
                                .getEmpId())
                .get()
                .getHiredTime()
                .getTime();
        long daysDiff = TimeUnit.DAYS.convert(timeDiff, TimeUnit.MILLISECONDS);
        System.out.println(
                "Гостю " + databaseGuest.getId()
                        + " назначена встреча сотруднику " + databaseGuest.getEmpId()
                        + ". Отдел: " + employee.get().getDatabaseDepartment().getName()
                        + " Дата встречи: " + databaseGuest.getVisitDate()
                        + " До встречи осталось: "
                        + daysDiff); 
    }
}
