package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.Role;
import com.shooka.newproject.model.User;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        user.setLessons(Collections.emptySet());
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public User addUser(User user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(Role.user);
        Set<Lesson> lessonSet = new HashSet<>();

        for (Lesson lesson : user.getLessons()) {
            lessonSet.add(lessonRepository.findByLessonName(lesson.getLessonName()));
        }

        user.setLessons(lessonSet);
        userRepository.save(newUser);
        return newUser;
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public User updatePerson(long id, User user) {
        User newUser = userRepository.findById(id).get();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setRole(Role.user);
        userRepository.save(user);
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
