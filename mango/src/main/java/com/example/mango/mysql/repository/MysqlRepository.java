package com.example.mango.mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mango.car.model.Car;

@Repository
public interface MysqlRepository extends JpaRepository<Car, String> {
}
