package com.fileread.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@Column(name = "empId")
	private Long empId;
	@Column(name = "empName")
	private String empName;	
	@Column(name = "monthlySalary")
	private Double monthlySalary;
	@Column(name = "Address")
	private String Address;
}
