package com.fileread.empservice;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface IEmpService {

	void upload(MultipartFile file) throws IOException;

}
