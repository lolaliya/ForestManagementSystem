package com.java.app;

import java.util.Scanner;

import com.java.beans.Product;
import com.java.services.ProductServices;
import com.java.services.ProductServicesImpl;
import com.java.services.RegexValidation;

public class ProductApp {
	static RegexValidation regexValid = new RegexValidation(); 

	public static void main(String[] args) {
		int choice ;
		boolean loop = true;
		ProductServices services = new ProductServicesImpl();
		Scanner in = new Scanner(System.in);
		System.out.println("1. AddProduct");
		System.out.println("2. ModifyProduct");
		System.out.println("3. DeleteProduct");
		System.out.println("Enter your choice");

		String values = in.nextLine();
		boolean regExChoise = regexValid.integerRegEx(values);
		while(!regExChoise) {
			System.out.println("Integer value epected!!!");
			System.out.println("Re-enter your choise:");
			values = in.nextLine();
			regExChoise = regexValid.integerRegEx(values);
		}
		choice = Integer.parseInt(values);

		while(loop) {
			switch(choice)
			{

			case 1 : 			// Add product

				Product product = new Product();
				System.out.println("Enter the Product id :");
				 values = in.nextLine();
				boolean regExProdId = regexValid.integerRegEx(values);
				while(!regExProdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter your choise:");
					values = in.nextLine();
					regExProdId = regexValid.integerRegEx(values);
				}
				Integer productId = Integer.parseInt(values);
				product.setProductId(productId);
				
				System.out.println("Enter the Product Name :");
				String ProductName = in.nextLine();
				boolean regExProductName = regexValid.stringRegEx(ProductName);
				while(!regExProductName){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					ProductName = in.nextLine();
					regExProductName = regexValid.stringRegEx(ProductName);
				}
				product.setProductName(ProductName);
				
				System.out.println("Enter the Product Description :");
				String ProductDescription = in.nextLine();
				boolean regExProductDescription = regexValid.stringRegEx(ProductDescription);
				while(!regExProductDescription){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					ProductDescription = in.nextLine();
					regExProductDescription = regexValid.stringRegEx(ProductDescription);
				}
				product.setProductDescription(ProductDescription);
				
				System.out.println(services.addProduct(product));
				break;


			case 2:				// Modify product

				Product product1 = new Product();
				System.out.println("Enter the Product id :");
				 values = in.nextLine();
				 regExProdId = regexValid.integerRegEx(values);
				while(!regExProdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter your choise:");
					values = in.nextLine();
					regExProdId = regexValid.integerRegEx(values);
				}
				 productId = Integer.parseInt(values);
				product1.setProductId(productId);
				
				System.out.println("Enter the Product Name :");
				 ProductName = in.nextLine();
				 regExProductName = regexValid.stringRegEx(ProductName);
				while(!regExProductName){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					ProductName = in.nextLine();
					regExProductName = regexValid.stringRegEx(ProductName);
				}
				product1.setProductName(ProductName);
				
				System.out.println("Enter the Product Description :");
				 ProductDescription = in.nextLine();
				 regExProductDescription = regexValid.stringRegEx(ProductDescription);
				while(!regExProductDescription){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					ProductDescription = in.nextLine();
					regExProductDescription = regexValid.stringRegEx(ProductDescription);
				}
				product1.setProductDescription(ProductDescription);
				
				System.out.println(services.modifyProduct(productId, product1));
				break;


			case 3 :			// Delete product

				System.out.println("Enter the Product id :");
				 values = in.nextLine();
				 regExProdId = regexValid.integerRegEx(values);
				while(!regExProdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter your choise:");
					values = in.nextLine();
					regExProdId = regexValid.integerRegEx(values);
				}
				 productId = Integer.parseInt(values);
				System.out.println("Product deletion: " + services.deleteProduct(productId));
				break;

			case 4: loop = false;
			break;
			default : System.out.println("Not a valid Option !!!!!!");
			}
		}
		in.close();
	}


}
