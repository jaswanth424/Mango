package com.example.mango.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mango.model.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
