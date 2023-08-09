package org.primefaces.test;

import lombok.Data;

import java.io.Serializable;

@Data
public class PersonField implements Serializable {
    private Long id;
    private String name;
}
