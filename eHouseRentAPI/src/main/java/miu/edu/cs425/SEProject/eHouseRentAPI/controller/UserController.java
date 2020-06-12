package miu.edu.cs425.SEProject.eHouseRentAPI.controller;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ehouserent/api")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public void saveUser(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping(value = "/get")
    public List<User> getListUser(){
        return userService.getAll();
    }
}


