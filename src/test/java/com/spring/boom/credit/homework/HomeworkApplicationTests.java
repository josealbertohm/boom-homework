package com.spring.boom.credit.homework;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.boom.credit.homework.company.Company;
import com.spring.boom.credit.homework.company.CompanyRepository;
import com.spring.boom.credit.homework.employee.Employee;
import com.spring.boom.credit.homework.employee.EmployeeRepository;
import com.spring.boom.credit.homework.job.Job;
import com.spring.boom.credit.homework.job.JobRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
    @Autowired
	private CompanyRepository companyRepository;
    @Autowired
	private JobRepository jobRepository;
    @Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void whenFindByName_thenReturnEmployee() {
		Job jobTitle = jobRepository.save(new Job("Musician"));
	    Employee employee1 = new Employee();
	    employee1.setDumyData();
	    employee1.setCPF("CPF 1");
	    Optional<Company> employeer = companyRepository.findById(new Long(1));
	    employee1.setEmployeer(employeer.get());
	    employee1.setJobTitle(jobTitle);
	    employeeRepository.save(employee1);
	 
	    Employee found = employeeRepository.findByName(employee1.getName());
	 
	    assertEquals(found.getName(), employee1.getName());
	}
    
	@Test
	public void countCompanies() {
		// Evaluate the 4 (four) companies added in the data.sql file
	    assertEquals(companyRepository.count(), (new Long(4)).longValue());
	}	
}
