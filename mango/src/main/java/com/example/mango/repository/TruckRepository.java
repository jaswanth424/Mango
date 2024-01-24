package com.example.mango.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.mango.model.Truck;

public interface TruckRepository extends JpaRepository<Truck, Long> {
}
