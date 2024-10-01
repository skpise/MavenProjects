package com.symplorejava.wareHouseProject.service;

import java.util.List;
import com.symplorejava.wareHouseProject.entity.*;
import com.symplorejava.wareHouseProject.repository.*;

public class ProductServiceImpl implements ProductDetailsService{


	@Override
	public String addProduct(ProductDetails productDetails) {
		ProductDetailsRepository productRepository = new ProductDetailsRepositoryImpl();
		productRepository.addProduct(productDetails);
		return "PRODUCT ADDED SUCCESSFULLY";
	}
	
	@Override
	public List<ProductDetails> viewProducts() {
		ProductDetailsRepository productRepository = new ProductDetailsRepositoryImpl();
		// TODO Auto-generated method stub
		return productRepository.viewProducts();
	}
	
	@Override
	public String updateProduct(Integer productId, String productName)
	{
	 ProductDetailsRepository productRepository = new ProductDetailsRepositoryImpl();
	 Integer updated=productRepository.updateProduct(productId,productName);
	 String result="";
	 if(updated>0)
	 {
		 result="updated SUCCESSFULLY ";
	 }
	 else
	 {
		 result="does not exist";
	 }
		return "PRODUCT "+ result;
	}
	
	@Override
	public String deleteProduct(Integer productId)
	{
		ProductDetailsRepository productRepository = new ProductDetailsRepositoryImpl();
		String result="";
		Integer deleted= productRepository.deleteProduct(productId);
		if(deleted>0)
			
		{
			result="deleted successfully";
		}
		else
		{
			result="does not exist";
		}
		return  "PRODUCT " + result;
		
	}
}