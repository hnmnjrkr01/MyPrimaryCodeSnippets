package com.cg.medicalapp.entity;

public enum Company {
	Divis("Divis Laboratories Ltd.	"), sun("Sun Pharmaceutical Industries Ltd."), Reddy(
			"Dr. Reddys Laboratories Ltd."), Cipla("Cipla Ltd."), Balcon("Biocon Ltd.");
	String name;

	Company(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

