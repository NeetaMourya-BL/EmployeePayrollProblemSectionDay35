package com.bridgelabz.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeePayrollRepository {

	public Connection getConnection() {
		Connection connection = null;
		try {
			String JDBCURL = "jdbc:mysql://localhost:3306/employee_payroll_service";
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(JDBCURL, "root", "neeta");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Driver not loaded");
		}
		return connection;
	}

	public List<EmployeeInfo> retrieveData() {
		List<EmployeeInfo> employeeInfos = new ArrayList<>();

		try (Connection connection = getConnection()) {
			// step 3
			Statement statement = connection.createStatement();
			String sqlQuery = "select * from employees";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				EmployeeInfo employeeInfo = new EmployeeInfo();
				employeeInfo.setId(resultSet.getInt("id"));
				employeeInfo.setName(resultSet.getString("name"));
				employeeInfo.setGender(resultSet.getString("gender").charAt(0));
				employeeInfo.setPhone(resultSet.getString("phone"));
				employeeInfo.setAddress(resultSet.getString("address"));
				employeeInfo.setStartDate(Date.valueOf(resultSet.getDate("startDate").toLocalDate()));
				employeeInfo.setBasic_pay(resultSet.getDouble("basic_pay"));
				employeeInfos.add(employeeInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeInfos;

	}

//Update salary of employee
	public void updateSalary(String name, int basic_pay) {
		try (Connection connection = getConnection()) {
			Statement statement = connection.createStatement();
			String sqlQuery = String.format("update employees set basic_pay = %d where name = '%s'", basic_pay, name);
			int result = statement.executeUpdate(sqlQuery);
			if (result >= 1) {
				System.out.println("salary updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//update salary using prepared statement
	public void updateSalaryUsingPreparedStatement(String name, double d) {
		try (Connection connection = getConnection()) {
			String query = "update employees set basic_pay = ? where name = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setDouble(1, d);
			preparedStatement.setString(2, name);
			int result = preparedStatement.executeUpdate();
			if (result >= 1) {
				System.out.println("salary updated");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//retrieve data of employee of particular date range
	public List<EmployeeInfo> retrieveDataByDateRange() {
		List<EmployeeInfo> employeeInfo = new ArrayList<>();
		try (Connection connection = getConnection()) {
			// step 3
			Statement statement = connection.createStatement();
			String sqlQuery = "select * from employees \n" + "where startDate between '2021-01-11' and date(now());\n";
			ResultSet resultset = statement.executeQuery(sqlQuery);
			while (resultset.next()) {
				EmployeeInfo info = new EmployeeInfo();
				info.setId(resultset.getInt("id"));
				info.setName(resultset.getString("name"));
				info.setGender(resultset.getString("gender").charAt(0));
				info.setAddress(resultset.getString("address"));
				info.setPhone(resultset.getString("phone"));
				info.setStartDate(Date.valueOf(resultset.getDate("startDate").toLocalDate()));
				info.setBasic_pay(resultset.getDouble("basic_pay"));

				employeeInfo.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeeInfo;
	}
	public List<EmployeePayroll> retrieveDeparmentData() {
		List<EmployeePayroll> employeePayrollList = new ArrayList<>();

		try (Connection connection = getConnection()) {
			// step 3
			Statement statement = connection.createStatement();
			String sqlQuery = "select * from department";
			ResultSet resultSet = statement.executeQuery(sqlQuery);
			while (resultSet.next()) {
				EmployeePayroll employeePayroll = new EmployeePayroll();
				employeePayroll.setId(resultSet.getInt("id"));
				employeePayroll.setDepartmentName(resultSet.getString("dept_name"));
				employeePayrollList.add(employeePayroll);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employeePayrollList;

	}
}