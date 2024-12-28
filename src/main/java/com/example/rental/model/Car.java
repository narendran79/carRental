package com.example.rental.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car")
public class Car {

	@Id
	private Integer carId;
	private String  carName;
	private String  details;
	private String  milege;
	private String  image;
	
	public Car() {
		
	}

	public Car(Integer carId, String carName, String details, String milege, String image) {
		super();
		this.carId = carId;
		this.carName = carName;
		this.details = details;
		this.milege = milege;
		this.image = image;
	}

	public Integer getCarId() {
		return carId;
	}

	public void setCarId(Integer carId) {
		this.carId = carId;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getMilege() {
		return milege;
	}

	public void setMilege(String milege) {
		this.milege = milege;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
