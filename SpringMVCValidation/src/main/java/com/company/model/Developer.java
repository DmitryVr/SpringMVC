package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "developers")
public class Developer extends Model {
    @Size(min = 4, max = 10, message = "min = 4, max = 10")
    @Column(name = "name")
    private String name;

    public Developer() {
        super();
    }

    public Developer(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
