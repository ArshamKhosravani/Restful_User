package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LessonServiceImp implements LessonService {

    private LessonRepository lessonRepository;

    public Lesson getLesson(Long id) {
        return lessonRepository.findById(id).get();
    }

    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    public Lesson addLesson(Lesson lesson) {
        Lesson newLesson = new Lesson();
        newLesson.setLessonName(lesson.getLessonName());
        return lessonRepository.save(newLesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson updateLesson(Long id, Lesson lesson) {
        Lesson newLesson = lessonRepository.findById(id).get();
        newLesson.setLessonName(lesson.getLessonName());
        return lessonRepository.save(newLesson);
    }
}
