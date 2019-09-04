package com.revature.caliber.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.dao.TrainerRepository;
import com.revature.caliber.exception.ValidatorException;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainerRole;
import com.revature.caliber.validator.TrainerValidator;

/**
 * Implementation of the business logic for handling Trainer objects
 * 
 * @author Ben Nemec
 *
 */
@Service
public class TrainerServiceImpl implements TrainerService {

	/**
	 * The dao responsible for interacting with the trainer table
	 */
	@Autowired
	TrainerRepository dao;

	@Autowired
	TrainerValidator validateEmail;

	@Override
	public List<Trainer> getAllTrainers() {
		return dao.findAll();
	}

	@Override
	@Transactional
	public void addTrainer(Trainer trainer) {
		if (dao.findByEmail(trainer.getEmail()) != null) {
			validateEmail.validateEmail(trainer.getEmail());
		}
		dao.save(trainer);
	}

	@Override
	public void editTrainer(Trainer trainer) {
		//Trainer parameter is the edited Trainer information received from the front-end.
		
		//Retrieve the trainer information from the database.
		//This acts as a copy to check if the email is modified, 
		//since the email has a unique constraint.  
		Trainer findOne = dao.findOne(trainer.getTrainerId());
		//Check if email is modified.
		if (!findOne.getEmail().equals(trainer.getEmail()) && dao.findByEmail(trainer.getEmail()) != null) {
			//Check if the modified email already exists.
			throw new ValidatorException("The email already exists.");
		}
		dao.save(trainer);
	}
	
	@Override
	public void disableTrainer(Trainer trainer) {
		trainer.setTier(TrainerRole.ROLE_INACTIVE);
		dao.save(trainer);
	}

	@Override
	public Trainer getTrainerByEmail(String email) {
		return dao.findByEmail(email);
	}

}
