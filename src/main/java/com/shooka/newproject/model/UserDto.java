package com.shooka.newproject.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class UserDto {
    private String username;
    private String password;
    private String email;
    private Set<LessonDto> lessons = new HashSet<>();
}
