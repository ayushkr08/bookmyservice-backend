package com.bookmyservice.bookmyservice.service;

import com.bookmyservice.bookmyservice.model.*;
import com.bookmyservice.bookmyservice.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookingService {

    private final AvailabilitySlotRepository slotRepository;
    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;

    public BookingService(
            AvailabilitySlotRepository slotRepository,
            BookingRepository bookingRepository,
            UserRepository userRepository
    ) {
        this.slotRepository = slotRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public Booking bookSlot(Long slotId, Long customerId) {

        // Lock the slot row
        AvailabilitySlot slot = slotRepository.findByIdForUpdate(slotId)
                .orElseThrow(() -> new RuntimeException("Slot not found"));

        // Validate availability
        if (!"AVAILABLE".equals(slot.getStatus())) {
            throw new RuntimeException("Slot already booked");
        }

        // Mark slot as booked
        slot.setStatus("BOOKED");

        // Create booking
        User customer = userRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setProvider(slot.getProvider());
        booking.setSlot(slot);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}
