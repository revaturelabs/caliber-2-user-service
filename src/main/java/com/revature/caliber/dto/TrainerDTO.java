package com.revature.caliber.dto;

import com.revature.caliber.pojo.TrainerRole;

public class TrainerDTO {

	private int trainerId;
	private String name;
	private String title;
	private String email;
	private TrainerRole tier;
	
	public TrainerDTO() {
		
	}
	public TrainerDTO(int trainerId, String name, String title, String email, TrainerRole tier) {
		super();
		this.trainerId = trainerId;
		this.name = name;
		this.title = title;
		this.email = email;
		this.tier = tier;
	}

	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public TrainerRole getTier() {
		return tier;
	}
	public void setTier(TrainerRole tier) {
		this.tier = tier;
	}
}
