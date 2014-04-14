package com.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDAO custdao=null;
	@Override
	public void addCustomer(CustomerTo cto) {
		custdao.addCustomer(cto);

	}

	@Override
	public void updateCustomer(CustomerTo cto) {
		custdao.updateCustomer(cto);

	}

	@Override
	public void deleteCustomer(int cid) {
		custdao.deleteCustomer(cid);

	}

	@Override
	public List<CustomerTo> getAllCustomers() {
		
		return custdao.getAllCustomers();
	}

	@Override
	public CustomerTo getCustomersByCid(int cid) {
		
		return custdao.getCustomersByCid(cid);
	}

	@Override
	public CustomerTo getCustomersByEmail(String email) {
		
		return custdao.getCustomersByEmail(email);
	}

	@Override
	public List<CustomerTo> getCustomerByCity(String city) {
		
		return custdao.getCustomerByCity(city);
	}

	@Override
	public int getCustomerCount() {
		
		return custdao.getCustomerCount();
	}

	@Override
	public String getCustomerCityByEmail(String email) {
		
		return custdao.getCustomerCityByEmail(email);
	}

	@Override
	public Long getCustomerPhoneByEmail(String email) {
		
		return custdao.getCustomerPhoneByEmail(email);
	}

	@Override
	public List<CustomerTo> getAllCustomers1() {
		
		return custdao.getAllCustomers1();
	}

	@Override
	public List<CustomerTo> getCustomerByCity1(String city) {
		
		return custdao.getCustomerByCity1(city);
	}

	@Override
	public CustomerTo getCustomersByEmail1(String email) {

		return custdao.getCustomersByEmail1(email);
	}

}
