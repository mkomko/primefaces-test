package org.primefaces.test;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ApplicationScoped
public class Icon implements Serializable {
    public String getTest() {
        return "pi pi-at pi-spin";
    }
}
