package miu.edu.cs425.SEProject.eHouseRentAPI.service;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void save(User user);
    public List<User> getAll();
    public Optional<User> findByUserName(String s);
}
