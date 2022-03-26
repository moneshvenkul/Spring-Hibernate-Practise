package com.example.webcustomertracker.dao;

import com.example.webcustomertracker.entity.Customer;

import java.util.List;


public interface CustomerDAO {

	public List<Customer> getCustomers();

    public void saveCustomer(Customer customer);

    Customer getCustomer(int id);

    void deleteCustomer(int id);
}
