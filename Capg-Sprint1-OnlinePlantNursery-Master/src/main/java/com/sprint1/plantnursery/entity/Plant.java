package com.sprint1.plantnursery.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/*Entity Class for Plant
Author : Disha Kale
*/

@Entity
@Table(name="plant")
public class Plant {
	@Id
	@GeneratedValue
	private int plantId;
	private int plantHeight;
	private String plantSpread;
	private String name;
	private String bloomTime;
	private String medicinalOrCulinaryUse;
	private String difficultyLevel;
	private String temparature;
	private String typeOfPlant;
	private String plantDescription;
	private int plantsStock;
	private double plantCost;
	
	//@ManyToOne(fetch=FetchType.LAZY)
	//private Planter planter;
	
	
//	public Planter getPlanter() {
//		return planter;
//	}
//
//	public void setPlanter(Planter planter) {
//		this.planter = planter;
//	}

	public Plant()
	{
		
	}

	public int getPlantId() {
		return plantId;
	}

	public void setPlantId(int plantId) {
		this.plantId = plantId;
	}

	public int getPlantHeight() {
		return plantHeight;
	}

	public void setPlantHeight(int plantHeight) {
		this.plantHeight = plantHeight;
	}

	public String getPlantSpread() {
		return plantSpread;
	}

	public void setPlantSpread(String plantSpread) {
		this.plantSpread = plantSpread;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBloomTime() {
		return bloomTime;
	}

	public void setBloomTime(String bloomTime) {
		this.bloomTime = bloomTime;
	}

	public String getMedicinalOrCulinaryUse() {
		return medicinalOrCulinaryUse;
	}

	public void setMedicinalOrCulinaryUse(String medicinalOrCulinaryUse) {
		this.medicinalOrCulinaryUse = medicinalOrCulinaryUse;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getTemparature() {
		return temparature;
	}

	public void setTemparature(String temparature) {
		this.temparature = temparature;
	}

	public String getTypeOfPlant() {
		return typeOfPlant;
	}

	public void setTypeOfPlant(String typeOfPlant) {
		this.typeOfPlant = typeOfPlant;
	}

	public String getPlantDescription() {
		return plantDescription;
	}

	public void setPlantDescription(String plantDescription) {
		this.plantDescription = plantDescription;
	}

	public int getPlantsStock() {
		return plantsStock;
	}

	public void setPlantsStock(int plantsStock) {
		this.plantsStock = plantsStock;
	}

	public double getPlantCost() {
		return plantCost;
	}

	public void setPlantCost(double plantCost) {
		this.plantCost = plantCost;
	}

	@Override
	public String toString() {
		return "Plant [plantId=" + plantId + ", plantHeight=" + plantHeight + ", plantSpread=" + plantSpread + ", name="
				+ name + ", bloomTime=" + bloomTime + ", medicinalOrCulinaryUse=" + medicinalOrCulinaryUse
				+ ", difficultyLevel=" + difficultyLevel + ", temparature=" + temparature + ", typeOfPlant="
				+ typeOfPlant + ", plantDescription=" + plantDescription + ", plantsStock=" + plantsStock
				+ ", plantCost=" + plantCost  + "]";
	}
	

}
