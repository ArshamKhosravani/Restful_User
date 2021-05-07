package com.shooka.newproject.service;

import com.shooka.newproject.model.*;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private UserRepository userRepository;
    private LessonRepository lessonRepository;

    @PostConstruct
    public User initialAdmin() {
        User user = new User();
        user.setRole(Role.admin);
        user.setUsername("admin");
        user.setPassword("12345");
        user.setEmail("admin@gmail.com");
        user.setLessons(Collections.emptyList());
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(UserDto user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(Role.user);
        List<Lesson> lessonSet = new ArrayList<>();
        for (LessonDto lesson : user.getLessons()) {
            lessonSet.add(lessonRepository.findByLessonName(lesson.getLessonName()));
        }

        newUser.setLessons(lessonSet);
        userRepository.save(newUser);
        return newUser;
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public User updatePerson(long id, UserDto user) {
        User newUser = userRepository.findById(id).get();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(Role.user);
        List<Lesson> lessonSet = new ArrayList<>();
        for (LessonDto lesson : user.getLessons()) {
            lessonSet.add(lessonRepository.findByLessonName(lesson.getLessonName()));
        }
        userRepository.save(newUser);
        return newUser;
    }

    public void updateUserName(long id, String username) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        userRepository.save(user);
    }

    public void updateEmail(long id, String email) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);
    }
}
