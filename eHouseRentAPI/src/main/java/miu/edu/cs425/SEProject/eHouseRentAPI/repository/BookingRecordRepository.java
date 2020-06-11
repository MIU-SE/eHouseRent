package miu.edu.cs425.SEProject.eHouseRentAPI.repository;

import miu.edu.cs425.SEProject.eHouseRentAPI.model.BookingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRecordRepository extends JpaRepository<BookingRecord, Long> {
}
