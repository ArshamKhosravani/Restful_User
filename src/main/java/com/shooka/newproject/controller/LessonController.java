package com.shooka.newproject.controller;

import com.shooka.newproject.model.Lesson;
import com.shooka.newproject.model.LessonDto;
import com.shooka.newproject.repository.UserRepository;
import com.shooka.newproject.service.LessonService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@AllArgsConstructor
@Getter
public class LessonController {

    private LessonService lessonService;
    private UserRepository userRepository;

    @PostMapping("/assign/{id}/")
    public ResponseEntity<?> assignLessons(@PathVariable Long id, @RequestBody Set<LessonDto> lessons) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        lessonService.assignLessonsToUser(id, lessons);
        return ResponseEntity.ok().body("Lessons set!");
    }
}
