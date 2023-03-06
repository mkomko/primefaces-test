package org.primefaces.test;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
public class AutoCompleteDepartmentConverter extends AutoCompleteBaseConverter<Department> {
    private List<Department> allDepartments;

    @PostConstruct
    public void init() {
        allDepartments = new ArrayList<>();
        allDepartments.add(new Department(1, "Development"));
        allDepartments.add(new Department(2, "Sales"));
        allDepartments.add(new Department(3, "Logistics"));
    }

    @Override
    public List<Department> suggest(String query) {
        if (query == null)
            return Collections.emptyList();

        return allDepartments.stream()
                .filter(dep -> dep.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public String displayValueOf(Department entity) {
        return entity.getName();
    }

    @Override
    public Long getId(Department entity) {
        return entity.getId();
    }

    @Override
    public Department getEntity(Long id) {
        if (id == null)
            return null;

        return allDepartments.stream()
                .filter(dep -> dep.getId().equals(id))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
