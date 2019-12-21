package com.revature.caliber.dto;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.revature.caliber.json.TraineeDTODeserializer;
import com.revature.caliber.pojo.Trainee;
import com.revature.caliber.pojo.TraineeFlag;
import com.revature.caliber.pojo.Trainer;
import com.revature.caliber.pojo.TrainingStatus;

@JsonDeserialize(using= TraineeDTODeserializer.class)
public class TraineeDTO {
	
	private int traineeId;
	private String resourceId;
	private String name;
	private String email;	
	private TrainingStatus trainingStatus;
	private int batchId;
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
	
	public int getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(int traineeId) {
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
	public int getBatchId() {
		return batchId;
	}
	public void setBatchId(int batchId) {
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + batchId;
		result = prime * result + ((college == null) ? 0 : college.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((flagNoteAuthor == null) ? 0 : flagNoteAuthor.hashCode());
		result = prime * result + ((flagNoteTimestamp == null) ? 0 : flagNoteTimestamp.hashCode());
		result = prime * result + ((flagNotes == null) ? 0 : flagNotes.hashCode());
		result = prime * result + ((flagStatus == null) ? 0 : flagStatus.hashCode());
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((profileUrl == null) ? 0 : profileUrl.hashCode());
		result = prime * result + ((projectCompletion == null) ? 0 : projectCompletion.hashCode());
		result = prime * result + ((recruiterName == null) ? 0 : recruiterName.hashCode());
		result = prime * result + ((resourceId == null) ? 0 : resourceId.hashCode());
		result = prime * result + ((skypeId == null) ? 0 : skypeId.hashCode());
		result = prime * result + ((techScreenScore == null) ? 0 : techScreenScore.hashCode());
		result = prime * result + ((techScreenerName == null) ? 0 : techScreenerName.hashCode());
		result = prime * result + traineeId;
		result = prime * result + ((trainingStatus == null) ? 0 : trainingStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TraineeDTO other = (TraineeDTO) obj;
		if (batchId != other.batchId)
			return false;
		if (college == null) {
			if (other.college != null)
				return false;
		} else if (!college.equals(other.college))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (flagNoteAuthor == null) {
			if (other.flagNoteAuthor != null)
				return false;
		} else if (!flagNoteAuthor.equals(other.flagNoteAuthor))
			return false;
		if (flagNoteTimestamp == null) {
			if (other.flagNoteTimestamp != null)
				return false;
		} else if (!flagNoteTimestamp.equals(other.flagNoteTimestamp))
			return false;
		if (flagNotes == null) {
			if (other.flagNotes != null)
				return false;
		} else if (!flagNotes.equals(other.flagNotes))
			return false;
		if (flagStatus != other.flagStatus)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (profileUrl == null) {
			if (other.profileUrl != null)
				return false;
		} else if (!profileUrl.equals(other.profileUrl))
			return false;
		if (projectCompletion == null) {
			if (other.projectCompletion != null)
				return false;
		} else if (!projectCompletion.equals(other.projectCompletion))
			return false;
		if (recruiterName == null) {
			if (other.recruiterName != null)
				return false;
		} else if (!recruiterName.equals(other.recruiterName))
			return false;
		if (resourceId == null) {
			if (other.resourceId != null)
				return false;
		} else if (!resourceId.equals(other.resourceId))
			return false;
		if (skypeId == null) {
			if (other.skypeId != null)
				return false;
		} else if (!skypeId.equals(other.skypeId))
			return false;
		if (techScreenScore == null) {
			if (other.techScreenScore != null)
				return false;
		} else if (!techScreenScore.equals(other.techScreenScore))
			return false;
		if (techScreenerName == null) {
			if (other.techScreenerName != null)
				return false;
		} else if (!techScreenerName.equals(other.techScreenerName))
			return false;
		if (traineeId != other.traineeId)
			return false;
		if (trainingStatus != other.trainingStatus)
			return false;
		return true;
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
	

}
