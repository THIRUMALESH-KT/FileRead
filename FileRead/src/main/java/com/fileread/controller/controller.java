package com.fileread.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fileread.empservice.IEmpService;

@RestController
@RequestMapping("/employee")
public class controller {
	@Autowired
	private IEmpService service;
	@GetMapping("/upload")
	public  ResponseEntity<String> uploadFile(MultipartFile file) throws IOException{
		service.upload(file);
		
		return ResponseEntity.ok("ok");
				
			
	}

}
