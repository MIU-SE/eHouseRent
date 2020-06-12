package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long houseId;
    @NotNull(message ="{NotBlank}" )
    private Double price;
    @NotBlank(message ="{NotBlank}" )
    private String houseType;
    @NotNull(message ="{NotBlank}" )
    private Integer numberOfRooms;
    @NotBlank(message ="{NotBlank}" )
    private String description;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="addres_Id")
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
   // @JsonIgnoreProperties("{userHouse}")
    @JsonBackReference()
    @JoinColumn(name = "owner_Id")
    private  User owner;

    public House() {
    }

    public House(@NotBlank(message = "price must have value") Double price, @NotBlank(message = "houseType must have value") String houseType, @NotBlank(message = "numberOfRooms must have value") Integer numberOfRooms, Address address, User owner, @NotBlank String description) {
        this.price = price;
        this.houseType = houseType;
        this.numberOfRooms = numberOfRooms;
        this.address = address;
        this.owner = owner;
        this.description = description;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseID(Long houseId) {
        this.houseId = houseId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
