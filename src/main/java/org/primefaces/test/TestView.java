package org.primefaces.test;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;

import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import lombok.Data;
import org.primefaces.event.FileUploadEvent;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    private String string;
    private Integer integer;
    private BigDecimal decimal;
    private LocalDateTime localDateTime;

    @PostConstruct
    public void init() {
        string = "Welcome to PrimeFaces!!!";
    }

    public void onFileUpload(FileUploadEvent event) {
        System.out.println("File uploaded: " + event.getFile().getFileName());
    }
}
