package com.jmant69.csvrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jmant69.csvrestapi.entity.Customer;
import com.jmant69.csvrestapi.response.UploadResponse;
import com.jmant69.csvrestapi.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/upload")
	public ResponseEntity<UploadResponse> uploadFile(@RequestParam("file") MultipartFile file) {
		customerService.processCSVFile(file);
		return ResponseEntity.status(HttpStatus.OK).body(new UploadResponse("Upload successful"));
		
	}
	
	@GetMapping("/get/{id}")
	public Customer getCustomer(@PathVariable Long id) {
		return customerService.getCustomer(id);
		
	}


}
	