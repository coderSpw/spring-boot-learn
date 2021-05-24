package com.spw.dynamic.jpa.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="sync")
public class Sync {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
}
