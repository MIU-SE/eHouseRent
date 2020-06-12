package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @NotBlank(message ="{NotBlank}" )
    private String firstName;
    @NotBlank(message ="{NotBlank}" )
    private String lastName;
    @NotBlank(message ="{NotBlank}" )
    //@Size(min=10,max=10,message="{size.phoneNo}")
    //@Pattern(regexp="(^$|[0-9]{10})")
    private String phoneNo;
    //@Email
    @NotBlank(message ="{NotBlank}" )
    private String userName;
    @Size(min = 4, max = 20, message = "{size.password}")
    private String passWord;
    @Valid
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_Id")
    private Address address;
    @OneToMany(mappedBy = "owner")
    //@JsonIgnoreProperties("{ owner}")
    private List<House> userHouse;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_Id", referencedColumnName = "userId")},
            inverseJoinColumns = {@JoinColumn(name = "role_Id", referencedColumnName = "roleId")})
    private List<Role> role;
    @OneToMany(mappedBy = "user")
    private List<BookingRecord> bookingRecord;

    public User() {
    }

    public User(@NotBlank(message = "firstName must have value") String firstName, @NotBlank(message = "lastName must have value") String lastName, @NotBlank(message = "phoneNumber must have value") String phoneNo, @NotBlank(message = "userName must have value") String userName, @NotBlank(message = "passWord must have value") String passWord, Address address, List<House> userHouse, List<Role> role, List<BookingRecord> bookingRecord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNo = phoneNo;
        this.userName = userName;
        this.passWord = passWord;
        this.address = address;
        this.userHouse = userHouse;
        this.role = role;
        this.bookingRecord = bookingRecord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> role) {
        this.role = role;
    }

    public List<House> getUserHouse() {
        return userHouse;
    }

    public void setUserHouse(List<House> userHouse) {
        this.userHouse = userHouse;
    }

    public List<BookingRecord> getBookingRecord() {
        return bookingRecord;
    }

    public void setBookingRecord(List<BookingRecord> bookingRecord) {
        this.bookingRecord = bookingRecord;
    }
}
