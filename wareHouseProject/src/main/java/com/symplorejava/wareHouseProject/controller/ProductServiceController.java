package com.symplorejava.wareHouseProject.controller;

import java.util.ArrayList;
import java.util.List;

import com.symplorejava.wareHouseProject.entity.ProductDetails;
import com.symplorejava.wareHouseProject.service.ProductDetailsService;
import com.symplorejava.wareHouseProject.service.ProductServiceImpl;


public class ProductServiceController {
private ProductDetailsService productDetailsService = new ProductServiceImpl();
	

	public void addProduct(ProductDetails product) {
		
		
		String successMessage = productDetailsService.addProduct(product);
		
		
		System.out.println(successMessage);

	}
	
public  List<ProductDetails> viewProduct() {

	List<ProductDetails> prControllerlist=new ArrayList<ProductDetails>();
		
	prControllerlist= productDetailsService.viewProducts();
		
	return prControllerlist;

	}
	
	public void updateProcuct(Integer productId, String productName)
	{
		String successMessage = productDetailsService.updateProduct(productId,productName);
		System.out.println(successMessage);
	
	}
	
	public void deleteProcuct(Integer productId)
	{
		String successMessage = productDetailsService.deleteProduct(productId);
		System.out.println(successMessage);
	
	}
	
}
