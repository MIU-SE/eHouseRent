package miu.edu.cs425.SEProject.eHouseRentAPI.repository;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long> {
}
