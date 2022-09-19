package com.example.test.RepositoryImpl;

import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Entities.Person;
import com.example.test.Repos.Custom.PersonRepositoryCustom;
import com.example.test.Repos.PersonRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Random;

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