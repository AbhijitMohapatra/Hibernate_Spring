package com.spring;

public class Customer {
	private int cid;
	private String cname;
	private String email;
	private long phone;
	private long phone1;
	private long phone3;

	private String city;
	
	public Customer(){}

	public Customer(String cname, String email, long phone1, long phone, String city) {
		super();
		this.cname = cname;
		this.email = email;
		this.phone = phone;
		this.phone1 = phone1;
		this.city = city;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getPhone1() {
		return phone1;
	}

	public void setPhone1(long phone1) {
		this.phone1 = phone1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	

}
