package com.shooka.newproject.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
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
   // @JsonIgnoreProperties("lessons")
   // @JsonIgnore
    private Set<User> users = new HashSet<>();

}
