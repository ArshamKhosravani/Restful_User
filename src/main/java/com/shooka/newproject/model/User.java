package com.shooka.newproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "USER")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_Id")
    private Long id;

    @Column(name = "user_name", nullable = false, unique = true)
    private String username;

    @Column(name = "user_pass", nullable = false)
    @Size(min = 5, max = 10)
    private String password;

    @Column(name = "user_email", nullable = false, unique = true)
    @Email
    private String email;

    @Column(name = "user_role", nullable = false)
    private Role role;

    @ManyToMany
   // @JsonIgnoreProperties("users")
    //@JsonIgnore
    @JoinTable(
            name = "user_lesson",
            joinColumns = @JoinColumn(name = "user_Id"),
            inverseJoinColumns = @JoinColumn(name = "Lesson_Id"))
    private Set<Lesson> lessons = new HashSet<>();

}
