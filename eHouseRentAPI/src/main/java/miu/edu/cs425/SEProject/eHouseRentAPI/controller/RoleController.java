package miu.edu.cs425.SEProject.eHouseRentAPI.controller;


import miu.edu.cs425.SEProject.eHouseRentAPI.model.Role;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.RoleService;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "/ehouserent/user/role")
public class RoleController {

    @Autowired

    RoleService roleService;
    @Autowired
    UserService userService;

    @GetMapping(value="/list")
    public  Role[] getAllRole()
    {
        return roleService.getAllRole();
    }









}
