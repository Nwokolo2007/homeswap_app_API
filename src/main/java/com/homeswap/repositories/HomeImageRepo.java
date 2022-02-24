package com.homeswap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeswap.models.HomeImage;



public interface HomeImageRepo extends JpaRepository<HomeImage, Long> {

}
