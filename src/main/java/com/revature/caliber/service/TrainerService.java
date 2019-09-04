package com.revature.caliber.service;

import java.util.List;

import com.revature.caliber.pojo.Trainer;

/**
 * Interface for the service that handles all business logic having to do with
 * trainers
 * @author Ben Nemec
 *
 */
public interface TrainerService {
	
	/**
	 * Gets all of the trainers in the database
	 * @return A list of all of the trainers in the database
	 */
	//Change all methods to default.
	List<Trainer> getAllTrainers();
	
	void addTrainer(Trainer trainer);
	
	void editTrainer(Trainer trainer);
	
	Trainer getTrainerByEmail(String email);
	
	public void disableTrainer(Trainer trainer);
}
