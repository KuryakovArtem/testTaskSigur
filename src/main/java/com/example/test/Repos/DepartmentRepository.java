package com.example.test.Repos;

import com.example.test.DatabaseEntities.DatabaseDepartment;
import com.example.test.Repos.Custom.DepartmentRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DatabaseDepartment, Long>, DepartmentRepositoryCustom {
    @Query("select d from DatabaseDepartment d where d.id =(select e.databaseDepartment from DatabaseEmployee e where id = ?1)")
    DatabaseDepartment findByDatabaseEmployee(Long id);
}
