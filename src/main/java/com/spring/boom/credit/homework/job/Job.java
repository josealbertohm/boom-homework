package com.spring.boom.credit.homework.job;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Class representing a Job Title used by Employees in the application.")
public class Job {
	@Id
	@GeneratedValue
    @ApiModelProperty(notes = "Unique identifier of the job title.", example = "1", required = true, position = 0)	
	private Long id;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Job title.", example = "System Engineer", required = true, position = 1)	
	private String jobTitle;
	
	public Job() {
		super();
	}
	
	public Job(String jobTitle) {
		super();
		this.jobTitle = jobTitle;
	}
	
	public Job(int id, String jobTitle) {
		super();
		this.id = new Long(id);
		this.jobTitle = jobTitle;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
}
