package com.ayurvedic.web.store.sprint1.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
	
	
	@ManyToOne
	@JoinColumn(name = "fk_medicine_cart_ID")
	private Cart medicineCart;
	
	@ManyToOne
	@JoinColumn(name = "fk_medicine_category_ID")
	private Category medicineCategory;
	
	/*
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_ayur_order_medicineID", referencedColumnName = "medicineId")
	@JsonIgnoreProperties
	private List<AyurOrder> ayurOrder;
	*/
	

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
