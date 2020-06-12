package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @Column(nullable = false)
    @NotBlank(message ="{NotBlank}" )
    private String houseNumber;
    @NotBlank(message ="{NotBlank}" )
    private String   street;
   // @Range(min = 5, max = 9, message="{zipcode}")
    private Integer zipCode;
    @NotBlank(message ="{NotBlank}" )
    private String city;
//  @Size( message = "{size.state}")
    @NotBlank(message ="{NotBlank}" )
    private String  state;

    public Address() {
    }

    public Address(String houseNumber, String street, Integer zipCode, String city, String state) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
        this.state = state;
    }

    public Address(@NotBlank(message = "{NotBlank}") String city, @NotBlank(message = "{NotBlank}") String state) {

        this.city = city;
        this.state = state;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressID(Long addressID) {
        this.addressId = addressId;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
