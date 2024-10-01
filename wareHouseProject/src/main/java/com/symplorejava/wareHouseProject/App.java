package com.symplorejava.wareHouseProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.symplorejava.wareHouseProject.controller.*;
import com.symplorejava.wareHouseProject.entity.ProductDetails;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Scanner sc = new Scanner(System.in);
	
	
    public static void main( String[] args )
    {
       // System.out.println( "Hello World!" );
       // addProduct();
        showProduct();
      //  updateProcuct();
       // deleteProduct();
    }
    
    
    
    
    
    private static void addProduct() {

		System.out.println("enter product Name");
		String pname = sc.next();
		System.out.println("enter manufacturing date in format d-MM-YYYY");
		String manDate = sc.next();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate mdt = LocalDate.parse(manDate, dtf);

		System.out.println("enter expiry date in format DD-MM-YYYY");
		String expDate = sc.next();
		LocalDate edt = LocalDate.parse(expDate, dtf);
		System.out.println("enter category");
		String category = sc.next();

		ProductDetails product = new ProductDetails();
		product.setCategory(category);
		product.setExpDate(edt);
		product.setManDate(mdt);
		product.setProdName(pname);
		ProductServiceController controller= new ProductServiceController();
		controller.addProduct(product);

	}
	
	private static void showProduct()
	{
		try
		{
		
			ProductServiceController controller= new ProductServiceController();
			List<ProductDetails> lst =controller.viewProduct();
		
			 for (ProductDetails product : lst) {
				 System.out.println("product Id="+ product.getProdId());
				 System.out.println("product Name="+ product.getProdName());
				 System.out.println("product Name="+ product.getCategory());
				 System.out.println("product MFG Date="+ product.getManDate());
				 System.out.println("product EXP Date="+ product.getExpDate());
				 System.out.println();
			 }
		 
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

	}
	
	private static void updateProcuct()
	{
		try
		{
			ProductServiceController controller= new ProductServiceController();
			System.out.println("enter product Id");
			int pId = sc.nextInt();
			System.out.println("enter product Name");
			String pName = sc.next();
			controller.updateProcuct(pId, pName);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	private static void deleteProduct()
	{
			try
			{
				ProductServiceController controller= new ProductServiceController();
				System.out.println("enter product Id");
				int pId = sc.nextInt();
				controller.deleteProcuct(pId);
			}
			catch (Exception e) 
			{
				System.out.println(e.getMessage());
			}
			
	}
	

}
