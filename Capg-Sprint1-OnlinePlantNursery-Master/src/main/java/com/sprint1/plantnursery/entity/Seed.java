package com.sprint1.plantnursery.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Controller Class for Seed Controller
Created By : Smita Pradhan 
*/

@Entity
@Table(name="seed")
public class Seed 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String bloomTime;
	private String watering;
	private String difficultyLevel;
	private String temprature;
	private String typeOfSeed;
	private String seedsDescription;
	private int seedsStock;
	private double seedsCost;
	private int seedsPerPacket;
	
	

	public int getSeedId() {
		return id;
	}

	public void setSeedId(int seedId) {
		this.id = seedId;
	}

	public String getCommanName() {
		return name;
	}

	public void setCommanName(String commanName) {
		this.name = commanName;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getWatering() {
		return watering;
	}

	public void setWatering(String watering) {
		this.watering = watering;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemprature() {
		return temprature;
	}

	public void setTemprature(String temprature) {
		this.temprature = temprature;
	}

	public String getTypeOfSeeds() {
		return typeOfSeed;
	}

	public void setTypeOfSeeds(String typeOfSeed) {
		this.typeOfSeed = typeOfSeed;
	}

	public String getSeedsDescription() {
		return seedsDescription;
	}

	public void setSeedsDescription(String seedsDescription) {
		this.seedsDescription = seedsDescription;
	}

	public int getSeedsStock() {
		return seedsStock;
	}

	public void setSeedsStock(int seedsStock) {
		this.seedsStock = seedsStock;
	}

	public double getSeedsCost() {
		return seedsCost;
	}

	public void setSeedsCost(double seedsCost) {
		this.seedsCost = seedsCost;
	}

	public int getSeedsPerPacket() {
		return seedsPerPacket;
	}

	public void setSeedsPerPacket(int seedsPerPacket) {
		this.seedsPerPacket = seedsPerPacket;
	}

	public Seed() {
		super();
		// TODO Auto-generated constructor stub
	}

}
