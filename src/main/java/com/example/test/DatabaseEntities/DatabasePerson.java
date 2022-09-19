package com.example.test.DatabaseEntities;

import com.example.test.Enums.PersonType;

import javax.persistence.*;


@Entity
@Table(name = "person")
public class DatabasePerson {

    @Id
    @GeneratedValue
    @Column(name = "uid", updatable = false, nullable = false)
    private Long uid;
    @Column(name = "card")
    private byte[] card;
    @Enumerated(EnumType.STRING)
    private PersonType type;

    @OneToOne(mappedBy = "person")
    private DatabaseEmployee databaseEmployee;

    @OneToOne(mappedBy = "person")
    private DatabaseGuest databaseGuest;

    public DatabasePerson() {
    }

    public DatabasePerson(Long uid, byte[] card, PersonType type) {
        this.uid = uid;
        this.card = card;
        this.type = type;
    }

    public DatabasePerson(Long uid, byte[] card, PersonType type, DatabaseEmployee databaseEmployee, DatabaseGuest databaseGuest) {
        this.uid = uid;
        this.card = card;
        this.type = type;
        this.databaseEmployee = databaseEmployee;
        this.databaseGuest = databaseGuest;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public byte[] getCard() {
        return card;
    }

    public void setCard(byte[] card) {
        this.card = card;
    }

    public PersonType getType() {
        return type;
    }

    public void setType(PersonType type) {
        this.type = type;
    }

    public DatabaseEmployee getDatabaseEmployee() {
        return databaseEmployee;
    }

    public void setDatabaseEmployee(DatabaseEmployee databaseEmployee) {
        this.databaseEmployee = databaseEmployee;
    }

    public DatabaseGuest getDatabaseGuest() {
        return databaseGuest;
    }

    public void setDatabaseGuest(DatabaseGuest databaseGuest) {
        this.databaseGuest = databaseGuest;
    }
}
