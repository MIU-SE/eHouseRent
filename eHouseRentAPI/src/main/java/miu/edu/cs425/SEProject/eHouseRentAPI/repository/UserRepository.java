package miu.edu.cs425.SEProject.eHouseRentAPI.repository;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String s);
    Boolean existsByUserName(String username);


}
