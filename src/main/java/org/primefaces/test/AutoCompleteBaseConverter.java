package org.primefaces.test;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;

import java.util.List;

public abstract class AutoCompleteBaseConverter<T> implements Converter<T> {
    @Override
    public T getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        try {
            if (s == null || s.length() == 0)
                return null;
            Long id = Long.parseLong(s);
            return getEntity(id);
        } catch (NumberFormatException e) {
            String message = String.format("Invalid id: %s", s);
            throw new ConverterException(message, e);
        }
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, T o) {
        if (o == null)
            return null;
        try {
            return "" + getId(o);
        } catch (ClassCastException e) {
            String message = String.format("Invalid object type: %s", o.getClass().getName());
            throw new ConverterException(message, e);
        }
    }

    public String getDisplayValue(T entity) {
        if (entity == null)
            return "";
        return displayValueOf(entity);
    }

    public abstract List<T> suggest(String query);

    public abstract String displayValueOf(T entity);

    public abstract Long getId(T entity);

    public abstract T getEntity(Long id);
}
