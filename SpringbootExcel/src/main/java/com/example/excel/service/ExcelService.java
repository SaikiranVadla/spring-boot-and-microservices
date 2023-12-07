package com.example.excel.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.excel.entity.ClassExcel;

public interface ExcelService {
	
//	List<ClassExcel> getExcelDataAsList();
//	
//	List<ClassExcel> saveExcelData(MultipartFile file);
	ClassExcel saveExcelToDatabase(MultipartFile file) throws IOException;
	
	 List<ClassExcel> getData();
}
