package com.revature.caliber.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.revature.caliber.dao.TrainerRepository;
import com.revature.caliber.exception.ValidatorException;
import com.revature.caliber.pojo.Trainer;

@Component
public class TrainerValidator {
	TrainerValidator(){
	}
	@Autowired
	private TrainerRepository dao;


	public static void validateTrainer(Trainer in) {
		if(in.getName() == null || in.getName().isEmpty()) {
			throw new ValidatorException("Name is not valid!");
		} else if (in.getEmail() == null || in.getEmail().isEmpty()) {
			throw new ValidatorException("Email is not valid!");
		}  else if (in.getTier() == null) {
			throw new ValidatorException("Tier is not valid!");
		} else if (in.getTitle() == null || in.getTitle().isEmpty()) {
			throw new ValidatorException("Title is not valid!");
		}
	}
	
	public void validateEmail(String email) {
		if (dao.findByEmail(email) != null) {
			throw new ValidatorException("Email already exists");
		}
	}
}
