package com.digi.controller;

import com.digi.dto.requestdto.UserDTO;
import com.digi.model.User;
import com.digi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
    }


    @GetMapping
    public List<User>getAll(@RequestParam(required = false) String name){
        return userService.getAll(name);
    }

    @GetMapping("/get-by-surname")
    public List<User> getBySurname(@RequestParam(required = false)String surname){
        return userService.getBySurname(surname);
    }
    @GetMapping("/get-by-year")
    public List<User> getByYear(@RequestParam(required = false)Integer year){
        return userService.getByYear(year);
    }

    @GetMapping("/get-by-email")
    public User getByEmail(@RequestParam String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id,@RequestBody UserDTO userDTO){
        return userService.updateUser(id,userDTO);
    }
    @PatchMapping("/change-fullname")
    public User changeFullName(@RequestParam int id,@RequestParam String name,@RequestParam String surname){
        return userService.changeFullName(id, name, surname);
    }
    @PatchMapping("/change-email")
    public User changeEmail(@RequestParam int id,@RequestParam String email){
        return userService.changeEmail(id, email);
    }
    @PatchMapping("/change-password")
    public User changePassword(@RequestParam int id,@RequestParam String password){
        return userService.changePassword(id, password);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@RequestParam int id){
        userService.deleteUser(id);
    }
}
