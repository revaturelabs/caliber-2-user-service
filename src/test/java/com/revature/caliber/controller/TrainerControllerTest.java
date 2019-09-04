package com.revature.caliber.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.caliber.dto.TrainerDTO;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainerRole;
import com.revature.caliber.service.TrainerService;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class TrainerControllerTest {

	@Autowired
	private MockMvc mock;

	@MockBean
	TrainerService trainerService;

	// Mock the Trainer REST API.
	@InjectMocks
	TrainerController tc;

	private static Trainer trainerOne;

	private static Trainer trainerTwo;

	private static Trainer trainerThree;

	private static Trainer trainerFour;

	private static Trainer trainerFive;

	private static Trainer trainerSix;

	private static Trainer trainerSeven;

	private static Trainer trainerEight;

	private static Trainer trainerNine;

	private static Trainer trainerTen;

	private static List<Trainer> trainers;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		trainers = new ArrayList<Trainer>();
		trainerOne = new Trainer("Nick", "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		trainerTwo = new Trainer("Test2", "Head Trainer", "email.head@revature.com", TrainerRole.ROLE_TRAINER);
		trainerThree = new Trainer("Panel Person", "Paneler", "panel@revature.com", TrainerRole.ROLE_PANEL);
		trainerFour = new Trainer("VP", "VP", "vp@revature.com", TrainerRole.ROLE_VP);
		trainerFive = new Trainer("Quality Control", "QC", "qc@revature.com", TrainerRole.ROLE_QC);
		trainerSix = new Trainer("Staging Manager", "Staging Manager", "staging@revature.com",
				TrainerRole.ROLE_STAGING);
		trainerSeven = new Trainer("Not Active", "Backup Trainer", "inactive@revature.com", TrainerRole.ROLE_INACTIVE);
		trainerEight = new Trainer("Wesley", "Trainer", "singleton@revature.com", TrainerRole.ROLE_TRAINER);
		trainerNine = new Trainer("Pickles", "Trainer", "pickles@revature.com", TrainerRole.ROLE_TRAINER);
		trainerTen = new Trainer("Example", "Example", "example@revature.com", TrainerRole.ROLE_INACTIVE);
		trainerOne.setTrainerId(1);
		trainerTwo.setTrainerId(2);
		trainerThree.setTrainerId(3);
		trainerFour.setTrainerId(4);
		trainerFive.setTrainerId(5);
		trainerSix.setTrainerId(6);
		trainerSeven.setTrainerId(7);
		trainerEight.setTrainerId(8);
		trainerNine.setTrainerId(9);
		trainerTen.setTrainerId(10);
		trainers.add(trainerOne);
		trainers.add(trainerTwo);
		trainers.add(trainerThree);
		trainers.add(trainerFour);
		trainers.add(trainerFive);
		trainers.add(trainerSix);
		trainers.add(trainerSeven);
		trainers.add(trainerEight);
		trainers.add(trainerNine);
		trainers.add(trainerTen);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {

	}

	@Test
	public void testGetAllTrainers() throws Exception {
		when(trainerService.getAllTrainers()).thenReturn(trainers);
		mock.perform(get("/trainers")).andExpect(status().isOk()).andExpect(jsonPath("$[0].name").value("Nick"));
	}

	@Test
	public void testAddTrainers() throws Exception {
		TrainerDTO trainerDTO = new TrainerDTO(1, "Carl Pacquing", "Test Trainer", "myemail@gmail.com",
				TrainerRole.ROLE_INACTIVE);
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerDTO.getTrainerId());
		trainer.setName(trainerDTO.getName());
		trainer.setTitle(trainerDTO.getTitle());
		trainer.setEmail(trainerDTO.getEmail());
		trainer.setTier(trainerDTO.getTier());
		// Create a trainerJson Object.
		doNothing().when(trainerService).addTrainer(any(Trainer.class));
		String trainerJson = new ObjectMapper().writeValueAsString(trainer);
		// Perform a Mock REST API call.
		mock.perform(post("/trainers").contentType(MediaType.APPLICATION_JSON).content(trainerJson))
				.andExpect(status().isCreated());

	}

	public void testUpdateTrainers() throws Exception {
		TrainerDTO trainerDTO = new TrainerDTO(1, "Carl Pacquing", "Test Trainer", "myemail@gmail.com",
				TrainerRole.ROLE_INACTIVE);
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerDTO.getTrainerId());
		trainer.setName(trainerDTO.getName());
		trainer.setTitle(trainerDTO.getTitle());
		trainer.setEmail(trainerDTO.getEmail());
		trainer.setTier(trainerDTO.getTier());
		// Create a trainerJson Object.
		doNothing().when(trainerService).editTrainer(any(Trainer.class));
		String trainerJson = new ObjectMapper().writeValueAsString(trainer);
		// Perform a Mock REST API call.
		mock.perform(put("/trainers").contentType(MediaType.APPLICATION_JSON).content(trainerJson))
				.andExpect(status().isAccepted());
	}

	@Test
	public void testDisableTrainers() throws Exception {
		TrainerDTO trainerDTO = new TrainerDTO(1, "Evan Bradford", "Test Trainer", "myemail@gmail.com",
				TrainerRole.ROLE_QC);
		Trainer trainer = new Trainer();
		trainer.setTrainerId(trainerDTO.getTrainerId());
		trainer.setName(trainerDTO.getName());
		trainer.setTitle(trainerDTO.getTitle());
		trainer.setEmail(trainerDTO.getEmail());
		trainer.setTier(trainerDTO.getTier());
		// Create a trainerJson Object.
		doNothing().when(trainerService).disableTrainer(any(Trainer.class));
		String trainerJson = new ObjectMapper().writeValueAsString(trainer);
		// Perform a Mock REST API call.
		mock.perform(patch("/trainers/1").contentType(MediaType.APPLICATION_JSON).content(trainerJson))
				.andExpect(status().isAccepted());
	}
}
