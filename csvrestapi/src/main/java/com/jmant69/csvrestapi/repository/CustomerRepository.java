package com.jmant69.csvrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmant69.csvrestapi.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
