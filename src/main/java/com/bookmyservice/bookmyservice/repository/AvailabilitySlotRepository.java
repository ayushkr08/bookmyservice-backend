package com.bookmyservice.bookmyservice.repository;

import com.bookmyservice.bookmyservice.model.AvailabilitySlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.LockModeType;
import java.util.Optional;

public interface AvailabilitySlotRepository extends JpaRepository<AvailabilitySlot, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("SELECT s FROM AvailabilitySlot s WHERE s.id = :slotId")
    Optional<AvailabilitySlot> findByIdForUpdate(Long slotId);
}
