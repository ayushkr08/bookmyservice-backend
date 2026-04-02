package com.bookmyservice.bookmyservice.controller;

import com.bookmyservice.bookmyservice.dto.BookingRequest;
import com.bookmyservice.bookmyservice.model.Booking;
import com.bookmyservice.bookmyservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> bookSlot(@RequestBody BookingRequest request) {
        Booking booking = bookingService.bookSlot(
                request.getSlotId(),
                request.getCustomerId()
        );
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }
}