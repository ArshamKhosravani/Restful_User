package com.shooka.newproject.service;

import com.shooka.newproject.model.User;
import com.shooka.newproject.model.UserDto;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(Long id);

    User addUser(User user);

    void removeUser(long id);

    User updatePerson(long id, User user);

    void updateUserName(long id, String username);

    void updateEmail(long id, String email);
}
