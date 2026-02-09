package com.bookmyservice.bookmyservice.repository;

import com.bookmyservice.bookmyservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
