package com.bridgelabz.jdbc;

import java.util.Locale;

public class EmployeePayrollService {
	EmployeePayrollRepository employeePayrollRepository = new EmployeePayrollRepository();

	public static void main(String[] args) {
		EmployeePayrollService employeePayrollService = new EmployeePayrollService();
		employeePayrollService.retrieveData();
		employeePayrollService.updateSalary("Terrisa", 3000000.00);
		employeePayrollService.retrieveDataByDate();
	}

	public void retrieveData() {
		System.out.println(employeePayrollRepository.retrieveData());
	}

	private void updateSalary(String name, double d) {
		employeePayrollRepository.updateSalaryUsingPreparedStatement(name.toLowerCase(Locale.ROOT), d);

	}

	private void retrieveDataByDate() {
		System.out.println(employeePayrollRepository.retrieveDataByDateRange());
	}
}