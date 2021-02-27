package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
public class LessonService {

    private LessonRepository lessonRepository;
    private UserRepository userRepository;

    public void assignLessonsToUser(Long id, Set<LessonDto> lessons) {
        Lesson lesson = new Lesson();
        for (LessonDto lessonDto : lessons) {
            lesson.setLessonName(lessonDto.getLessonName());
        }

        userRepository.findById(id).get().setLessons((Set<Lesson>) lesson);
        userRepository.save(userRepository.findById(id).get());
    }
}
