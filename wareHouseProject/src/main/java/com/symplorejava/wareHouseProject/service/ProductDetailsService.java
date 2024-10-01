package com.symplorejava.wareHouseProject.service;

import java.util.List;
import com.symplorejava.wareHouseProject.entity.*;

public interface ProductDetailsService {

	public String addProduct(ProductDetails productDetails);
	public List<ProductDetails> viewProducts();
	public String updateProduct(Integer productId, String productName);
	public String deleteProduct(Integer productId);
}
