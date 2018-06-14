package com.test.mysql.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "employees")
@ToString
public class Employee {
	@Id
	@Getter
	@Setter
	private int emp_no;

	@Column
	private Date birth_date;

	@Column
	@Getter
	@Setter
	private String first_name;

	@Column
	@Getter
	@Setter
	private String last_name;

	@Column
	@Enumerated(EnumType.STRING)
	private EmployeeStatus gender;

	public enum EmployeeStatus {
		M, F
	}

	@Column
	private Date hire_date;

}
