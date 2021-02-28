package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;
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

    public Lesson addLesson(LessonDto lessonDto) {
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonDto.getLessonName());
        return lessonRepository.save(lesson);
    }

    public void deleteLesson(Long id) {
        lessonRepository.deleteById(id);
    }

    public Lesson updateLesson(Long id, LessonDto lessonDto) {
        Lesson lesson = lessonRepository.findById(id).get();
        lesson.setLessonName(lessonDto.getLessonName());
        return lessonRepository.save(lesson);
    }
}
