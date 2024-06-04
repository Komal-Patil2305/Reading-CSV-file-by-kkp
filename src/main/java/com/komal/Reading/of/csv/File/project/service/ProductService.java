package com.komal.Reading.of.csv.File.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komal.Reading.of.csv.File.project.entity.Product;
import com.komal.Reading.of.csv.File.project.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pdao;

	
	public String saveRecords(List<Product> productlist) {
		String saveRecords = pdao.saveRecords(productlist);
		return saveRecords; 
		
		
		
	}
}
