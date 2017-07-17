package com.pcms.model;

import java.io.Serializable;

public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 467925414222557520L;
	
	private Long id;

	private String companyName;
	
	private String companyCode;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
	
}
