package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private List<String> list;

    @PostConstruct
    public void init() {
        list = new ArrayList<>(Arrays.asList(
                "String 1",
                "String 2"
        ));
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public List<String> getList() {
        return list;
    }
}
