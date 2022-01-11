package com.bridgelabz.jdbc;

import java.util.Arrays;

public class EmployeePayroll {
	private int id;
	private String departmentName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String string) {
		this.departmentName = string;
	}

	@Override
	public String toString() {
		return "EmployeePayroll [id=" + id + ", departmentName=" + departmentName + "]";
	}

}
