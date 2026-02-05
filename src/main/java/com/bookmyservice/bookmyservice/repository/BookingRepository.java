package com.bookmyservice.bookmyservice.repository;

import com.bookmyservice.bookmyservice.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
