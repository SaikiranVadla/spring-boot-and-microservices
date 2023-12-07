package com.example.excel.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.entity.ClassExcel;
import com.example.excel.helper.ExcelHelper;
import com.example.excel.repository.ExcelRepo;

@Service
public class ExcelImpl implements ExcelService{
	
	@Autowired
	private ExcelRepo excelrepo;

	@Override
	public ClassExcel saveExcelToDatabase(MultipartFile file) throws IOException {
		// TODO Auto-generated method stub
		if(FileImpl.isValidExcelFile(file)) {
			System.out.println("in if ");
			List<ClassExcel> customers=FileImpl.getDataFromExcel(file.getInputStream());
			excelrepo.saveAll(customers);
		}
		return null;
	}

	@Override
	public List<ClassExcel> getData() {
		// TODO Auto-generated method stub
		
		return excelrepo.findAll();
	}
	
/*	Workbook workbook;
	
	@Value("${app.upload.file:${user.home}}")
	public String EXCEL_FILE_PATH;

	
	public List<ClassExcel> getExcelDataAsList() {
		// TODO Auto-generated method stub
		
		List<String> list=new ArrayList<>();
		DataFormatter dataformatter = new DataFormatter();
		
		try {
			workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
			
			} 
		
		catch (EncryptedDocumentException | IOException ex) {
			// TODO: handle exception
			ex.printStackTrace();
			}
		
		System.out.println("Workbook has '" + workbook.getNumberOfSheets() + "'sheets");
		Sheet sheet = workbook.getSheetAt(0);
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		
		for(Row row : sheet) {
			for(Cell cell : row) {
				String cellValue = dataformatter.formatCellValue(cell);
				list.add(cellValue);
			}
		}
		
		List<ClassExcel> excellist = createList(list, noOfColumns);
		
		try {
			workbook.close();
		} 
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return excellist;
		
		
	}

	private List<ClassExcel> createList(List<String> list, int noOfColumns) {
		// TODO Auto-generated method stub
		ArrayList<ClassExcel> excel = new ArrayList<ClassExcel>();
		 int i = noOfColumns;
		 
		 do {
			 ClassExcel classex = new ClassExcel(null, EXCEL_FILE_PATH, null, EXCEL_FILE_PATH);
			 classex.setName(list.get(i));
			 classex.setSalary(Long.valueOf(list.get(i)));
			 classex.setCity(list.get(i));
			
			 excel.add(classex);
			 i = i+(noOfColumns);
		} while (i< list.size());
		 
		return excel;
	}

	@Override
	public List<ClassExcel> saveExcelData(MultipartFile file) {
		// TODO Auto-generated method stub
List<ClassExcel> excel;
		
		try {
			excel = ExcelHelper.ConvertExcelToListOfData(file.getInputStream());
			return this.excelrepo.saveAll(excel);
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
//		 throw new RuntimeException("Could not Store the file" + file.getOriginalFilename()+". Please try again.");
		
	}
	
	public List<ClassExcel> getAll() throws Exception{
		return excelrepo.findAll();
		
	}
	
	public ByteArrayInputStream getActualData() throws Exception{
		List<ClassExcel> list= excelrepo.findAll();
		ByteArrayInputStream byteArrayInputStream = ExcelHelper.databaseToExcel(list);
		return byteArrayInputStream;
	}  */



	}
	
	
	


