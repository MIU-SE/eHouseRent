package miu.edu.cs425.SEProject.eHouseRentAPI.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "booking_records")
public class BookingRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingRecordId;

    //    @DateTimeFormat
    @NotNull(message = "{NotNull}")
    private LocalDate checkInDate;
    //@DateTimeFormat
    @NotNull(message = "{NotNull}")
    private LocalDate checkOutDate;
    @NotNull(message = "{NoNUll}")
    private Double totalPrice;
    @OneToOne
    @JoinColumn(name = "houseId")
    private House house;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BookingRecord() {
    }

    public BookingRecord( LocalDate checkInDate, @NotNull(message = "{NotNull}") LocalDate checkOutDate, @NotNull(message = "{NoNUll}") Double totalPrice, House house, User user) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalPrice = totalPrice;
        this.house = house;
        this.user = user;
    }

    public Long getBookingRecordId() {
        return bookingRecordId;
    }

    public void setBookingRecordId(Long bookingRecordId) {
        this.bookingRecordId = bookingRecordId;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
}


