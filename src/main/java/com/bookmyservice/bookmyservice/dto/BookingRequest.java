package com.bookmyservice.bookmyservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private Long slotId;
    private Long customerId;
}