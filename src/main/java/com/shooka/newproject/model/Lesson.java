package com.shooka.newproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
    @JsonIgnoreProperties("lessons")
    @JsonIgnore
    private List<User> users = new ArrayList<>();

}
