package com.spring.client;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.CustomerService;
import com.spring.CustomerTo;

public class Lab27 {

	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		CustomerService cs=ctx.getBean("cs", CustomerService.class);
		
		//Add Customer
		CustomerTo cto=new CustomerTo(119,"Abhijit","situn130@gmail.com",4418732,"Bangalore");
		cs.addCustomer(cto);
		
		//update Customer
		CustomerTo cto1=new CustomerTo(103,"situn","situn07@Gmail.com",4416273,"Bangalore");
        cs.updateCustomer(cto1);
        
        //delete customer
        //cs.deleteCustomer(102);
        
        //getCustomerByCid
        System.out.println("getCustomerByCid");
        cto=cs.getCustomersByCid(103);
        System.out.println(cto);
        
        //getAllCustomers
        System.out.println("getAllCustomers");
        List<CustomerTo> list=cs.getAllCustomers();
        for(CustomerTo ct:list){
        	System.out.println(ct);
        }
        
        //getCustomersByEmail
        System.out.println("getCustomerByEmail");
        cto=cs.getCustomersByEmail("situn130@gmail.com");
        System.out.println(cto);
        
        //getCustomersByCity
        System.out.println("getCustomersByCity");
        list=cs.getCustomerByCity("Bangalore");
        for(CustomerTo ct:list){
        	System.out.println(ct);
        }
        
        //getCustomerCount
        System.out.println("getCustomerCount");
        int count=cs.getCustomerCount();
        System.out.println("No. of Customer:"+count);
        
        //getCustomerCityByEmail
        System.out.println("getCustomerCityByEmail");
        String ci=cs.getCustomerCityByEmail("situn130@gmail.com");
        System.out.println(ci);
        
        //getCustomerPhoneByEmail
        System.out.println("getCustomerPhoneByEmail");
        long ph=cs.getCustomerPhoneByEmail("situn130@gmail.com");
        System.out.println(ph);
        
        //getAllCustomers1
        System.out.println("getAllCustomers1");
        list=cs.getAllCustomers1();
        for(CustomerTo ct:list){
        	System.out.println(ct);
        }
        
        //getCustomerByEmail1
        System.out.println("getCustomerByEmail1");
        cto=cs.getCustomersByEmail1("situn130@gmail.com");
        System.out.println(cto);
        
        //getCustomerByCity1
        System.out.println("getCustomerByCity1");
        list=cs.getCustomerByCity1("Bangalore");
        for(CustomerTo ct:list){
        	System.out.println(ct);
        }
        
	}

}
