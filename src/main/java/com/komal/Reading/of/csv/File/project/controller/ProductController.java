package com.komal.Reading.of.csv.File.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.komal.Reading.of.csv.File.project.entity.Product;
import com.komal.Reading.of.csv.File.project.service.ProductService;

@RestController
public class ProductController {

		@Autowired
		ProductService pservice;;
		
		@PostMapping("upload-csv")
		public ResponseEntity<String> saveRecords(@RequestParam MultipartFile file) {
			String mes=null;
			
			try {
				BufferedReader bfr= new BufferedReader(new InputStreamReader(file.getInputStream()));
				String line;
				List<Product> products= new ArrayList<>();
				
				
				bfr.readLine();
				
				
				while((line=bfr.readLine())!=null) {
					String[] data = line.split(",");
					if (data.length != 5) {
						return new ResponseEntity<>("Invalid CSV format.", HttpStatus.BAD_REQUEST);
					}
					
					
					Product product= new Product();
					product.setId(Integer.parseInt(data[0]));
					product.setName(data[1]);
					product.setDescrption(data[2]);
					product.setPrice(Integer.parseInt(data[3]));
					product.setQuantity(Integer.parseInt(data[4]));
					
					
					products.add(product);
				}	
					String message = pservice.saveRecords(products);
					
					return new ResponseEntity<>("File uploaded successfully . "+ message, HttpStatus.OK);
				
			} catch(IOException | NumberFormatException e) {
				e.printStackTrace();
				return new ResponseEntity<>("Failed to process CSV file.", HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
}
}
