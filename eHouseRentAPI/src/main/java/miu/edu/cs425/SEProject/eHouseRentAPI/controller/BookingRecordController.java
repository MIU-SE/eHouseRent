package miu.edu.cs425.SEProject.eHouseRentAPI.controller;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.BookingRecord;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.impl.BookingRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
@RequestMapping(value = "ehouserent/booking")
public class BookingRecordController {
    @Autowired
    BookingRecordServiceImpl bookingRecordService;

    @PostMapping(value = "/add")
    public void creatBookingRecord(@RequestBody BookingRecord bookingRecord) {
        try {
            System.out.println("new booking record is coming");
           bookingRecordService.saveBooking(bookingRecord);
            System.out.println("why is not saving???????????");
        } catch (Exception ex) {
            System.out.println("Transaction Failed!!! "+ ex);
        }
    }
    @DeleteMapping(value = {"/delete/{bookingRecordId}"})
    public void deletBooking(@PathVariable("bookingRecordId") Long bookingRecordId ){
        bookingRecordService.deletBooking(bookingRecordId);
    }

    @GetMapping(value = "/list")
    public List<BookingRecord> getBooking(){
        return bookingRecordService.getAllBookings();
    }

//    @GetMapping(value = {"/get/{bookingRecordId}"})
//    public BookingRecord getBookingById(@PathVariable ("bookingRecordId") Long bookingRecordId){
//        return bookingRecordService.getBookingById(bookingRecordId);
//    }

}
