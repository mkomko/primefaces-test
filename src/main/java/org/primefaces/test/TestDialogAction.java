package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.event.Reception;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@ViewScoped
public class TestDialogAction implements Serializable {
    private boolean visible;
    private List<Item> items;
    private Item selectedItem;

    @PostConstruct
    public void init() {
        items = new ArrayList<>();
        items.add(new Item(1L, "Item 1"));
        items.add(new Item(2L, "Item 2"));
        items.add(new Item(3L, "Item 3"));
    }

    public void onOpen(
            @Observes(notifyObserver = Reception.IF_EXISTS)
            @DialogOpen
            TestDialogInit testDialogInit) {
        visible = true;
    }

    public void onItemChanged(Object event) {
        System.out.println(event);
    }

    public boolean isVisible() {
        return visible;
    }

    public List<Item> getItems() {
        return items;
    }

    public Item getSelectedItem() {
        return selectedItem;
    }

    public void setSelectedItem(Item selectedItem) {
        System.out.println("Setter called");
        this.selectedItem = selectedItem;
    }
}
