package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

    @Inject
    private TestDialogAction testDialogAction;

    public void showDialog() {
        testDialogAction.show();
    }
}
