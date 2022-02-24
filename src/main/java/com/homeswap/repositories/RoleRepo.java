package com.homeswap.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.homeswap.models.Role;
import com.homeswap.models.Enums.ERole;

public interface RoleRepo extends JpaRepository<Role, Long> {

	Optional<Role>findByName(ERole name);
}
