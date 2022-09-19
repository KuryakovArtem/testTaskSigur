package com.example.test.Services;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.Entities.Employee;
import com.example.test.Repos.DepartmentRepository;
import com.example.test.Repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class DepartmentGenerator {
    private static final int MAX_NAME_LENGTH = 32;
    private static final int MIN_NAME_LENGTH = 1;
    private static final String LEXICON = " абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Autowired
    private DepartmentRepository repository;
    public void generateDepartment() {
        for (int i = 0; i < 10; i++) {
            DatabaseDepartment databaseDepartment = new DatabaseDepartment();
            databaseDepartment.setName(nameGenerator());
            repository.save(databaseDepartment);
        }
    }

    private String nameGenerator() {
        final Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        int length = rand.nextInt(MAX_NAME_LENGTH - MIN_NAME_LENGTH) + MIN_NAME_LENGTH;
        for (int i = 0; i < length; i++) {
            builder.append(LEXICON.charAt(rand.nextInt(LEXICON.length())));
        }
        return builder.toString();
    }
}
