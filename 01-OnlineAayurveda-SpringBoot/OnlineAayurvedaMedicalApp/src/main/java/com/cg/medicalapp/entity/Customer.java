package com.cg.medicalapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	@Table(name = "Customers")
	public class Customer{
		
		@Id
		@Column(name="customer_id")
		@NotNull
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Integer customerId;

		@NotNull(message = "Name cannot be empty.")
		@Column(name="customer_Name")
		private String customerName;
		
		@NotNull
		@Size(min = 10, message = "Mobile number cannot be less than 10 digits.")
		@Column(name="mobile_number")
		private String mobileNumber;
		
		@NotNull
		@Email(regexp = "^[a-zA-Z_].*(@[a-zA-Z]+)(\\.[a-zA-Z]+)$", message = "Please enter a valid email id.")
		@Column(name="email_id", unique=true)
		private String emailId;
		
		@NotBlank
		@Size(min=8,max=14,message="Password should be between 8-14 characters")
		@Column(name="password")
		private String password;
		
		public Customer(Integer customerId, String customerName, String mobileNumber, String emailId, String password) {
			super();
			this.customerId = customerId;
			this.customerName = customerName;
			this.mobileNumber = mobileNumber;
			this.emailId = emailId;
			this.password = password;
		}

		public Customer() {
			super();
		}

		public int getCustomerId() {
			return customerId;
		}

		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String cutomerName) {
			this.customerName = cutomerName;
		}

		public String getMobileNumber() {
			return mobileNumber;
		}

		public void setMobileNumber(String mobileNumber) {
			this.mobileNumber = mobileNumber;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

	}
