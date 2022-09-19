package com.example.test.Repos;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.DatabaseEntities.DatabaseEmployee;
import com.example.test.Repos.Custom.EmployeeRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository<DatabaseEmployee, Long>, EmployeeRepositoryCustom {
    @Modifying
    @Transactional
    @Query("UPDATE DatabaseEmployee p SET p.firedTime = ?1 WHERE p.id = ?2")
    public void setFiredTime(Date fired_time, Long id);




}
