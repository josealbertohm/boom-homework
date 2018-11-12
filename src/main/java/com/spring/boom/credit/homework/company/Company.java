package com.spring.boom.credit.homework.company;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@ApiModel(description = "Class representing a company used by the application.")
public class Company {
	@Id
	@GeneratedValue
    @ApiModelProperty(notes = "Unique identifier of the company.", example = "1", required = true, position = 0)	
	private Long id;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Company name's", example = "Example Inc.", required = true, position = 1)	
	private String name;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Company CNPJ's.", example = "CNPJ 1", required = true, position = 2)	
	private String CNPJ;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Company phone's.", example = "1111-1111", required = true, position = 3)	
	private String telephone;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Url for the company website.", example = "www.example.com", required = true, position = 4)	
	private String website;
	@Column(nullable=false)
    @ApiModelProperty(notes = "Market or industry of the company.", example = "Technology", required = true, position = 5)	
	private String industry;
	
	public Company() {
		super();
	}
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
	public String getCNPJ() {
		return CNPJ;
	}
	public void setCNPJ(String cNPJ) {
		CNPJ = cNPJ;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
}
