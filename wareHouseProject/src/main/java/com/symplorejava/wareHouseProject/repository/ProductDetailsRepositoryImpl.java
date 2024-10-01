package com.symplorejava.wareHouseProject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.symplorejava.wareHouseProject.entity.*;

public class ProductDetailsRepositoryImpl implements ProductDetailsRepository {


//Driver-> translator
	// Query ->question
	// ResultSet ->response

	// blocks {}
	// inside methods;
	private List<ProductDetails> prlist=new ArrayList<ProductDetails>();
	
	private Connection connectToDB() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// db url
			// username
			// password
			String url = "jdbc:mysql://localhost:3306/java_sessions_us_batch_db";
			 String userName = "root";
			 String password = "root";
			
			Connection connection = DriverManager.getConnection(url, userName, password);
			return connection;

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public void addProduct(ProductDetails product) {
		// TODO Auto-generated method stub

		// get connection
		// write a query
		// get the response

		try {
			Connection con = connectToDB();
			String query = "insert into product_details (p_name,man_date,exp_date,category) values (?,?,?,?);";
			PreparedStatement st = con.prepareStatement(query);

			// insert into table_name (col1,col2,col3) values ();
			st.setString(1, product.getProdName());
			st.setString(2, product.getManDate().toString());
			st.setString(3, product.getExpDate().toString());
			st.setString(4, product.getCategory());

			System.out.println("query :" + query);
			int noOfRowsEffected = st.executeUpdate();
			if (noOfRowsEffected > 0) {
				System.out.println("product inserted successfully");
			}

		} catch (SQLException e) {
			System.out.println("exception occured while adding the product");
			e.printStackTrace();
		}

	}

	@Override
	public List<ProductDetails> viewProducts() {
		// TODO Auto-generated method stub
				// get connection
				// write a select query
				// get the response
				//select * from  product_details
		try {
			Connection con = connectToDB();
			String query = "select * from  product_details";
			PreparedStatement st = con.prepareStatement(query);
			
			ResultSet rs = st.executeQuery();
			System.out.println("query :" + query);
			 while ( rs.next() ) 
			 {
				 ProductDetails product=new ProductDetails();
				 
				 product.setProdId(rs.getInt("p_id"));
				 product.setProdName(rs.getNString("p_name"));
				 product.setExpDate((rs.getDate("exp_date")).toLocalDate());
				 product.setManDate((rs.getDate("man_date")).toLocalDate());
				 product.setCategory(rs.getNString("category"));
				 prlist.add(product);
	      
	            }
			 
		} catch (SQLException e) {
			System.out.println("exception occured while Reading the products");
			e.printStackTrace();
		}
		
		return prlist;
	}

	@Override
	public int deleteProduct(Integer productId) {
		// TODO Auto-generated method stub
		int noOfRowsEffected =0;
		try {
			Connection con = connectToDB();
			String query = "delete from product_details  where p_id=" + productId;
			PreparedStatement st = con.prepareStatement(query);

			// update table_name 
			System.out.println("query :" + query);
			noOfRowsEffected = st.executeUpdate();
		
		} 
		catch (SQLException e) {
			System.out.println("exception occured while Deleting the product");
			e.printStackTrace();
		}
		return noOfRowsEffected;
	}

	@Override
	public int updateProduct(Integer productId, String productName) {
		// TODO Auto-generated method stub
				// get connection
				// write a update query
				// get the response
		//update product_details set p_name='watch' where p_id=6;
		int noOfRowsEffected=0;
				try {
					Connection con = connectToDB();
					String query = "update product_details set p_name='"+productName + "' where p_id="+productId;
					PreparedStatement st = con.prepareStatement(query);

					// update table_name 
					
						System.out.println("query :" + query);
						 noOfRowsEffected = st.executeUpdate();
			

				} catch (SQLException e) {
					System.out.println("exception occured while adding the product");
					e.printStackTrace();
				}
				return  noOfRowsEffected;

	}

}
