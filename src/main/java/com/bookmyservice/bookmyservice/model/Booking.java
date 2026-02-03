package com.bookmyservice.bookmyservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User customer;

    @ManyToOne
    private ServiceProvider provider;

    @OneToOne
    private AvailabilitySlot slot;

    private String status; // CREATED / CONFIRMED / CANCELLED

    private LocalDateTime createdAt = LocalDateTime.now();
}
