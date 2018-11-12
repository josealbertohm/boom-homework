package com.spring.boom.credit.homework.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.boom.credit.homework.company.Company;
import com.spring.boom.credit.homework.company.CompanyRepository;
import com.spring.boom.credit.homework.employee.Employee;
import com.spring.boom.credit.homework.employee.EmployeeRepository;
import com.spring.boom.credit.homework.job.Job;
import com.spring.boom.credit.homework.job.JobRepository;

@Component
public class TableBean {
    
    @Autowired
	private CompanyRepository companyRepository;    
    @Autowired
	private EmployeeRepository employeeRepository;    
    @Autowired
	private JobRepository jobRepository;
    
    private List<Job> jobTitles;
    private List<Company> companies;
    
    public void setupDummyData() {
    	this.setRelativeData();
    	this.createEmployeeData();
    }
    
	private void createEmployeeData() {
		for (int i=0; i<50; i++) {
		    Employee employee1 = new Employee();
		    employee1.setDumyData();
		    employee1.setCPF("CPF " + i);
		    employee1.setEmployeer(this.getCompany());
		    employee1.setJobTitle(this.getJobTitle());
		    employeeRepository.save(employee1);		
		}
	}
	
	private int getRandomId(int min, int max) {
		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	private Company getCompany() {
		int companyId = this.getRandomId(0, (companies.size()-1));
		return companies.get(companyId);
	}
	
	private Job getJobTitle() {
		int jobTitleId = this.getRandomId(0, (jobTitles.size()-1));
		return jobTitles.get(jobTitleId);
	}
	
	private void setRelativeData() {
		System.out.println("Adding Job Titles");
		ArrayList<String> jobs = new ArrayList<String>();
		jobs.add("Medical Doctor");
		jobs.add("Health coach");
		jobs.add("Influencer");
		jobs.add("Web Developer");
		jobs.add("System Architect");
		jobs.add("Taxi Driver");
		jobs.add("Senior Financial");
		jobs.add("Bartender");
		jobs.add("Business Analist");
		jobs.add("President");
		jobs.add("Advisor");
		jobs.add("Network Infrastructure Lead");
		jobs.add("Chief Accounting");
		jobs.add("Project Manager");
		jobs.add("Marketing Lead");
		
		int i = 1;
		for (String jobTitle: jobs)
			jobRepository.save(new Job(i++, jobTitle));	
	
		this.jobTitles = jobRepository.findAll();
		
		// Read the Companies added in the data.sql file
		System.out.println("Reading the Companies added in the data.sql file");
		this.companies = companyRepository.findAll();
		System.out.println(this.companies.size() + " companies were found!");
	}
}
