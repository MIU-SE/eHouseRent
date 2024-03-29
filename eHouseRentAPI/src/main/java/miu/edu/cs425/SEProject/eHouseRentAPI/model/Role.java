package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long roleId;
    @NotBlank(message ="{NotBlank}" )
    private String  role;
public Role(){}

    public Long getRoleId() {
        return roleId;


    }

    public Role(Long roleId, @NotBlank(message = "{NotBlank}") String role) {
        this.roleId = roleId;
        this.role = role;
    }

    public void setRoleID(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
