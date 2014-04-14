package com.spring;

import java.util.List;

public interface CustomerService {
	
	public void addCustomer(CustomerTo cto);
	public void updateCustomer(CustomerTo cto);
	public void deleteCustomer(int cid);
	public List<CustomerTo> getAllCustomers();
	
	public CustomerTo getCustomersByCid(int cid);
	public CustomerTo getCustomersByEmail(String email);
	public List<CustomerTo> getCustomerByCity(String city);
	public int getCustomerCount();
	public String getCustomerCityByEmail(String email);
	public Long getCustomerPhoneByEmail(String email);
	
	public List<CustomerTo> getAllCustomers1();
	public List<CustomerTo> getCustomerByCity1(String city);
	public CustomerTo getCustomersByEmail1(String email);

}
