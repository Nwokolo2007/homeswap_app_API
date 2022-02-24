package com.homeswap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.homeswap.models.Rules;



@Repository
public interface RulesRepo extends JpaRepository<Rules,Long> 
{
	//List<LifeStyle>findById(Long Id); 
}

