package com.revature.caliber.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.caliber.dto.TrainerDTO;
import com.revature.caliber.exception.ValidatorException;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.service.TrainerService;
import com.revature.caliber.validator.TrainerValidator;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/trainers")
/**
 * Controller for handling all requests having to do with Trainers
 * @author Ben Nemec
 *
 */
public class TrainerController {
	private static final Logger log = LoggerFactory.getLogger(TrainerController.class);
	private static final String ERROR = "Invalid trainer input";
	
	@Autowired
	TrainerService trainerService;
	
	
	/**
	 * Handles get request for all trainers
	 * @return A response entity with an OK status code and a list of all of the
	 * trainers as a JSON object
	 */

	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Trainer>> getAllTrainers() {
		log.debug("Viewing all trainers ");
		return new ResponseEntity<>(trainerService.getAllTrainers(), HttpStatus.OK);
	}

	 
	@PostMapping
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Object> addTrainer(@RequestBody TrainerDTO trainerDTO) {
		Trainer trainer = new Trainer();
			trainer.setTrainerId(trainerDTO.getTrainerId());
			trainer.setName(trainerDTO.getName());
			trainer.setEmail(trainerDTO.getEmail());
			trainer.setTitle(trainerDTO.getTitle());
			trainer.setTier(trainerDTO.getTier());
		log.debug("Adding trainer {}", trainerDTO);
		try {
			TrainerValidator.validateTrainer(trainer);
		}catch(ValidatorException v) {
			log.debug(ERROR);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		trainerService.addTrainer(trainer);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@PutMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Object> editTrainer(@PathVariable("id") Integer id, @Valid @RequestBody TrainerDTO trainerDTO) {
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerDTO.getTrainerId());
		trainer.setName(trainerDTO.getName());
		trainer.setEmail(trainerDTO.getEmail());
		trainer.setTitle(trainerDTO.getTitle());
		trainer.setTier(trainerDTO.getTier());
		log.debug("Editing trainer {}", trainer);
		try {
			TrainerValidator.validateTrainer(trainer);
		}catch(ValidatorException v) {
			log.debug(ERROR);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		trainerService.editTrainer(trainer);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
	
	@PatchMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Object> disableTrainer(@PathVariable("id") Integer id, @RequestBody Trainer trainer){
		//No need to set a new trainer as it is already created.
		log.debug("Disabling trainer " + trainer);
		try {
			TrainerValidator.validateTrainer(trainer);
		} catch(ValidatorException v) {
			log.debug(ERROR);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		trainerService.disableTrainer(trainer);
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}
