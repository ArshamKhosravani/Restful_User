package com.shooka.newproject.service;

import com.shooka.newproject.model.Role;
import com.shooka.newproject.model.User;
import com.shooka.newproject.model.UserDto;
import com.shooka.newproject.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@AllArgsConstructor
@Getter
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @PostConstruct
    public User initialAdmin() {
        User user = new User();
        user.setRole(Role.admin);
        user.setUsername("admin");
        user.setPassword("12345");
        user.setEmail("admin@gmail.com");
        userRepository.save(user);
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.findById(id).get();
    }

    public User addUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.user);
        userRepository.save(user);
        return user;
    }

    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    public User updatePerson(long id, UserDto userDto) {
        User user = userRepository.findById(id).get();
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(Role.user);
        userRepository.save(user);
        return user;
    }

    public void updateUserName(long id, String username) {
        User user = userRepository.findById(id).get();
        user.setUsername(username);
        userRepository.save(user);
    }

    public void updateEmail(long id, String email) {
        User user = userRepository.findById(id).get();
        user.setEmail(email);
        userRepository.save(user);
    }
}
