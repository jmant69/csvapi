package com.jmant69.csvrestapi.service;

import org.springframework.web.multipart.MultipartFile;

import com.jmant69.csvrestapi.entity.Customer;

public interface CustomerService {

	public void processCSVFile(MultipartFile file);

	public Customer getCustomer(Long id);

}
