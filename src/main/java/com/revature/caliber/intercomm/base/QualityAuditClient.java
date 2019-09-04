package com.revature.caliber.intercomm.base;

import com.revature.caliber.pojo.Trainee;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface QualityAuditClient {

	@PostMapping(value = "/qa/audit/notes/create-new-trainee-notes", produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void createNewTraineeNotes(@RequestBody Trainee trainee);
}
