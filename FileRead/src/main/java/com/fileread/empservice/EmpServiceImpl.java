package com.fileread.empservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fileread.entity.Employee;
import com.fileread.repository.EmpRepository;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class EmpServiceImpl implements IEmpService {

	@Autowired
	private EmpRepository empRepo;
	@Override
	public List<Employee> upload(String file) {
		//Read the Data from file and convert into Employee and insert into database
		log.info("inside upload service");
		return processFile(file);
		
	}
private List<Employee> processFile(String file) {
String line="";
	try {
		BufferedReader br=new BufferedReader(new FileReader(file));
		while((line=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(line, ("[, \\|]"));
			while(st.hasMoreTokens()) {
				Employee emp=new Employee(Long.valueOf(st.nextToken()),st.nextToken(),Double.valueOf(st.nextToken()),st.nextToken());
				empRepo.save(emp);
			}
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return empRepo.findAll();
	}
//	private List<Employee> processFile(String file) {
//		log.info("inside processFile service");
//		String line="";
//		try {
//			BufferedReader br=new BufferedReader(new FileReader(file));
//			
//			while((line=br.readLine())!=null) {
//				String[] data=line.split("[, \\|]");
//				
//				Employee emp=new Employee(Long.valueOf(data[0]), data[1],Double.valueOf(data[2]), data[3]);
//				empRepo.save(emp);
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return empRepo.findAll();
//		
//	}
	@Override
	public List<Employee> readData() {
		log.info("inside readData servcie");
		return empRepo.findAll();
	}

}
