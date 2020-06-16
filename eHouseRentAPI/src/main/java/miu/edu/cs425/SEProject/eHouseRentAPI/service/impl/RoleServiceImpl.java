package miu.edu.cs425.SEProject.eHouseRentAPI.service.impl;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.BookingRecord;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Role;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.RoleRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

@Autowired
RoleRepository roleRepository;

public Role[] getAllRole() {
     List<Role> roles= roleRepository.findAll();
     Role[] listroles= new Role [roles.size()];
       roles.toArray(listroles);
       return  listroles;
    }



}
