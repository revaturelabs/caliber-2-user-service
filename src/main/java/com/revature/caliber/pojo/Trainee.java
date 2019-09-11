package com.revature.caliber.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.StringJoiner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity which allows a user to store data in a database using Hibernate. This
 * entity is currently mapped to a table called CALIBER_TRAINEE
 */
@Entity
@Table(name = "CALIBER_TRAINEE")
public class Trainee implements Serializable {

	private static final long serialVersionUID = -9090223980655307018L;

	@Id
	@Column(name = "TRAINEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRAINEE_ID_SEQUENCE")
	@SequenceGenerator(name = "TRAINEE_ID_SEQUENCE", sequenceName = "TRAINEE_ID_SEQUENCE")
	private Integer traineeId;

	@Column(name = "RESOURCE_ID")
	private String resourceId;

	@NotEmpty
	@Column(name = "TRAINEE_NAME")
	private String name;

	@NotEmpty
	@Email
	@Column(name = "TRAINEE_EMAIL", nullable = false)
	private String email;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "TRAINING_STATUS")
	private TrainingStatus trainingStatus;

	@NotNull
	@Column(name = "BATCH_ID", nullable = false)
	private Integer batchId;

	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@Column(name = "SKYPE_ID")
	private String skypeId;

	@Column(name = "PROFILE_URL")
	private String profileUrl;

	@Column(name = "RECRUITER_NAME")
	private String recruiterName;

	@Column(name = "COLLEGE")
	private String college;

	@Column(name = "DEGREE")
	private String degree;

	@Column(name = "MAJOR")
	private String major;

	@Column(name = "TECH_SCREENER_NAME")
	private String techScreenerName;

	@Column(name = "TECH_SCREEN_SCORE", nullable = true)
	private Double techScreenScore;

	@Column(name = "REVPRO_PROJECT_COMPLETION")
	private String projectCompletion;

	@Enumerated(EnumType.STRING)
	@Column(name = "FLAG_STATUS")
	private TraineeFlag flagStatus;

	@Length(min = 0, max = 4000)
	@Column(name = "FLAG_NOTES", length = 4000)
	private String flagNotes;

	/**
 	* Most recent timestamp when the Trainee flag was changed
 	*/
	@Column(name = "FLAG_TIMESTAMP")
	private Timestamp flagNoteTimestamp;

	/**
 	* Author of the most recent Trainee flag change
 	*/
	@Column(name = "FLAG_AUTHOR")
	private Trainer flagNoteAuthor;
	
	public Trainee() {
		super();
		this.flagStatus = TraineeFlag.NONE;
		this.trainingStatus = TrainingStatus.SELECTED;
	}

	/**
	 * Constructor used mostly for testing. Default TrainingStatus as Training
	 * 
	 * @param name       The name of the trainee
	 * @param resourceId The resource id
	 * @param email      The trainee's email address
	 * @param batchId    The id of the trainee's batch
	 */
	public Trainee(String name, String resourceId, String email, Integer batchId) {
		super();
		this.name = name;
		this.resourceId = resourceId;
		this.email = email;
		this.trainingStatus = TrainingStatus.TRAINING;
		this.batchId = batchId;
	}

	public Integer getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TrainingStatus getTrainingStatus() {
		return trainingStatus;
	}

	public void setTrainingStatus(TrainingStatus trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	public Integer getBatchId() {
		return batchId;
	}

	public void setBatchId(Integer batchId) {
		this.batchId = batchId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSkypeId() {
		return skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public String getProfileUrl() {
		return profileUrl;
	}

	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	public String getResourceId() {
		return resourceId;
	}

	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
	}

	public String getRecruiterName() {
		return recruiterName;
	}

	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}

	public String getCollege() {
		return college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTechScreenerName() {
		return techScreenerName;
	}

	public void setTechScreenerName(String techScreenerName) {
		this.techScreenerName = techScreenerName;
	}

	public String getProjectCompletion() {
		return projectCompletion;
	}

	public void setProjectCompletion(String projectCompletion) {
		this.projectCompletion = projectCompletion;
	}

	public TraineeFlag getFlagStatus() {
		return flagStatus;
	}

	public void setFlagStatus(TraineeFlag flagStatus) {
		this.flagStatus = flagStatus;
	}

	public String getFlagNotes() {
		return flagNotes;
	}

	public void setFlagNotes(String flagNotes) {
		this.flagNotes = flagNotes;
	}

	public Double getTechScreenScore() {
		return techScreenScore;
	}

	public void setTechScreenScore(Double techScreenScore) {
		this.techScreenScore = techScreenScore;
	}

	public Trainer getFlagAuthor() {
		return flagNoteAuthor;
	}

	public void setFlagAuthor(Trainer author) {
		this.flagNoteAuthor = author;
	}

	public Timestamp getFlagTimestamp() {
		return flagNoteTimestamp;
	}

	public void setFlagTimestamp(Timestamp timestamp) {
		this.flagNoteTimestamp = timestamp;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Trainee.class.getSimpleName() + "[", "]")
						.add("traineeId=" + traineeId)
						.add("name='" + name + "'")
						.add("flagStatus=" + flagStatus)
						.add("flagNotes='" + flagNotes + "'")
						.add("flagNoteTimestamp=" + flagNoteTimestamp)
						.toString();
	}
}
