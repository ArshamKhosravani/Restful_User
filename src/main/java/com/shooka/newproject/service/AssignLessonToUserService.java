package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.User;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class AssignLessonToUserService {

    private UserRepository userRepository;
    private LessonRepository lessonRepository;

    public void assignLessonsToUser(Long id, List<Long> lessons) {
        User user = userRepository.findById(id).get();
        List<Lesson> lessonList = Collections.emptyList();
        for (Long lessonId : lessons) {
            lessonList.add(lessonRepository.findById(lessonId).get());
        }

        user.setLessons((Set<Lesson>) lessonList);
        userRepository.save(user);
    }
}
