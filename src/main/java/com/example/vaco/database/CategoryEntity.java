package com.example.vaco.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "categories")
public class CategoryEntity {

    @Id @GeneratedValue private int id;
    private String name;

}
