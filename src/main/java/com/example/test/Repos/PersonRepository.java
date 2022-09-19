package com.example.test.Repos;

import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Repos.Custom.PersonRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<DatabasePerson, Long>, PersonRepositoryCustom {

}
