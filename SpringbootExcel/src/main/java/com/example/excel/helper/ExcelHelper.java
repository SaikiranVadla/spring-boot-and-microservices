package com.example.excel.helper;

/*	import java.io.ByteArrayInputStream;
	import java.io.ByteArrayOutputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Iterator;
	import java.util.List;
	import java.util.Map;
	
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.xssf.usermodel.XSSFSheet;
	import org.apache.poi.xssf.usermodel.XSSFWorkbook;
	import org.springframework.web.multipart.MultipartFile;
	
	import com.example.excel.entity.ClassExcel;*/

public class ExcelHelper {
	
/*	public static String[]HEADERS = {"id","name","salary","city"};
	
	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType = file.getContentType();
		Map<String, Object>response = new HashMap<>();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}   
		else {
			response.put("Message : ", "Provided file is not an excel type");
			response.put("Status : ", "false");
			response.put("Result : ", "failed");
			return false;
		}
		
	}
	
	public static List<ClassExcel> ConvertExcelToListOfData(InputStream inputstream){
		   List<ClassExcel> list = new ArrayList<>();
		   try {
			   XSSFWorkbook workbook = new XSSFWorkbook(inputstream);
			   XSSFSheet sheet = workbook.getSheet("data");
			   
			   int rowNumber=0;
			   Iterator<Row> itr = sheet.iterator();
			   
			   while (itr.hasNext()) {
				   Row row = itr.next();
				   if(rowNumber==0) { rowNumber++;  continue;}
				   Iterator<Cell> cells = row.iterator();
				   int cid=1;
				   ClassExcel classex = new ClassExcel(null, null, null, null);
				   
				   while (cells.hasNext()) {
					Cell cell = cells.next();
					
					switch(cid) {
					case 1 : { classex.setId(null);  break;}
					case 2 : { classex.setName(cell.getStringCellValue()); break;}
					case 3 : { classex.setSalary(null); break;}
					case 4 : { classex.setCity(cell.getStringCellValue());  break;}
					default : break;
					
					}
					cid++;
				}
				
				list.add(classex);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		   return list;
	}
	
	public static String sheet1="excelData";
	
	public static ByteArrayInputStream databaseToExcel(List<ClassExcel> list) throws IOException{
		 Workbook workbook = new XSSFWorkbook();
		 ByteArrayOutputStream out = new ByteArrayOutputStream();
		 
		 try {
			 
			Sheet sheetName = workbook.createSheet(sheet1);
			Row row = sheetName.createRow(0);
			for(int i=0;i<HEADERS.length;i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(HEADERS[i]);
			}
			
			int rowIndex=1;
			for(ClassExcel ce:list) {
				Row dataRow=sheetName.createRow(rowIndex);
				rowIndex++;
				dataRow.createCell(0).setCellValue(ce.getId());
				dataRow.createCell(1).setCellValue(ce.getName());
				dataRow.createCell(2).setCellValue(ce.getSalary());
				dataRow.createCell(3).setCellValue(ce.getCity());
			}
			workbook.write(out);
			
			return new ByteArrayInputStream(out.toByteArray());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		 finally {
			workbook.close();
			out.close();
			}
	}
*/
	
	
}
