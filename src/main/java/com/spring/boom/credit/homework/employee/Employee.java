package com.spring.boom.credit.homework.employee;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.spring.boom.credit.homework.company.Company;
import com.spring.boom.credit.homework.job.Job;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Class representing a employee used by the application.")
public class Employee {
	@Id
	@GeneratedValue
    @ApiModelProperty(notes = "Unique identifier of the employee.", example = "1", required = true, position = 0)	
	private Long id;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Full name of the employee.", example = "Mr Michael Smith", required = true, position = 1)		
	String name;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Gender, Male or Female, of the employee", example = "Male", required = true, position = 2)		
	private String gender;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Email of the employee.", example = "mike@example.com", required = true, position = 3)		
	private String email;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Employee CPF's.", example = "CPF 1", required = true, position = 4)	
	private String CPF;
    @ManyToOne
    @JoinColumn(name="company_id")
    @ApiModelProperty(notes = "Company Id of the Employeer", example = "1", required = true, position = 5)	
	private Company employeer;
    @ManyToOne
    @JoinColumn(name="jobtitle_id")
    @ApiModelProperty(notes = "Job Id of the employee", example = "3", required = true, position = 6)	    
	private Job jobTitle;
    @Column(nullable=false)
    @ApiModelProperty(notes = "Seed used in the Random User API call", example = "c2b7c2eae250", required = true, position = 7)	
	private String seed;
	
	public Employee() {
		super();
		this.seed = UUID.randomUUID().toString();
	}
	public Employee(String seed) {
		super();
		this.seed = seed;
	}
	
	public void setDumyData() {
		DummyData dummyData = RandomData.getRandomData(this.seed);
		this.name = dummyData.getName();
		this.gender = dummyData.getGender();
		this.email = dummyData.getEmail();		
	}
	@Column(nullable=false)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Company getEmployeer() {
		return employeer;
	}
	public void setEmployeer(Company employeer) {
		this.employeer = employeer;
	}
	public Job getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(Job jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}	
}
