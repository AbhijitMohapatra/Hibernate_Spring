package com.spring;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class HibernateCustomerDAO implements CustomerDAO {
    
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Override
	public void addCustomer(CustomerTo cto) {
	 Customer cust=new Customer(cto.getCname(),cto.getEmail(),cto.getPhone(),cto.getCity());
	 hibernateTemplate.save(cust);
	}	

	@Override
	public void updateCustomer(CustomerTo cto) {
	Customer c=(Customer)hibernateTemplate.load(Customer.class, cto.getCid());
	c.setCid(cto.getCid());
	c.setCname(cto.getCname());
	c.setEmail(cto.getEmail());
	c.setPhone(cto.getPhone());
	c.setCity(cto.getCity());
	hibernateTemplate.update(c, LockMode.NONE);

	}

	@Override
	public void deleteCustomer(int cid) {
		Customer c=(Customer)hibernateTemplate.load(Customer.class, cid);
		hibernateTemplate.delete(c, LockMode.NONE);

	}

	@Override
	public List<CustomerTo> getAllCustomers() {
		List<CustomerTo> ctoList=new ArrayList<CustomerTo>();
		String hql="from Customer c";
		List<Customer> list=hibernateTemplate.find(hql);
		for(Customer c:list){
			CustomerTo cto=new CustomerTo(c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
			ctoList.add(cto);
		}
		return ctoList;
	}

	@Override
	public CustomerTo getCustomersByCid(int cid) {
		Customer c=(Customer)hibernateTemplate.load(Customer.class, cid);
		CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
		return cto;
	}

	@Override
	public CustomerTo getCustomersByEmail(String email) {
		String hql="from Customer c where c.email=?";
		List<Customer> list=hibernateTemplate.find(hql,email);
		Customer c=(Customer)list.get(0);
		CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
		return cto;
	}

	@Override
	public List<CustomerTo> getCustomerByCity(String city) {
		List<CustomerTo> ctoList=new ArrayList<CustomerTo>();
		String hql="from Customer c where c.city=?";
		List<Customer> list=hibernateTemplate.find(hql,city);
		for(Customer c:list){
			CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
		ctoList.add(cto);
		}
		return ctoList;
	}

	@Override
	public int getCustomerCount() {
		String hql="from Customer c";
		List<Customer> list=hibernateTemplate.find(hql);
		return list.size();
	}

	@Override
	public String getCustomerCityByEmail(String email) {
		String hql="from Customer c where c.email=?";
		List<Customer> list=hibernateTemplate.find(hql,email);
		Customer c=(Customer)list.get(0);		
		return c.getCity();
	}

	@Override
	public Long getCustomerPhoneByEmail(String email) {
		String hql="from Customer c where c.email=?";
		List<Customer> list=hibernateTemplate.find(hql,email);
		Customer c=(Customer)list.get(0);
		return c.getPhone();
	}

	@Override
	public List<CustomerTo> getAllCustomers1() {
		List<CustomerTo> ctoList=new ArrayList<CustomerTo>();
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		List<Customer> list=hibernateTemplate.findByCriteria(dc, 0, 5);
		for(Customer c:list){
			CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
			ctoList.add(cto);		}
		return ctoList;
	}

	@Override
	public List<CustomerTo> getCustomerByCity1(String city) {
		List<CustomerTo> ctoList=new ArrayList<CustomerTo>();
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("city", city));
		hibernateTemplate.setCacheQueries(true);
		List<Customer> list=hibernateTemplate.findByCriteria(dc);
		for(Customer c:list){
			CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
			ctoList.add(cto);}
		return ctoList ;
	}

	@Override
	public CustomerTo getCustomersByEmail1(String email) {
		
		
		DetachedCriteria dc=DetachedCriteria.forClass(Customer.class);
		dc.add(Expression.eq("email", email));
		hibernateTemplate.setCacheQueries(true);
		List<Customer> list=hibernateTemplate.findByCriteria(dc);
		Customer c=list.get(0);
			CustomerTo cto=new CustomerTo(c.getCid(),c.getCname(),c.getEmail(),c.getPhone(),c.getCity());
			
		return cto ;
	}

}
