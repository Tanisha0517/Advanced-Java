package com.rays.preparedstatement.scholarship;

import java.util.Date;

public class ScholarshipBean {

	private int scholarshiId;
	private String scholarshipName;
	private int amount;
	private String eligibility;
	private Date lastDate;

	public int getScholarshiId() {
		return scholarshiId;
	}

	public void setScholarshiId(int scholarshiId) {
		this.scholarshiId = scholarshiId;
	}

	public String getScholarshipName() {
		return scholarshipName;
	}

	public void setScholarshipName(String scholarshipName) {
		this.scholarshipName = scholarshipName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getEligibility() {
		return eligibility;
	}

	public void setEligibility(String eligibility) {
		this.eligibility = eligibility;
	}

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date date) {
		this.lastDate = date;
	}

	
}
