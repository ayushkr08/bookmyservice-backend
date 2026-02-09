package com.bookmyservice.bookmyservice.repository;

import com.bookmyservice.bookmyservice.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceProviderRepository extends JpaRepository<ServiceProvider, Long> {
}
