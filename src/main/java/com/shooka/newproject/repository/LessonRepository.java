package com.shooka.newproject.repository;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
    Optional<Lesson> findByLessonName(String lessonName);
}
