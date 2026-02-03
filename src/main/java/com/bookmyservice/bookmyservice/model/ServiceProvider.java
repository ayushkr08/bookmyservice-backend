package com.bookmyservice.bookmyservice.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    private String serviceType; // MAID / ELECTRICIAN / COOK

    private Double rating;

    private Boolean active = true;
}
