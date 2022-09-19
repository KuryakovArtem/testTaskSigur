package com.example.test.RepositoryImpl;

import com.example.test.DatabaseEntities.DatabaseGuest;
import com.example.test.DatabaseEntities.DatabasePerson;
import com.example.test.Entities.Guest;
import com.example.test.Enums.PersonType;
import com.example.test.Repos.Custom.GuestRepositoryCustom;
import com.example.test.Repos.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class GuestRepositoryImpl implements GuestRepositoryCustom {
    @Autowired
    private GuestRepository guestRepository;
    @Override
    public DatabaseGuest saveGuest(Guest guest) {
        DatabasePerson person = new DatabasePerson();//засеттить поля
        person.setCard(guest.getCard());
        person.setType(PersonType.GUEST);
        DatabaseGuest databaseGuest = new DatabaseGuest();
        databaseGuest.setEmpId(guest.getEmpId());
        databaseGuest.setVisitDate(guest.getVisitDate());
        databaseGuest.setPerson(person);
        return guestRepository.save(databaseGuest);
    }
}
