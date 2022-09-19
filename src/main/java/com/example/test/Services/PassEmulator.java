package com.example.test.Services;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Enums.PersonType;
import com.example.test.Repos.DepartmentRepository;
import com.example.test.Repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Service
public class PassEmulator {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public void emulate(Calendar nowDate) {
        isCardCodeInSystem(nowDate);
    }

    private byte[] createCardCode() {
        byte[] card = new byte[16];
        new Random().nextBytes(card);
        return card;
    }


    private void isCardCodeInSystem(Calendar nowDate) {
        if (new Random().nextInt(5) == 0) {
            log(createCardCode());
        } else {
            DatabasePerson randomPerson = personRepository.getPerson();
            if (randomPerson != null)
                log(nowDate, randomPerson);
            else {
                System.out.println("Человек не найден");
            }
        }
    }

    private void log(byte[] card) {
        System.out.println("Поднесена неизвестная карта " + card.toString());
    }

    private void log(Calendar nowDate, DatabasePerson person) {
        if (person.getType() == PersonType.EMPLOYEE) {
            if (person.getDatabaseEmployee().getFiredTime() == null) {
                System.out.println(nowDate.getTime()
                        + " Предоставлен доступ сотруднику "
                        + person.getUid().toString()
                        + " Отдел: "
                        + person.getDatabaseEmployee().getDatabaseDepartment().getName()
                        + ". Карта: "
                        + Arrays.toString(person.getCard()));
            } else {
                System.out.println(nowDate.getTime()
                        + " Доступ запрещен сотруднику "
                        + person.getUid().toString()
                        + " Отдел: " + departmentRepository.findById(person
                                .getDatabaseEmployee()
                                .getDatabaseDepartment().getUid())
                        .get().getName()
                        + ". Карта: "
                        + Arrays.toString(person.getCard()));
            }
        } else {
            if (Objects.equals(person.getDatabaseGuest().getVisitDate(), nowDate.getTime())) {
                System.out.println(nowDate.getTime()
                        + "Предоставлен доступ гостю "
                        + person.getUid().toString()
                        + " Пришел к " + person.getDatabaseGuest().getEmpId()
                        + " из отдела: "
                        + departmentRepository
                        .findByDatabaseEmployee(person
                                .getDatabaseGuest()
                                .getEmpId())
                        .getName()
                        + ". Карта: "
                        + Arrays.toString(person.getCard()));
            } else {
                System.out.println(nowDate.getTime()
                        + " Доступ запрещен гостю "
                        + person.getUid().toString()
                        + ". Карта: "
                        + Arrays.toString(
                        personRepository
                                .findById(person
                                        .getUid())
                                .get()
                                .getCard()
                                .toString()
                                .getBytes(StandardCharsets.UTF_8)));
            }
        }
    }
}

