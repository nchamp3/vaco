package com.example.vaco.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "blogs")
public class BlogEntity {

  @Id @GeneratedValue private int id;
  private String title;
  private String contents;
  private LocalDate timestamp;
  private int categoryId;
}
