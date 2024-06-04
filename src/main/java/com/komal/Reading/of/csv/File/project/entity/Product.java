package com.komal.Reading.of.csv.File.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String descrption;
	private int price;
	private int quantity;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(int id, String name, String descrption, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.descrption = descrption;
		this.price = price;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescrption() {
		return descrption;
	}



	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descrption=" + descrption + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}
	
	
	

}
