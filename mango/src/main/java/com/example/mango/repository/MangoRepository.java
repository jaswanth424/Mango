package com.example.mango.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.mango.model.Mango;

public interface MangoRepository extends CrudRepository<Mango, Integer> {
	Optional<Mango> findById(long id);
}
