package com.homeswap.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.homeswap.models.Home;
 // remember to change to Long
		@Repository
		public interface HomeRepo extends JpaRepository<Home,Long> {
			/*
			 * @Query("Select s.name,s.Id from service s,home_services hs where hs.home_id = home_id and s.Id = hs.service_id"
			 * ) List<Service>retrieveHomeServices(@Param("home_id")long home_id);
			 * 
			 * 
			 * @Query("Select r.name,r.id from Rules r inner join home_rules hr on (r.id = hr.rule_id) where hr.home_id = home_id"
			 * ) List<Rules>retrieveHomeRules(@Param("home_id")long home_id);
			 * 
			 * 
			 */
			
			 @Query(value = "Select c.* from home c where c.id is not null order by c.id desc limit ?1,  ?2 ", nativeQuery = true)         
			    List<Home> findHomes(int offset, int limit);        
			
			Home findById(@Param("home_id")long home_id);
		}
