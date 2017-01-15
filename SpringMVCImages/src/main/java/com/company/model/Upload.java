package com.company.model;

import javax.persistence.*;

@Entity
@Table(name = "upload")
public class Upload extends Model {
    @Column(name = "name")
    private String name;

    @Column(name = "content")
    private byte content[];

    public Upload() {
        super();
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
