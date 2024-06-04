package com.komal.Reading.of.csv.File.project.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.komal.Reading.of.csv.File.project.entity.Product;

@Repository
public class ProductRepository {

	@Autowired
	SessionFactory sf;
	
	
	public String saveRecords(List<Product> productlist) {
		String msg="uploaded Record";
		int count=0;
		try {
			Session session = sf.openSession();
			
			
			for (Product product : productlist) {
				
				session.save(product);
				session.beginTransaction().commit();
				count++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return msg+" ="+ count;
		
	
	}

		
	
}
