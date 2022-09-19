package com.example.test.RepositoryImpl;

import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Repos.Custom.PersonRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class PersonRepositoryImpl implements PersonRepositoryCustom {
    @Autowired
    private EntityManager entityManager;

    @Override
    public DatabasePerson getPerson() {
        Query query = entityManager.createQuery("select p " +
                "from DatabasePerson p " +
                "order by rand()").setMaxResults(1);
        return (DatabasePerson) query.getResultList().get(0);
    }
}