package com.ayurvedic.web.store.sprint1.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@GeneratedValue
	private int medicineId;
	private String medicineName;
	private float medicineCost;
	private LocalDate mfg;
	private LocalDate expiryDate;
	private String company;
	//private Category category;
	
	/*
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}*/
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public String getMedicineName() {
		return medicineName;
	}
	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}
	public float getMedicineCost() {
		return medicineCost;
	}
	public void setMedicineCost(float medicineCost) {
		this.medicineCost = medicineCost;
	}
	public LocalDate getMfg() {
		return mfg;
	}
	public void setMfg(LocalDate mfg) {
		this.mfg = mfg;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	@Override
	public String toString() {
		return "Medicine [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ medicineCost + ", mfg=" + mfg + ", expiryDate=" + expiryDate + ", company=" + company + "]";
	}
	
	
}
