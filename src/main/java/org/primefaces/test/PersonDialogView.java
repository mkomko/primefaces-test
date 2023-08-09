package org.primefaces.test;

import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Reception;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Named
@ViewScoped
public class PersonDialogView implements Serializable {
    private boolean visible;
    private Person person;
    private List<PersonField> personFields;

    public void onOpen(
            @Observes(notifyObserver = Reception.IF_EXISTS)
            @DialogOpen
            PersonDialogInit personDialogInit)
    {
        person = personDialogInit.getPerson();

        visible = true;
    }

    public List<PersonField> getPersonFields() {
        if (!visible)
            return Collections.emptyList();

        if (personFields == null) {
            personFields = new ArrayList<>();
            PersonField personField = new PersonField();
            personField.setId(1L);
            personField.setName("Expiry date");
            personFields.add(personField);
        }

        return personFields;
    }

    public void cancel() {
        visible = false;
    }

    public boolean isVisible() {
        return visible;
    }

    public Person getPerson() {
        return person;
    }
}
