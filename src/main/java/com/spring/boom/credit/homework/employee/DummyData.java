package com.spring.boom.credit.homework.employee;

public class DummyData {
	private String name;
	private String gender;
	private String email;
	private String seed;
	
	public DummyData(String name, String gender, String email, String seed) {
		super();
		this.name = name;
		this.gender = gender;
		this.email = email;
		this.seed = seed;
	}
	public void debugData() {
		System.out.println("Name   : " + this.name);
		System.out.println("Gender : " + this.gender);
		System.out.println("Email  : " + this.email);
		System.out.println("Seed   : " + this.seed);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
}
