package com.shooka.newproject.controller;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;
import com.shooka.newproject.repository.LessonRepository;
import com.shooka.newproject.repository.UserRepository;
import com.shooka.newproject.service.LessonServiceImp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Getter
public class LessonController {

    private LessonServiceImp lessonServiceImp;
    private UserRepository userRepository;
    private LessonRepository lessonRepository;

    @GetMapping("/lesson/{id}/")
    public ResponseEntity<?> getLesson(@PathVariable Long id) {
        if (lessonRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("There is no lesson with that id!");
        return ResponseEntity.ok().body(lessonServiceImp.getLesson(id));
    }

    @GetMapping("/lessons/")
    public List<Lesson> getAllLessons() {
        return lessonServiceImp.getAllLessons();
    }

    @PostMapping("/addLesson/")
    public ResponseEntity<?> addLesson(@RequestBody LessonDto lessonDto) {
        lessonServiceImp.addLesson(lessonDto);
        return ResponseEntity.ok().body("Lesson added!");
    }

    @PutMapping("/lesson/{id}/")
    public ResponseEntity<?> updateLesson(@PathVariable Long id, @RequestBody LessonDto lessonDto) {
        if (lessonRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("There is no lesson with that id!");
        lessonServiceImp.updateLesson(id, lessonDto);
        return ResponseEntity.ok().body("Lesson updated!");
    }

    @DeleteMapping("/lesson/{id}/")
    public ResponseEntity<?> deleteLesson(@PathVariable Long id) {
        if (lessonRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("Lesson not found!");
        lessonServiceImp.deleteLesson(id);
        return ResponseEntity.ok().body("Lesson deleted!");
    }
}
