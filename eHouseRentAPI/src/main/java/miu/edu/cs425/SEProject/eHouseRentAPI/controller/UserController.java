package miu.edu.cs425.SEProject.eHouseRentAPI.controller;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.UserRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.RoleService;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/ehouserent/user")
public class UserController {
//    @Autowired
//    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;

    @PostMapping(value = "/add")
    public void saveUser(@RequestBody User user){
          userService.save(user);

    }

    @GetMapping(value = "/list")
    public List<User> getListUser(){
        return userService.getAll();
    }
}


