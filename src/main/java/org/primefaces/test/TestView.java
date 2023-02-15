package org.primefaces.test;

import jakarta.annotation.PostConstruct;
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
    private Event<TestDialogInit> testDialogInitEvent;

    @PostConstruct
    public void init() {
    }

    public void openTestDialog() {
        testDialogInitEvent.fire(new TestDialogInit());
    }
}
