package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import lombok.Data;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

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

    public MenuModel getModel() {
        DefaultMenuModel menuModel = new DefaultMenuModel();

        DefaultSubMenu subMenu = DefaultSubMenu.builder()
                .label("SubMenu")
                .build();

        DefaultMenuItem menuItem = DefaultMenuItem.builder()
                .value("MenuItem")
                .build();

        subMenu.getElements().add(menuItem);

        menuModel.getElements().add(subMenu);

        return menuModel;
    }
}
