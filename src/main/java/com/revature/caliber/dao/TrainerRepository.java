package com.revature.caliber.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.caliber.pojo.Trainer;


/**
 * Handles retrieving Trainers from the database
 * @author Ben Nemec
 *
 */
@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
	
	@Query("select t from Trainer t where t.email = :email")
	Trainer findByEmail(@Param("email") String email);

}
