package com.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.domain.Customer;


public interface CustomerDao {
	//保存客户
	void save(Customer c);

	List<Customer> getListCustomer();

	Customer getById(Long id);

	List<Customer> getAll(DetachedCriteria dc);

	void deleteById(Long id);

	void update(Customer c);

}
