package com.example.mango.h2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mango.mango.model.Mango;

@Repository
public interface H2Repository extends JpaRepository<Mango, String> {

}
