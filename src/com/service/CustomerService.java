package com.service;

import java.util.List;

import com.domain.Customer;


public interface CustomerService {
	//保存客户
	void save(Customer c);

	List<Customer> getListCustomer();

	Customer getById(Long id);

}
