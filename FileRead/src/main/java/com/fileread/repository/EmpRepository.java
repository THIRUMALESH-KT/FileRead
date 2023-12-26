package com.fileread.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fileread.entity.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long> {

}
