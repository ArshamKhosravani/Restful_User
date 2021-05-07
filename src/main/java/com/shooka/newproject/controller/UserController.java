package com.shooka.newproject.controller;

import com.shooka.newproject.model.User;
import com.shooka.newproject.model.UserDto;
import com.shooka.newproject.repository.UserRepository;
import com.shooka.newproject.service.UserServiceImp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@Getter
public class UserController {

    private UserServiceImp userService;
    private UserRepository userRepository;

    @GetMapping("/getAll/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}/")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/createUser/")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        if (userRepository.findByUsername(userDto.getUsername()) != null)
            return ResponseEntity.badRequest().body("the user with this username is already exists!");
        if (userRepository.findByEmail(userDto.getEmail()) != null)
            return ResponseEntity.badRequest().body("the user with this Email is already exists!");
        userService.addUser(userDto);
        return ResponseEntity.ok().body("User Created");
    }

    @DeleteMapping("/user/{id}/")
    public ResponseEntity<?> deleteUser(@PathVariable long id) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        userService.removeUser(id);
        return ResponseEntity.ok("User removed!");
    }

    @PutMapping("/user/{id}/")
    public ResponseEntity<?> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        userService.updatePerson(id, userDto);
        return ResponseEntity.ok("User upadted!");
    }

    @PatchMapping("/user/{id}/username/{username}")
    public ResponseEntity<?> updateUserName(@PathVariable long id, @PathVariable String username) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        userService.updateUserName(id, username);
        return ResponseEntity.ok().body("Username updated!");
    }

    @PatchMapping("/user/{id}/email/{email}")
    public ResponseEntity<?> updateEmail(@PathVariable long id, @PathVariable String email) {
        if (userRepository.findById(id).isEmpty())
            return ResponseEntity.badRequest().body("the user with this id is not exists");
        userService.updateEmail(id, email);
        return ResponseEntity.ok().body("Email updated!");
    }

}
