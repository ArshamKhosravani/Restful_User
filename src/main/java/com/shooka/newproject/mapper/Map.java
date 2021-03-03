package com.shooka.newproject.mapper;

import com.shooka.newproject.model.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Map {
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public User convertToUser(UserDto userDto) {
        User user = modelMapper().map(userDto, User.class);
        user.setRole(Role.user);
        return user;
    }

    public Lesson convertToLesson(LessonDto lessonDto) {
        Lesson lesson = modelMapper().map(lessonDto, Lesson.class);
        return lesson;
    }

}
