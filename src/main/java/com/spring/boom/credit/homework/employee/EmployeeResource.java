package com.spring.boom.credit.homework.employee;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.boom.credit.homework.SearchCriteria;
import com.spring.boom.credit.homework.job.Job;
import com.spring.boom.credit.homework.job.JobRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Employees.")
public class EmployeeResource {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JobRepository jobRepository;
	
	@ApiOperation("Retrieves a list with all Employees")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/employees")
	public List<Employee> retrieveAllemployees() {
		return employeeRepository.findAll();
	}
	
	@ApiOperation("Retrieve a Employee based in the Id passed as path variable")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/employees/{id}")
	public Employee retrieveEmployee(@PathVariable long id) throws EmployeeNotFoundException {
		Optional<Employee> Employee = employeeRepository.findById(id);

		if (!Employee.isPresent())
			throw new EmployeeNotFoundException("id-" + id);

		return Employee.get();
	}
	
	@ApiOperation("Delete a Employee based in the Id passed as path variable")
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json", path = "/employees/{id}")
	public void deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteById(id);
	}
	
	@ApiOperation("Create a Employee using all the data passed as json in the request body")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/employees")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee Employee) {
		Employee savedEmployee = employeeRepository.save(Employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedEmployee.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation("Update a Employee using all the data passed as json in the request body with the Id passed as path variable")
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json", path = "/employees/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Employee Employee, @PathVariable long id) {
		Optional<Employee> EmployeeOptional = employeeRepository.findById(id);

		if (!EmployeeOptional.isPresent())
			return ResponseEntity.notFound().build();

		Employee.setId(id);
		
		employeeRepository.save(Employee);

		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Search Employees whose Job Title has specific word passes as request parameter")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "employees/search")
	public List<Employee> searchemployees(@RequestParam(value = "title") String jobTitle) {
		EmployeeSpecification EmployeeSpecification = new EmployeeSpecification(
				new SearchCriteria("jobTitle",":",jobTitle));
		
		return employeeRepository.findAll(EmployeeSpecification);
	} 
	
	@ApiOperation("Retrieves a list with all the Job Titles availables")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/employees/jobs")
	public List<Job> retrieveAllJobs() {
		return jobRepository.findAll();
	}
}
