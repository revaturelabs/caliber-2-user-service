package com.revature.caliber.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.caliber.dao.TraineeRepository;
import com.revature.caliber.intercomm.base.QualityAuditClient;
import com.revature.caliber.pojo.Trainee;

/**Implementation of the service class for handling business logic 
 * of interacting with trainee objects
 * 
 * @author Christian Dawson, Justin Donn, and Ben Nemec
 *
 */
@Service
public class TraineeServiceImpl implements TraineeService {
	
	/**
	 * The dao responsible for interacting with the trainee table
	 */
	@Autowired 
	TraineeRepository dao;
	@Autowired
	QualityAuditClient qaClient;
	
	@Override
	public void save(Trainee trainee){
		dao.save(trainee);
		qaClient.createNewTraineeNotes(trainee);
	}

	@Override
	public List<Trainee> findAllByBatch(int batchId) {
		return dao.findByBatchId(batchId);
	}

	@Override
	public void update(Trainee trainee) {
		dao.save(trainee);
	}

	@Override
	public void delete(Integer traineeId) {
		dao.delete(traineeId);
	}
	
	@Override
	public void switchBatch(int traineeId, int batchId) {
		Trainee trainee = dao.findOne(traineeId);
		if(trainee != null) {
			trainee.setBatchId(batchId);
		}
		dao.save(trainee);
	}

	@Override
	public int[][] createArrayOfTraineeCounts(int[] batchIds) {
		int[][] toReturn = new int[batchIds.length][2];
		for(int i = 0; i < batchIds.length; i++) {
			toReturn[i][0] = batchIds[i];
			toReturn[i][1] = Integer.parseInt("" + dao.countByBatchId(batchIds[i]));
		}
		return toReturn;
	}
}
