package org.example;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity

public class Planet {
    @Id
    private String id;
    private String name;
}
