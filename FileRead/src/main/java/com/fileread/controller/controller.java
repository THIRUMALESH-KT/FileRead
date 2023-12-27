package com.fileread.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileread.empservice.IEmpService;
import com.fileread.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee")
@Slf4j
public class controller {
	@Autowired
	private IEmpService service;
	@PostMapping("/upload")
	public  ResponseEntity<List<Employee>> uploadFile(@RequestParam("file") String file) throws IOException {
			log.info("inside uploadFile Employee Controller");
			return ResponseEntity.ok(service.upload(file));
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Employee>> readData(){
		log.info("inside readData Employee Controller");
		return ResponseEntity.ok(service.readData());
		
	}
}
