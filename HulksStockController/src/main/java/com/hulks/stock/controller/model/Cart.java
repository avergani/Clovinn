package com.hulks.stock.controller.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carts")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int productId;
	private String desciption;
	private double price;
	private int units;
	private double subtotal;
	
	public Cart() {
		
	}

	/**
	 * @param id
	 * @param productId
	 * @param desciption
	 * @param price
	 * @param units
	 * @param subtotal
	 */
	public Cart(int id, int productId, String desciption, double price, int units, double subtotal) {
		super();
		this.id = id;
		this.productId = productId;
		this.desciption = desciption;
		this.price = price;
		this.units = units;
		this.subtotal = subtotal;
	}

	
	// Getters & Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}


	
}
