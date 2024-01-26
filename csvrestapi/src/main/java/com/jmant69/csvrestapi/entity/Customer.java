package com.jmant69.csvrestapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	public Customer() {
		super();
	}
	
	public Customer(Long customerRef, String customerName, String addressLine1, String addressLine2, String town,
			String county, String country, String postCode) {
		super();
		this.customerRef = customerRef;
		this.customerName = customerName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.town = town;
		this.county = county;
		this.country = country;
		this.postCode = postCode;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long customerRef;
	private String customerName;
	private String addressLine1;
	private String addressLine2;
	private String town;
	private String county;
	private String country;
	private String postCode;
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Long getCustomerRef() {
		return customerRef;
	}
	public void setCustomerRef(Long customerRef) {
		this.customerRef = customerRef;
	}
	@Override
	public String toString() {
		return "Customer [customerRef=" + customerRef + ", customerName=" + customerName + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", town=" + town + ", county=" + county
				+ ", country=" + country + ", postCode=" + postCode + "]";
	}

}
