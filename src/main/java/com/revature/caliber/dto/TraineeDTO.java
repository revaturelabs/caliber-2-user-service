package com.revature.caliber.dto;

import java.sql.Timestamp;

import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.pojo.TraineeFlag;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainingStatus;

public class TraineeDTO {
	
	private Integer traineeId;
	private String resourceId;
	private String name;
	private String email;	
	private TrainingStatus trainingStatus;
	private Integer batchId;
	private String phoneNumber;
	private String skypeId;
	private String profileUrl;
	private String recruiterName;
	private String college;
	private String degree;
	private String major;
	private String techScreenerName;
	private Double techScreenScore;
	private String projectCompletion;
	private TraineeFlag flagStatus;
	private String flagNotes;
	private Timestamp flagNoteTimestamp;
	private Trainer flagNoteAuthor;
	
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getResourceId() {
		return resourceId;
	}
	public void setResourceId(String resourceId) {
		this.resourceId = resourceId;
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
	public Double getTechScreenScore() {
		return techScreenScore;
	}
	public void setTechScreenScore(Double techScreenScore) {
		this.techScreenScore = techScreenScore;
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
	public Timestamp getFlagNoteTimestamp() {
		return flagNoteTimestamp;
	}
	public void setFlagNoteTimestamp(Timestamp flagNoteTimestamp) {
		this.flagNoteTimestamp = flagNoteTimestamp;
	}
	public Trainer getFlagNoteAuthor() {
		return flagNoteAuthor;
	}
	public void setFlagNoteAuthor(Trainer flagNoteAuthor) {
		this.flagNoteAuthor = flagNoteAuthor;
	}
	
	@Override
	public String toString() {
		return "TraineeDTO [traineeId=" + traineeId + ", resourceId=" + resourceId + ", name=" + name + ", email="
				+ email + ", trainingStatus=" + trainingStatus + ", batchId=" + batchId + ", phoneNumber=" + phoneNumber
				+ ", skypeId=" + skypeId + ", profileUrl=" + profileUrl + ", recruiterName=" + recruiterName
				+ ", college=" + college + ", degree=" + degree + ", major=" + major + ", techScreenerName="
				+ techScreenerName + ", techScreenScore=" + techScreenScore + ", projectCompletion=" + projectCompletion
				+ ", flagStatus=" + flagStatus + ", flagNotes=" + flagNotes + ", flagNoteTimestamp=" + flagNoteTimestamp
				+ ", flagNoteAuthor=" + flagNoteAuthor + "]";
	}
	
	public Trainee generateModel() {
		Trainee ret = new Trainee(this.name, this.resourceId, this.email, this.batchId);
		ret.setCollege(this.college);
		ret.setDegree(this.degree);
		ret.setFlagAuthor(this.flagNoteAuthor);
		ret.setFlagNotes(this.flagNotes);
		ret.setFlagTimestamp(this.flagNoteTimestamp);
		ret.setMajor(this.major);
		ret.setPhoneNumber(this.phoneNumber);
		ret.setProfileUrl(this.profileUrl);
		ret.setProjectCompletion(this.projectCompletion);
		ret.setSkypeId(this.skypeId);
		ret.setTechScreenerName(this.techScreenerName);
		ret.setRecruiterName(this.recruiterName);
		ret.setTechScreenScore(this.techScreenScore);
		ret.setTraineeId(this.traineeId);
		ret.setTrainingStatus(this.trainingStatus);
		return ret;
	}
	
}
