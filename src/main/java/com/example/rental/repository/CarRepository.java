package com.example.rental.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.rental.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
	List<Car> findBycarName(String carName);
}
