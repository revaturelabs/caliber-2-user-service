package com.revature.caliber.validator;

import static org.junit.Assert.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.revature.caliber.exception.ValidatorException;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainerRole;

@Component
public class TrainerValidatorTest {
	private static ValidatorFactory validatorFactory;
	private static Validator validator;

	@BeforeClass
	public static void createValidator() {
		validatorFactory = Validation.buildDefaultValidatorFactory();
		validator = validatorFactory.getValidator();
	}

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testTrainerValidator() {
		Trainer testTrainer = new Trainer("Nick", "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		Set<ConstraintViolation<Trainer>> violations = validator.validate(testTrainer);
		assertTrue(violations.isEmpty());

	}

	@Test(expected = ValidatorException.class)
	public void testValidatorNullName() throws ValidatorException {
		Trainer testNullName = new Trainer(null, "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testNullName);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorEmptyName() throws ValidatorException {
		Trainer testEmptyName = new Trainer("", "Trainer", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testEmptyName);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorNullEmail() throws ValidatorException {
		Trainer testNullEmail = new Trainer("Nick", "Trainer", null, TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testNullEmail);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorEmptyEmail() {
		Trainer testEmptyEmail = new Trainer("Nick", "Trainer", "", TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testEmptyEmail);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorNullTier() throws ValidatorException {
		Trainer testNullTier = new Trainer("Nick", "Trainer", "jurczakn@revature.com", null);
		TrainerValidator.validateTrainer(testNullTier);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorNullTitle() throws ValidatorException {
		Trainer testNullTitle = new Trainer("Nick", null, "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testNullTitle);
	}

	@Test(expected = ValidatorException.class)
	public void testValidatorEmptyTitle() throws ValidatorException {
		Trainer testEmptyTitle = new Trainer("Nick", "", "jurczakn@revature.com", TrainerRole.ROLE_TRAINER);
		TrainerValidator.validateTrainer(testEmptyTitle);
	}

	@AfterClass
	public static void close() {
		validatorFactory.close();
	}
}
