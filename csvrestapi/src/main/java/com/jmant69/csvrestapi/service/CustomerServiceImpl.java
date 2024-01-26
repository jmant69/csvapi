package com.jmant69.csvrestapi.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jmant69.csvrestapi.entity.Customer;
import com.jmant69.csvrestapi.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository repository;

	@Override
	public void processCSVFile(MultipartFile file) {
		try {
			List<Customer> customers = csvToCustomers(file.getInputStream());
			repository.saveAll(customers);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private List<Customer> csvToCustomers(InputStream inputStream) {
		try (
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
			CSVParser csvParser = new CSVParser(fileReader,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim()); ) {
			List<Customer> customers = new ArrayList<Customer>();
			List<CSVRecord> records = csvParser.getRecords();
			for (CSVRecord csvRecord : records) {
				Customer customer = new Customer(Long.parseLong(csvRecord.get("CustomerRef")),
						csvRecord.get("CustomerName"), csvRecord.get("AddressLine1"), csvRecord.get("AddressLine2"),
						csvRecord.get("Town"), csvRecord.get("County"), csvRecord.get("Country"),
						csvRecord.get("PostCode"));
				customers.add(customer);
			}
			return customers;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> customer = repository.findById(id);
		if (customer.isPresent()) {
			return customer.get();
		}
		throw new RuntimeException("Customer is not found for the customer ref "+id);
		
	}

}
