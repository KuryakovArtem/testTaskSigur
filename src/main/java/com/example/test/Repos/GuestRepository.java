package com.example.test.Repos;

import com.example.test.DatabaseEntities.DatabaseGuest;
import com.example.test.Repos.Custom.GuestRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<DatabaseGuest, Long>, GuestRepositoryCustom {
}
