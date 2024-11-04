package org.primefaces.test;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Named
@ViewScoped
public class TestDialogAction implements Serializable {
    private boolean visible;

    public void show() {
        visible = true;
    }

    public void apply() {
        visible = false;
    }

    public void cancel() {
        visible = false;
    }
}
