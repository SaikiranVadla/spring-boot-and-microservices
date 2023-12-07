package com.example.excel.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.entity.ClassExcel;

@Service
public class FileImpl{
//
//	@Value("${app.upload.dir:${user.home}}")
//	private String uploadDir;
//	
//	private String FileSeparator;
//
//	@Override
//	public void uploadFile(MultipartFile file) {
//		// TODO Auto-generated method stub
//		
//		try {
//			
//			Path copylocation = Paths.get(uploadDir + FileSeparator + StringUtils.cleanPath(file.getOriginalFilename()));
//			Files.copy(file.getInputStream(),copylocation, StandardCopyOption.REPLACE_EXISTING);
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		// throw new RuntimeException("Could not Store the file" + file.getOriginalFilename()+". Please try again.");
//		
//	}
//	
   
	
	public static boolean isValidExcelFile(MultipartFile file) {
		String  contentType=file.getContentType();
		System.out.println(contentType);
		if(contentType.equals("application/vnd.ms-excel"))return true; 
		else return false;
	}
	
	public static List<ClassExcel> getDataFromExcel(InputStream inputStream) throws IOException{
		List<ClassExcel> customer=new ArrayList<>();
		HSSFWorkbook workbook=new HSSFWorkbook(inputStream);
		HSSFSheet sheet=workbook.getSheetAt(0);
		int rowIndex=0;
		for(Row row:sheet) {
			if((rowIndex==0)) {
				rowIndex++;
				continue;
			}
			java.util.Iterator<Cell>cellIterator=row.iterator();
			int cellIndex=0;
			ClassExcel excel=new ClassExcel();
			while(cellIterator.hasNext()) {
				Cell cell=cellIterator.next();
				switch(cellIndex) {
				case 0 ->excel.setId((long) cell.getNumericCellValue());
				case 1 ->excel.setName(cell.getStringCellValue());
				case 2 ->excel.setSalary((long) cell.getNumericCellValue());
				case 3->excel.setCity(cell.getStringCellValue());
				default ->{
					
				}
				}
				cellIndex++;
			}
			customer.add(excel);
		}
		return customer;
	}
	
	

}
