package com.symplorejava.wareHouseProject.entity;

import java.time.LocalDate;

public class ProductDetails {
	private Integer prodId;
	private String prodName;
	private LocalDate manDate;
	private LocalDate expDate;
	private String category;

	public Integer getProdId() {
		return prodId;
	}

	public void setProdId(Integer prodId) {
		this.prodId = prodId;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public LocalDate getManDate() {
		return manDate;
	}

	public void setManDate(LocalDate date) {
		this.manDate = date;
	}

	public LocalDate getExpDate() {
		return expDate;
	}

	public void setExpDate(LocalDate date) {
		this.expDate = date;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}
