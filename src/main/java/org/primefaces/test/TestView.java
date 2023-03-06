package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Data;

import java.io.Serializable;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Department department;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }

}
