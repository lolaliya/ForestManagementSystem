package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Product;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.ProductCreationFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.exceptions.UpdationFailedException;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.RegExValidation;

public class ProductApp {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		RegExValidation regExValidation = new RegExValidation();
		ProductServices services = new ProductServicesImpl();
		boolean loop = true;
		while(loop)
		{
			System.out.println("-------------------------");
			System.out.println("1. Add Product");
			System.out.println("2. Delete Product");
			System.out.println("3. Search Product");
			System.out.println("4. Modify Product Description");
			System.out.println("5. Exit");
			System.out.println("---------------------------");

			System.out.println("Enter your choise:");
			String value = in.nextLine();
			boolean regExId = regExValidation.integerRegEx(value);
			while(!regExId) {
				System.out.println("Integer value Expected !!!");
				System.out.println("Re-enter your choice : ");
				value = in.nextLine();
				regExId = regExValidation.integerRegEx(value);
			}
			Integer choise = Integer.parseInt(value);

			switch(choise)
			{
			case 1:			// Add product
			{
				System.out.println("Enter product ID");
				int no=Integer.parseInt(in.nextLine());
				Product prod=services.searchProduct(no);
				if(prod!=null){
					System.out.println(" Product already exists");
					throw new ProductCreationFailedException("product creation failed Exception!!! ");
				}
				else{
					Product product = new Product();
					product.setProductId(no);
					System.out.println("Enter product name: ");
					product.setProductName(in.nextLine());
					System.out.println("Enter product description:");
					product.setProductDescription(in.nextLine());
					boolean state = services.addProduct(product);
					if(state)
					{
						System.out.println(services.searchProduct(no));
					}else{
						System.out.println("Product addition failed");
					}
				}
				break;
			}
			case 2:					// Delete product
			{
				System.out.println("Enter product ID");
				int no=Integer.parseInt(in.nextLine());
				Product prod=services.searchProduct(no);
				if(prod==null){
					System.out.println("Product doesnot exists");
					throw new DeletionFailedException("product Deletion failed Exception!!! ");
				}
				else{
					System.out.println("product deletion: " + services.deleteProduct(no));
				}
				break;
			}
			case 3:				// Search product
			{
				System.out.println("Enter product ID");
				int no=Integer.parseInt(in.nextLine());
				Product prod=services.searchProduct(no);

				if(prod==null) {
					System.out.println(" product doesnot exists");
					throw new SearchingFailedException("product search failed Exception!!! ");

				}else {
					System.out.println(prod);
				}
				break;
			}

			case 4:				// Update product
			{
				System.out.println("Enter product ID");
				int no=Integer.parseInt(in.nextLine());
				Product prod=services.searchProduct(no);
				if(prod==null){
					System.out.println("Product doesnot exists");
					throw new UpdationFailedException("Order updation failed Exception!!! ");

				}else {
					System.out.println("Enter product description");
					String description = in.nextLine();
					services.updateProduct(no, description);
					System.out.println("modified product: " + services.searchProduct(no) );
					break;
				}
			}
			case 5:
				loop = false;
				break;
			default: System.out.println("Invalid choise!!!!!");

			}
		}
		in.close();
	}
}
