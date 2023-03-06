package org.primefaces.test;

import java.io.Serializable;

public class Department implements Serializable {
    private Long id;
    private String name;

    public Department() {
    }

    public Department(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;

        if (!(o instanceof Department))
            return false;

        Department other = (Department) o;

        if (getId() != null && other.getId() != null)
            return getId().equals(other.getId());

        return false;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : super.hashCode();
    }

    @Override
    public String toString() {
        return "org.primefaces.test.Department[id=" + id + "]";
    }
}
