package com.shooka.newproject.controller;

import com.shooka.newproject.service.AssignLessonToUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignLessonToUserController {

    private AssignLessonToUserService assignLessonToUserService;

    @PostMapping("/assign/{id}/")
    public ResponseEntity assignLessonToUser(@PathVariable Long id, @RequestBody List<Long> lessons) {
        assignLessonToUserService.assignLessonsToUser(id, lessons);
        return ResponseEntity.ok().body("Lessons assigned to user");
    }
}
