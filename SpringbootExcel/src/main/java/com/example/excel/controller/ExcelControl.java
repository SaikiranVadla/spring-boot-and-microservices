package com.example.excel.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.excel.service.ExcelService;
import com.example.excel.service.FileImpl;

@RestController
public class ExcelControl {
	
	@Autowired
	private ExcelService excelservice;
	
	
	
	
	
//	@GetMapping("/index")
//	public String index() {
//		return null;
//	}
//	
//	@PostMapping("/upload")
//	public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectattributes) {
//		
//		fileservice.uploadFile(file);
//		redirectattributes.addFlashAttribute("message", "You've successfully uploaded ' " + file.getOriginalFilename()+"' !");
//	
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO: handle exception
//			e.printStackTrace();
//			
//		}
//     	return "redirect:/";		
//	}
//	
//	@GetMapping("/save")
//	public String saveExcelData(Model model) {
//		List<ClassExcel> excelDataAsList = excelservice.getExcelDataAsList();
//		List<ClassExcel> noOfRecords = excelservice.saveExcelData(null);
//		model.addAttribute("noOfRecords",noOfRecords);
//		return "Success!";
//	}
//	
	
	
	@PostMapping("/upload") 
	public Map<String,Object>upload(@RequestParam("file") MultipartFile file) throws IOException{
		excelservice.saveExcelToDatabase(file);
		Map<String,Object> map=new HashMap<>();
		map.put("message", "uploaded sucefully");
		return map;
				
	}
	@GetMapping("/get")
	public Map<String,Object> get(){
		Map<String,Object> map=new HashMap<>();
		map.put("message", excelservice.getData());
		return map;
	
	}
	

}
