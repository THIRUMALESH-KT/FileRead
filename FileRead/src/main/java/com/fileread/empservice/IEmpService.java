package com.fileread.empservice;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileread.entity.Employee;

@Service
public interface IEmpService {

	List<Employee> upload(String file) throws IOException;

	List<Employee> readData();

}
