package com.fms.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fms.beans.Orders;
import com.fms.beans.Product;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.OrderCreationFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.exceptions.UpdationFailedException;
import com.fms.services.ContractServices;
import com.fms.services.ContractServicesImpl;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.OrderServicesImpl;
import com.fms.services.OrdersServices;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.RegExValidation;

public class OrderApp {


	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		RegExValidation regExValidation = new RegExValidation();
		ContractServices services4 = new ContractServicesImpl();
		new CustomerServicesImpl();
		ProductServices services2 = new ProductServicesImpl();
		new HaulierServicesImpl();
		OrdersServices services = new OrderServicesImpl(); 
		boolean loop = true;
		while(loop)
		{
			System.out.println("---------------------");
			System.out.println("1. Add Order");
			System.out.println("2. Delete Order");
			System.out.println("3. Search Order");
			System.out.println("4. Modify Date");
			System.out.println("5. Exit");
			System.out.println("------------------------");

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
			case 1:			// Add order
			{ 
				System.out.println("Enter order ID");
				int no=Integer.parseInt(in.nextLine());
				Orders ord=services.searchOrder(no);
				if(ord!=null){
					System.out.println("Order already exists");
					throw new OrderCreationFailedException("Order creation failed Exception!!!");
				}
				else{
					Orders order = new Orders();
					order.setOrderNo(no);
					System.out.println("Enter the productId:");
					int productId = Integer.parseInt(in.nextLine());
					List<Product> products = new ArrayList<Product>();
					products.add(services2.searchProduct(productId));
					order.setProducts(products);

					System.out.println("Enter the contract Id: ");
					int contractId = Integer.parseInt(in.nextLine());
					order.setContract(services4.searchContract(contractId));

					System.out.println("Enter the quantity");
					order.setQuantity(Integer.parseInt(in.nextLine()));

					System.out.println("Enter the Delivery Date: ");
					String tempDate = in.nextLine();
					order.setDeliveryDate(Date.valueOf(tempDate));
					boolean state = services.addOrder(order);
					if(state)
					{
						System.out.println(services.searchOrder(no));
					}else{
						System.out.println("Order creation failed");
					}
				}
				break;
			}

			case 2:					// Delete order
			{
				 System.out.println("Enter order ID");
					int no=Integer.parseInt(in.nextLine());

				Orders order=services.searchOrder(no);
				if(order==null){
					System.out.println(" order doesnot exists");
					throw new DeletionFailedException("Order Deletion failed Exception !!! ");

				}
				else{
					System.out.println("order deletion: " + services.deleteOrder(no));
				}
				break;
			}

			case 3:					// search Order
			{
				 System.out.println("Enter order ID");
					int no=Integer.parseInt(in.nextLine());

				Orders order=services.searchOrder(no);

				if(order==null) {
					System.out.println("Order doesnot exists");
					throw new SearchingFailedException("Order Searching failed Exception !!! ");
				}else {
					System.out.println(order);
				}
				break;
			}

			case 4:					// Modify Order
			{
				 System.out.println("Enter order ID");
					int no=Integer.parseInt(in.nextLine());

				Orders order=services.searchOrder(no);
				if(order==null){
					System.out.println("Order doesnot exists");
					throw new UpdationFailedException("order Updation failed Exception !!! ");

				}else {
					System.out.println("Enter new delivery Date");
					String tempDate = in.nextLine();
					Date date = Date.valueOf(tempDate);
					services.updateDeliveryDate(no, date);
					System.out.println("modified Order: " + services.searchOrder(no) );
					break;				
				}
			}

			case 5: 				// Exit
				loop = false;
				break;

			default :
				System.out.println("invalid choise!!!!!");
			}
		}
		in.close();
	}
}
