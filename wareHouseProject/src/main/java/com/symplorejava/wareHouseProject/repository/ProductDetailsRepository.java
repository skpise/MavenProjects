package com.symplorejava.wareHouseProject.repository;

import java.util.List;

import com.symplorejava.wareHouseProject.entity.ProductDetails;


public interface ProductDetailsRepository {
	public void addProduct(ProductDetails productDetails);

	public List<ProductDetails> viewProducts();

	public int deleteProduct(Integer productId);

	public int updateProduct(Integer productId, String productName);

}
