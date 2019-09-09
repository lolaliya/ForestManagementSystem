package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Product;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.RegexValidation;

public class ProductApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		ProductServices services = new ProductServicesImpl();
		RegexValidation regExValidation = new RegexValidation();
		Product product = new Product();
		Boolean loop = true;
	   
		while(loop)
		{
	    	System.out.println("--------------------------");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Search Product");
			System.out.println("4. Exit");
			System.out.println("--------------------------");
			
			System.out.println("Enter your choice:");
			String value = sc.nextLine();
			boolean regExId = regExValidation.integerRegEx(value);
			while(!regExId) {
				System.out.println("Integer value Expected !!!");
				System.out.println("Re-enter your choice : ");
				value = sc.nextLine();
				regExId = regExValidation.integerRegEx(value);
			}
			Integer choice = Integer.parseInt(value);
			
			
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter Product ID");
				String productId = sc.nextLine();
				boolean productValidation = regExValidation.integerRegEx(productId);
				while(!productValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter your choice : ");
					productId = sc.nextLine();
					productValidation = regExValidation.integerRegEx(productId);
				}
				Integer productNumber = Integer.parseInt(productId);
				
				Product cont=services.searchUser(productNumber);

				if(cont!=null){
					System.out.println("Product already exists");

				}
				else{
					Product product1 = new Product();
					product.setProductId(productNumber);

					System.out.println("Enter the product name: ");
					product.setProductName(sc.nextLine());

					System.out.println("Enter the product description: ");
					product.setProductDescription(sc.nextLine());

					System.out.println("Product creation: " + services.createProfile(product));
					System.out.println(product);
				}
				break;
			}

			case 2:
			{
				System.out.println("Enter Product ID");
				int productId = Integer.parseInt(sc.nextLine());
				Product product1 = services.searchUser(productId);
				if(product ==  null){
					System.out.println("Product doesnot exists");
					throw new DeletionFailedException("Product doesnot Exist");
				}
				else{
					System.out.println("Product deletion: " + services.deleteUser(productId));
				}
				break;
			}

			case 3:
			{
				System.out.println("Enter Product ID");
				int productId = Integer.parseInt(sc.nextLine());
				Product product1 = services.searchUser(productId);

				if(product==null) {
					System.out.println("Product doesnot exists");
					throw new SearchingFailedException("Product Doesnot Exists");
				}else {
					System.out.println(product);
				}
				break;
			}

			case 4:
			{
				loop = false;
				break;
			}

			default :
			{
				System.out.println("invalid choise!!!!!");
			}
			}
		}
		sc.close();
	}
}
