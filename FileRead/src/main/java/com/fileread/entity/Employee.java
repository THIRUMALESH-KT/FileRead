package com.fileread.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

	@Id
	private Long empId;
	private String empName;
	private String designation;
	private Double monthlySalary;
	private Double AnnualSalary;
	 
}
