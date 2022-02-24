package com.homeswap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeswap.models.Service;


@Repository
public interface ServicesRepo extends JpaRepository<Service,Long>   {

	//List<Service>findById(Long home); 
}
