package com.example.test.Repos.Custom;

import com.example.test.DatabaseEntities.DatabaseGuest;
import com.example.test.Entities.Guest;

public interface GuestRepositoryCustom {
    public DatabaseGuest saveGuest(Guest guest);
}
