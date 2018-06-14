package com.test.mysql.demo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * EmployeeDto
 */
@Getter
@Setter
public class EmployeeDto {

	private String first_name;
	private String last_name;
	private int emp_no;

	public String getFirstName() {
		return first_name;
	}

	public void setFirstName(String firstName) {
		this.first_name = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return last_name;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.last_name = lastName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return emp_no;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		emp_no = id;
	}
}