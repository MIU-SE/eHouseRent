package miu.edu.cs425.SEProject.eHouseRentAPI.service;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;

import java.util.List;

public interface UserService {
    public void save(User user);
    public List<User> getAll();
}
