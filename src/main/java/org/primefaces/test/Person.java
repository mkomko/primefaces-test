package org.primefaces.test;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {
    private Long id;
    private PersonData personData;
}
