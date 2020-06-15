package miu.edu.cs425.SEProject.eHouseRentAPI.repository;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



}
