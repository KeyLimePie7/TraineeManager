package com.bean;

public class Trainee {
	int empId;
	String name;
	String lgName;
	int rating;
	String feedback;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLgName() {
		return lgName;
	}
	public void setLgName(String lgName) {
		this.lgName = lgName;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Trainee(int empId, String name, String lgName, int rating, String feedback) {
		super();
		this.empId = empId;
		this.name = name;
		this.lgName = lgName;
		this.rating = rating;
		this.feedback = feedback;
	}
	public Trainee() {
		super();
	}
	
}
