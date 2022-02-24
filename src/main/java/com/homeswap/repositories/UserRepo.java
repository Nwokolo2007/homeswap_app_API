package com.homeswap.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeswap.models.User;

@Repository
public interface UserRepo  extends JpaRepository<User,Long>{

	Optional<User> findByUsername(String email);
	Boolean existsByUsername(String email);
	Boolean existsByEmail(String email);
}

