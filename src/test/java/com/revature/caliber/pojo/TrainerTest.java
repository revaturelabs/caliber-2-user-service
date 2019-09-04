package com.revature.caliber.pojo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TrainerTest {

	private static Trainer trainerOne;
	private static Trainer trainerTwo;
	private static Trainer trainerThree;

	@Before
	public void setUp() throws Exception {
		trainerOne = new Trainer();
		trainerOne.setName("Nick");
		trainerOne.setTitle("Trainer");
		trainerOne.setEmail("jurczakn@revature.com");
		trainerOne.setTier(TrainerRole.ROLE_TRAINER);
//		trainerOne = new Trainer("Nick", "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		trainerTwo = new Trainer("Test2", "Head Trainer", "email.head@revature.com", TrainerRole.ROLE_TRAINER);
		trainerThree = new Trainer("Panel Person", "Paneler", "panel@revature.com", TrainerRole.ROLE_PANEL);

		trainerOne.setTrainerId(1);
		trainerTwo.setTrainerId(2);
		trainerThree.setTrainerId(3);
	}

	@Test
	public void testGetTrainerId() {
		assertEquals(Integer.valueOf(1), trainerOne.getTrainerId());
		assertEquals(Integer.valueOf(2), trainerTwo.getTrainerId());
		assertEquals(Integer.valueOf(3), trainerThree.getTrainerId());
	}

	@Test
	public void testSetTrainerId() {
		trainerOne.setTrainerId(4);
		assertEquals(Integer.valueOf(4), trainerOne.getTrainerId());
		trainerTwo.setTrainerId(5);
		assertEquals(Integer.valueOf(5), trainerTwo.getTrainerId());
		trainerThree.setTrainerId(6);
		assertEquals(Integer.valueOf(6), trainerThree.getTrainerId());
	}

	@Test
	public void testGetName() {
		assertEquals("Nick", trainerOne.getName());
		assertEquals("Test2", trainerTwo.getName());
		assertEquals("Panel Person", trainerThree.getName());
	}

	@Test
	public void testSetName() {
		trainerOne.setName("James");
		assertEquals("James", trainerOne.getName());
		trainerTwo.setName("Mike");
		assertEquals("Mike", trainerTwo.getName());
		trainerThree.setName("Peter");
		assertEquals("Peter", trainerThree.getName());
	}

	@Test
	public void testGetTitle() {
		assertEquals("Trainer", trainerOne.getTitle());
		assertEquals("Head Trainer", trainerTwo.getTitle());
		assertEquals("Paneler", trainerThree.getTitle());
	}

	@Test
	public void testSetTitle() {
		trainerOne.setTitle("James");
		assertEquals("James", trainerOne.getTitle());
		trainerTwo.setTitle("Mike");
		assertEquals("Mike", trainerTwo.getTitle());
		trainerThree.setTitle("Peter");
		assertEquals("Peter", trainerThree.getTitle());
	}

	@Test
	public void testGetEmail() {
		assertEquals("jurczakn@revature.com", trainerOne.getEmail());
		assertEquals("email.head@revature.com", trainerTwo.getEmail());
		assertEquals("panel@revature.com", trainerThree.getEmail());
	}

	@Test
	public void testSetEmail() {
		trainerOne.setEmail("james@revature.com");
		assertEquals("james@revature.com", trainerOne.getEmail());
		trainerTwo.setEmail("mike@revature.com");
		assertEquals("mike@revature.com", trainerTwo.getEmail());
		trainerThree.setEmail("peter@revature.com");
		assertEquals("peter@revature.com", trainerThree.getEmail());
	}

	@Test
	public void testGetTier() {
		assertEquals(TrainerRole.ROLE_TRAINER, trainerOne.getTier());
		assertEquals(TrainerRole.ROLE_TRAINER, trainerTwo.getTier());
		assertEquals(TrainerRole.ROLE_PANEL, trainerThree.getTier());
	}

	@Test
	public void testSetTier() {
		trainerOne.setTier(TrainerRole.ROLE_INACTIVE);
		assertEquals(TrainerRole.ROLE_INACTIVE, trainerOne.getTier());
		trainerTwo.setTier(TrainerRole.ROLE_QC);
		assertEquals(TrainerRole.ROLE_QC, trainerTwo.getTier());
		trainerThree.setTier(TrainerRole.ROLE_VP);
		assertEquals(TrainerRole.ROLE_VP, trainerThree.getTier());
	}

	@Test
	public void testToString() {
		assertEquals(
				"Trainer [trainerId=1, name=Nick, title=Trainer, email=jurczakn@revature.com, tier=ROLE_TRAINER, password=null]",
				trainerOne.toString());
		assertEquals(
				"Trainer [trainerId=2, name=Test2, title=Head Trainer, email=email.head@revature.com, tier=ROLE_TRAINER, password=null]",
				trainerTwo.toString());
		assertEquals(
				"Trainer [trainerId=3, name=Panel Person, title=Paneler, email=panel@revature.com, tier=ROLE_PANEL, password=null]",
				trainerThree.toString());
	}

	@Test
	public void testEquals() {
		assertTrue(trainerOne.equals(trainerOne));
		assertFalse(trainerOne.equals(trainerTwo));

		assertFalse(trainerOne.getName().equals(trainerTwo.getName()));
		assertFalse(trainerOne.getTitle().equals(trainerTwo.getTitle()));
		assertFalse(trainerOne.getEmail().equals(trainerTwo.getEmail()));
		assertFalse(trainerOne.getEmail().equals(trainerTwo.getEmail()));
		assertTrue(trainerOne.getTier().equals(trainerTwo.getTier()));

	}
}
