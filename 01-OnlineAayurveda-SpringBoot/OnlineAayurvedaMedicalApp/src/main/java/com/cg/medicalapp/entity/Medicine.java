package com.cg.medicalapp.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Medicines")

public class Medicine {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	@Column(name = "medicineId")
	private int medicineId;
	
	@NotNull
	@Column(name = "medicineName")
	private String medicineName;
	
	@NotNull
	@Column(name = "medicineCost")
	private float medicineCost;
	
	@NotNull
	@Column(name = "mfd")
	private LocalDate mfd;
	
	@NotNull
	@Column(name = "expiryDate")
	private LocalDate expiryDate;
	
	@Enumerated(EnumType.STRING)
	@NotNull
	@Column(name = "company")
	private Company company;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name="category_id")
	private Category category;
	
	
	public Medicine(@NotNull int medicineId, @NotNull String medicineName, @NotNull float medicineCost,
			@NotNull LocalDate mfd, @NotNull LocalDate expiryDate, @NotNull Company company, @NotNull Category category) {
		super();
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.medicineCost = medicineCost;
		this.mfd = mfd;
		this.expiryDate = expiryDate;
		this.company = company;
		this.category = category;
	}

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

	public LocalDate getMfd() {
		return mfd;
	}

	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "MedicineEntity [medicineId=" + medicineId + ", medicineName=" + medicineName + ", medicineCost="
				+ medicineCost + ", mfd=" + mfd + ", expiryDate=" + expiryDate + ", company=" + company + ", category="
				+ category + "]";
	}

	public Medicine() {
		super();
		
	}
	

}
