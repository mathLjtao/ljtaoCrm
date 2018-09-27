package com.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.Customer;


public interface CustomerService {
	//保存客户
	void save(Customer c);

	List<Customer> getListCustomer();

	Customer getById(Long id);

	List<Customer> getAll(DetachedCriteria dc);


	void deleteById(Long cust_id);

	void update(Customer c);

	Customer getByIdNoTransaction(Long id);

}
