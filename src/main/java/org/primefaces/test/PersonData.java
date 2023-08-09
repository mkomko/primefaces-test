package org.primefaces.test;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class PersonData implements Serializable {
    private String name;
    private Date expiryDate;
}
