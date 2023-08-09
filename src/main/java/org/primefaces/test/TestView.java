package org.primefaces.test;

import jakarta.enterprise.event.Event;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    @Inject
    @DialogOpen
    private Event<PersonDialogInit> personDialogOpenEvent;

    public void openDialog() {
        Person person = new Person();
        person.setId(1L);

        PersonData personData = new PersonData();
        personData.setName("Test Person");

        person.setPersonData(personData);

        personDialogOpenEvent.fire(new PersonDialogInit(person));
    }
}
