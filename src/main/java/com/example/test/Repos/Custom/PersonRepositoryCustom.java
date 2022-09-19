package com.example.test.Repos.Custom;

import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Entities.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryCustom {
    public DatabasePerson getPerson();
}
