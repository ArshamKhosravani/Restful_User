package com.shooka.newproject.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.io.Serializable;
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

    @ManyToMany(mappedBy = "users")
    private Set<Lesson> lessons;

}
