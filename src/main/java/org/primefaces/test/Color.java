package org.primefaces.test;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@ApplicationScoped
public class Color implements Serializable {
    public String getBlue() {
        return "color-blue";
    }
}
