package org.primefaces.test;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class PersonDialogInit implements Serializable {
    private final Person person;

    public PersonDialogInit(Person person)
    {
        this.person = person;
    }
}
