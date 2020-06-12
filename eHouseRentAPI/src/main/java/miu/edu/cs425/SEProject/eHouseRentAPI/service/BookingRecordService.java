package miu.edu.cs425.SEProject.eHouseRentAPI.service;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.BookingRecord;

import java.util.List;

public interface BookingRecordService {
    public void saveBooking(BookingRecord booking) ;
    public void deletBooking(Long bookingRecordId);
    public List<BookingRecord> getAllBookings();
    public BookingRecord getBookingById(Long bookingRecordId);
}
