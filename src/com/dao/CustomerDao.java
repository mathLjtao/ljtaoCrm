package com.dao;

import java.util.List;

import com.domain.Customer;


public interface CustomerDao {
	//保存客户
	void save(Customer c);

	List<Customer> getListCustomer();

	Customer getById(Long id);

}
