package com.shooka.newproject.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Lesson_table")
@Data
public class Lesson {

    @Id
    @Column(name = "Lesson_Id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "Lesson_name", nullable = false)
    private String lessonName;

}
