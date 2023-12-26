package com.fileread.empservice;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.fileread.entity.Employee;
import com.fileread.repository.EmpRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

public class EmpServiceImpl implements IEmpService {

	@Autowired
	private EmpRepository empRepo;
	@Override
	public void upload(MultipartFile file) throws IOException {
		//Read the Data from file and convert into Employee and insert into database
		processFile(file);
		
	}
	private List<Employee> processFile(MultipartFile file) throws IOException {
	    List<Employee> employees = new ArrayList<>();

	    try (Reader reader = new InputStreamReader(file.getInputStream());
	         CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build()) {

	        String[] nextRecord;
	        while ((nextRecord = csvReader.readNext()) != null) {
	            Employee employee = new Employee();
	            employee.setEmpId(Long.parseLong(nextRecord[0]));
	            employee.setEmpName(nextRecord[1]);
	            employee.setDesignation(nextRecord[2]);
	            employee.setMonthlySalary(Double.parseDouble(nextRecord[3]));
	            employee.setAnnualSalary(Double.parseDouble(nextRecord[4]));

	            employees.add(employee);
	        }
	    }catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}

	    return employees;
	}

}
