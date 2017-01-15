package com.company.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "developers")
public class Developer extends Model {
    @Column(name = "name")
    @Size(min = 4, max = 16, message = "{name.size.error}")
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
