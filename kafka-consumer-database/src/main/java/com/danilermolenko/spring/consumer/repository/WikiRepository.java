package com.danilermolenko.spring.consumer.repository;

import com.danilermolenko.spring.consumer.entity.Wikimedia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WikiRepository extends JpaRepository<Wikimedia, Long> {
}
