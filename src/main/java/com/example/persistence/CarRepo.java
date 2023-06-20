package com.example.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.entities.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
