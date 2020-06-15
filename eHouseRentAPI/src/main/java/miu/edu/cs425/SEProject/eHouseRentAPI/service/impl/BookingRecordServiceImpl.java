package miu.edu.cs425.SEProject.eHouseRentAPI.service.impl;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.BookingRecord;
import miu.edu.cs425.SEProject.eHouseRentAPI.repository.BookingRecordRepository;
import miu.edu.cs425.SEProject.eHouseRentAPI.service.BookingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingRecordServiceImpl implements BookingRecordService {

    @Autowired
        BookingRecordRepository bookingRecordRepository;

        public void saveBooking(BookingRecord bookingRecord) {
               bookingRecordRepository.save(bookingRecord);
        }

        public void deletBooking(Long bookingRecordId) {
            bookingRecordRepository.deleteById(bookingRecordId);
        }

        public List<BookingRecord> getAllBookings() {
            return bookingRecordRepository.findAll();
        }



        public BookingRecord getBookingById(Long bookingRecordId) {

            return  bookingRecordRepository.findById(bookingRecordId).orElse(null);
        }
    }

