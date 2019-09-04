package com.revature.caliber.pojo;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

public class TraineeTest {

	private static Trainee trainee1;
	private static Trainee trainee2;
	private static Trainee trainee3;

	private static Trainer naresh;

	private static Timestamp t1;
	private static Timestamp t2;
	private static Timestamp t3;

	long currentTimeMillis = System.currentTimeMillis();

	@Before
	public void setUp() throws Exception {

		naresh = new Trainer("Naresh", "JFS Trainer", "naresh@revature.com", TrainerRole.ROLE_TRAINER);

		trainee1 = new Trainee();
		trainee1.setName("Carl");
		trainee1.setResourceId("resource1");
		trainee1.setEmail("email1@revature.com");
		trainee1.setBatchId(1);

		trainee2 = new Trainee("Ronald", "resource2", "email2@revature.com", 2);
		trainee3 = new Trainee("Fareed", "resource3", "email3@revature.com", 3);

		trainee1.setTraineeId(1);
		trainee2.setTraineeId(2);
		trainee3.setTraineeId(3);

		trainee1.setCollege("Virginia Tech");
		trainee2.setCollege("Virginia Tech");
		trainee3.setCollege("UIC");

		trainee1.setDegree("B.S.");
		trainee2.setDegree("B.S.");
		trainee3.setDegree("Engineering");

		trainee1.setFlagAuthor(naresh);
		trainee2.setFlagAuthor(naresh);
		trainee3.setFlagAuthor(naresh);

		trainee1.setFlagNotes("Poor QC");
		trainee2.setFlagNotes("Poor QC");
		trainee3.setFlagNotes("Poor QC");

		trainee1.setFlagStatus(TraineeFlag.RED);
		trainee2.setFlagStatus(TraineeFlag.RED);
		trainee3.setFlagStatus(TraineeFlag.RED);

		t1 = new Timestamp(currentTimeMillis);
		t2 = new Timestamp(currentTimeMillis);
		t3 = new Timestamp(currentTimeMillis);

		trainee1.setFlagTimestamp(t1);
		trainee2.setFlagTimestamp(t2);
		trainee3.setFlagTimestamp(t3);

		trainee1.setMajor("Math");
		trainee2.setMajor("Statistics");
		trainee3.setMajor("Computer Science");

		trainee1.setPhoneNumber("7038675309");
		trainee2.setPhoneNumber("7038675309");
		trainee3.setPhoneNumber("7038675309");

		trainee1.setProfileUrl("revature.com/trainee");
		trainee2.setProfileUrl("revature.com/trainee");
		trainee3.setProfileUrl("revature.com/trainee");

		trainee1.setProjectCompletion("Not finished");
		trainee2.setProjectCompletion("Not finished");
		trainee3.setProjectCompletion("Not finished");

		trainee1.setRecruiterName("Naresh");
		trainee2.setRecruiterName("Naresh");
		trainee3.setRecruiterName("Naresh");

		trainee1.setSkypeId("skype1");
		trainee2.setSkypeId("skype2");
		trainee3.setSkypeId("skype3");

		trainee1.setTechScreenerName("Bob");
		trainee2.setTechScreenerName("Bob");
		trainee3.setTechScreenerName("Bob");

		trainee1.setTechScreenScore(50.0);
		trainee2.setTechScreenScore(50.0);
		trainee3.setTechScreenScore(50.0);

		trainee1.setTrainingStatus(TrainingStatus.TRAINING);
		trainee2.setTrainingStatus(TrainingStatus.TRAINING);
		trainee3.setTrainingStatus(TrainingStatus.TRAINING);
	}

	@Test
	public void testGetTraineeId() {
		assertEquals(Integer.valueOf(1), trainee1.getTraineeId());
		assertEquals(Integer.valueOf(2), trainee2.getTraineeId());
		assertEquals(Integer.valueOf(3), trainee3.getTraineeId());
	}

	@Test
	public void testGetResourceId() {
		assertEquals("resource1", trainee1.getResourceId());
		assertEquals("resource2", trainee2.getResourceId());
		assertEquals("resource3", trainee3.getResourceId());
	}

	@Test
	public void testGetName() {
		assertEquals("Carl", trainee1.getName());
		assertEquals("Ronald", trainee2.getName());
		assertEquals("Fareed", trainee3.getName());
	}

	@Test
	public void testGetEmail() {
		assertEquals("email1@revature.com", trainee1.getEmail());
		assertEquals("email2@revature.com", trainee2.getEmail());
		assertEquals("email3@revature.com", trainee3.getEmail());
	}

