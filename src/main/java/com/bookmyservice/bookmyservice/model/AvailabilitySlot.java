package com.bookmyservice.bookmyservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class AvailabilitySlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private ServiceProvider provider;

    private LocalDate serviceDate;

    private LocalTime startTime;
    private LocalTime endTime;

    private String status; // AVAILABLE / BOOKED
}
