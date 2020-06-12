package miu.edu.cs425.SEProject.eHouseRentAPI.service.impl;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.UserRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

@Autowired
    UserRepository userRepository;
    @Override
    public void save(User user) {
    userRepository.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
