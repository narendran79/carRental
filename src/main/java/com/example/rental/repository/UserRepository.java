package com.example.rental.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.rental.model.RegistrationRequest;

@Repository
public interface UserRepository extends JpaRepository<RegistrationRequest, Long> {

	List<RegistrationRequest> findByEmail(String email);

}
