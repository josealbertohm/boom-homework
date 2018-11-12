package com.spring.boom.credit.homework.company;

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
import com.spring.boom.credit.homework.employee.Employee;
import com.spring.boom.credit.homework.employee.EmployeeRepository;
import com.spring.boom.credit.homework.employee.EmployeeSpecification;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(description = "Endpoints for Creating, Retrieving, Updating and Deleting of Companies.")
public class CompanyResource {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@ApiOperation("Retrieves a list with all Companies")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/companies")
	public List<Company> retrieveAllCompanies() {
		return companyRepository.findAll();
	}
	
	@ApiOperation("Retrieve a Company based in the Id passed as path variable")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/companies/{id}")
	public Company retrieveCompany(@PathVariable long id) throws CompanyNotFoundException {
		Optional<Company> company = companyRepository.findById(id);

		if (!company.isPresent())
			throw new CompanyNotFoundException("id-" + id);

		return company.get();
	}
	
	@ApiOperation("Delete a Company based in the Id passed as path variable")
	@RequestMapping(method = RequestMethod.DELETE, produces = "application/json", path = "/companies/{id}")
	public void deleteCompany(@PathVariable long id) {
		companyRepository.deleteById(id);
	}
	
	@ApiOperation("Create a Company using all the data passed as json in the request body")
	@RequestMapping(method = RequestMethod.POST, produces = "application/json", path = "/companies")
	public ResponseEntity<Object> createCompany(@RequestBody Company company) {
		Company savedCompany = companyRepository.save(company);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedCompany.getId()).toUri();

		return ResponseEntity.created(location).build();
	}
	
	@ApiOperation("Update a Company using all the data passed as json in the request body")
	@RequestMapping(method = RequestMethod.PUT, produces = "application/json", path = "/companies/{id}")
	public ResponseEntity<Object> updateStudent(@RequestBody Company company, @PathVariable long id) {

		Optional<Company> companyOptional = companyRepository.findById(id);

		if (!companyOptional.isPresent())
			return ResponseEntity.notFound().build();

		company.setId(id);
		
		companyRepository.save(company);

		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation("Retrieves a list with all Companies searched with the name or industry passed as path variable")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "companies/search")
	public List<Company> searchCompanies(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "industry", required = false) String industry) {
		CompanySpecification companySpecification = null;
		if (name != null) {
			companySpecification = new CompanySpecification(new SearchCriteria("name",":",name));
		} else if (industry != null) {
			companySpecification = new CompanySpecification(new SearchCriteria("industry",":",industry));
		}
		
		return companyRepository.findAll(companySpecification);
	} 
	
	@ApiOperation("Retrieves a list with all Employees that work in the Company based in the Company Id passed as path variable")
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "companies/{id}/employees")
	public List<Employee> searchEmployees(@PathVariable long id) {
		EmployeeSpecification EmployeeSpecification = new EmployeeSpecification(
				new SearchCriteria("employeer",":",id));
		
		return employeeRepository.findAll(EmployeeSpecification);
	} 

}
