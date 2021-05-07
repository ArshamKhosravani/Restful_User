package com.shooka.newproject.service;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;

import java.util.List;

public interface LessonService {

    Lesson getLesson(Long id);

    List<Lesson> getAllLessons();

    Lesson addLesson(LessonDto lesson);

    void deleteLesson(Long id);

    Lesson updateLesson(Long id, LessonDto lesson);
}
