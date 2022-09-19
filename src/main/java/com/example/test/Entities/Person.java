package com.example.test.Entities;

import com.example.test.Enums.PersonType;

public class Person {

    private Long uid;
    private byte[] card;
    private PersonType type;

    public Person(Long uid, byte[] card, PersonType type) {
        this.uid = uid;
        this.card = card;
        this.type = type;
    }

    public Person() {
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
}
