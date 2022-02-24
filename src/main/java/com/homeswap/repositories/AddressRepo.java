package com.homeswap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.homeswap.models.Address;

public interface AddressRepo extends JpaRepository<Address,Long> {

}
