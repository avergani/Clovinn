package com.hulks.stock.controller.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String productCode;
	private String description;
	private Date date;
	private String size;
	private String provider;
	private int min;
	private int max;
	private int actualStock;
	private double unitValue;
	private double totalValue;
	
	public Product() {
		
	}

	/**
	 * @param id
	 * @param name
	 * @param productCode
	 * @param description
	 * @param date
	 * @param size
	 * @param provider
	 * @param min
	 * @param max
	 * @param actualStock
	 * @param unitValue
	 * @param totalValue
	 */
	public Product(int id, String name, String productCode, String description, Date date, String size, String provider,
			int min, int max, int actualStock, double unitValue, double totalValue) {
		super();
		this.id = id;
		this.name = name;
		this.productCode = productCode;
		this.description = description;
		this.date = date;
		this.size = size;
		this.provider = provider;
		this.min = min;
		this.max = max;
		this.actualStock = actualStock;
		this.unitValue = unitValue;
		this.totalValue = totalValue;
	}

	
	//Getters & Setters
	
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

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getActualStock() {
		return actualStock;
	}

	public void setActualStock(int actualStock) {
		this.actualStock = actualStock;
	}

	public double getUnitValue() {
		return unitValue;
	}

	public void setUnitValue(double unitValue) {
		this.unitValue = unitValue;
	}

	public double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(double totalValue) {
		this.totalValue = totalValue;
	}
	
}