	@Test
	public void testGetTrainingStatus() {
		assertEquals(TrainingStatus.TRAINING, trainee1.getTrainingStatus());
		assertEquals(TrainingStatus.TRAINING, trainee2.getTrainingStatus());
		assertEquals(TrainingStatus.TRAINING, trainee3.getTrainingStatus());
	}

	@Test
	public void testGetBatchId() {
		assertEquals(Integer.valueOf(1), trainee1.getBatchId());
		assertEquals(Integer.valueOf(2), trainee2.getBatchId());
		assertEquals(Integer.valueOf(3), trainee3.getBatchId());
	}

	@Test
	public void testGet() {
		assertEquals(Integer.valueOf(1), trainee1.getBatchId());
		assertEquals(Integer.valueOf(2), trainee2.getBatchId());
		assertEquals(Integer.valueOf(3), trainee3.getBatchId());
	}

	@Test
	public void testGetPhoneNumber() {
		assertEquals("7038675309", trainee1.getPhoneNumber());
		assertEquals("7038675309", trainee2.getPhoneNumber());
		assertEquals("7038675309", trainee3.getPhoneNumber());
	}

	@Test
	public void testGetSkpyeId() {
		assertEquals("skype1", trainee1.getSkypeId());
		assertEquals("skype2", trainee2.getSkypeId());
		assertEquals("skype3", trainee3.getSkypeId());
	}

	@Test
	public void testGetProfileUrl() {
		assertEquals("revature.com/trainee", trainee1.getProfileUrl());
		assertEquals("revature.com/trainee", trainee2.getProfileUrl());
		assertEquals("revature.com/trainee", trainee3.getProfileUrl());
	}

	@Test
	public void testGetRecruiterName() {
		assertEquals("Naresh", trainee1.getRecruiterName());
		assertEquals("Naresh", trainee2.getRecruiterName());
		assertEquals("Naresh", trainee3.getRecruiterName());
	}

	@Test
	public void testGetCollege() {
		assertEquals("Virginia Tech", trainee1.getCollege());
		assertEquals("Virginia Tech", trainee2.getCollege());
		assertEquals("UIC", trainee3.getCollege());
	}

	@Test
	public void testGetDegree() {
		assertEquals("B.S.", trainee1.getDegree());
		assertEquals("B.S.", trainee2.getDegree());
		assertEquals("Engineering", trainee3.getDegree());
	}

	@Test
	public void testGetMajor() {
		assertEquals("Math", trainee1.getMajor());
		assertEquals("Statistics", trainee2.getMajor());
		assertEquals("Computer Science", trainee3.getMajor());
	}

	@Test
	public void testGetTechScreenerName() {
		assertEquals("Bob", trainee1.getTechScreenerName());
		assertEquals("Bob", trainee2.getTechScreenerName());
		assertEquals("Bob", trainee3.getTechScreenerName());
	}

	@Test
	public void testGetTechScreenScore() {
		assertEquals(Double.valueOf(50.0), trainee1.getTechScreenScore());
		assertEquals(Double.valueOf(50.0), trainee2.getTechScreenScore());
		assertEquals(Double.valueOf(50.0), trainee3.getTechScreenScore());
	}

	@Test
	public void testGetProjectCompletion() {
		assertEquals("Not finished", trainee1.getProjectCompletion());
		assertEquals("Not finished", trainee2.getProjectCompletion());
		assertEquals("Not finished", trainee3.getProjectCompletion());
	}

	@Test
	public void testGetFlagStatus() {
		assertEquals(TraineeFlag.RED, trainee1.getFlagStatus());
		assertEquals(TraineeFlag.RED, trainee2.getFlagStatus());
		assertEquals(TraineeFlag.RED, trainee3.getFlagStatus());
	}

	@Test
	public void testGetFlagNotes() {
		assertEquals("Poor QC", trainee1.getFlagNotes());
		assertEquals("Poor QC", trainee2.getFlagNotes());
		assertEquals("Poor QC", trainee3.getFlagNotes());
	}

	@Test
	public void testGetFlagNoteTimestamp() {
		assertEquals(new Timestamp(currentTimeMillis), trainee1.getFlagTimestamp());
		assertEquals(new Timestamp(currentTimeMillis), trainee2.getFlagTimestamp());
		assertEquals(new Timestamp(currentTimeMillis), trainee3.getFlagTimestamp());
	}

	@Test
	public void testGetFlagNoteAuthor() {
		assertEquals(naresh, trainee1.getFlagAuthor());
		assertEquals(naresh, trainee2.getFlagAuthor());
		assertEquals(naresh, trainee3.getFlagAuthor());
	}

}
