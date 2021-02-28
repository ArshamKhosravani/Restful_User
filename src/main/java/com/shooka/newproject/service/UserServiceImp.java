package com.shooka.newproject.service;

import com.shooka.newproject.model.*;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.user);
        Set<Lesson> lessonSet = Collections.emptySet();

        for (LessonDto lesson : userDto.getLessons()) {
            Optional<Lesson> optionalLesson = lessonRepository.findByLessonName("Math");
            optionalLesson.ifPresent(ls -> {
                lessonSet.add(ls);
            });
        }

        user.setLessons(lessonSet);
        userRepository.save(user);
        return user;
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public User updatePerson(long id, UserDto userDto) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.user);
        userRepository.save(user);
        return user;
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
