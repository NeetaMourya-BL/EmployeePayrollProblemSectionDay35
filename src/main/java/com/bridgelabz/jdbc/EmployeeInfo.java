package com.bridgelabz.jdbc;

import java.sql.Date;

public class EmployeeInfo {
	private int id;
	private String name;
	private char gender;
	private Date startDate;
	private String phone;
	private String address;
    private double basic_pay;
    private String[]departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	public double getBasic_pay() {
		return basic_pay;
	}

	public void setBasic_pay(double string) {
		this.basic_pay = string;
	}

	@Override
	public String toString() {
		return "EmployeeInfo [id=" + id + ", name=" + name + ", gender=" + gender + ", startDate=" + startDate
				+ ", phone=" + phone + ", address=" + address + ", basic_pay=" + basic_pay + "]";
	}
}
