package com.fms.app;

import java.util.Scanner;
import com.fms.beans.Orders;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.services.OrdersServices;
import com.fms.services.OrdersServicesImpl;
import com.fms.services.RegexValidation;

public class OrdersApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RegexValidation regExValidation = new RegexValidation();
		OrdersServices services = new OrdersServicesImpl();
		Boolean loop = true;
		while(loop)
		{
			System.out.println("------------------------");
			System.out.println("1. Add Orders");
			System.out.println("2. Delete Orders");
			System.out.println("3. Search Orders");
			System.out.println("4. Modify Orders");
			System.out.println("5. Exit");
			System.out.println("------------------------------");

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
				System.out.println("Enter Order ID");
				String orderId = sc.nextLine();
				boolean orderIdValidation = regExValidation.integerRegEx(orderId);
				Integer orderNumber = 0;
				while(!orderIdValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the order Id : ");
					orderId = sc.nextLine();
					orderIdValidation = regExValidation.integerRegEx(orderId);
				}
				orderNumber = Integer.parseInt(orderId);

				Orders cont=services.searchUser(orderNumber);
				if(cont!=null){
					System.out.println("Order already exists");
				}
				else{
					Orders orders = new Orders();
					orders.setOrderNo(orderNumber);

					System.out.println("Enter the Customer Id: ");
					String customerId = sc.nextLine();
					boolean customerValidation = regExValidation.integerRegEx(customerId);
					Integer customerNumber = 0;
					while(!customerValidation) {
						System.out.println("Integer value Expected !!!");
						System.out.println("Re-enter the customer Id : ");
						customerId = sc.nextLine();
						customerValidation = regExValidation.integerRegEx(customerId);
					}
					customerNumber = Integer.parseInt(customerId);
					orders.setCustomerId(customerNumber);


					System.out.println("Enter the Product Id: ");
					String value1 = sc.nextLine();
					boolean regExId1 = regExValidation.integerRegEx(value1);
					Integer idNumber1 = 0;
					while(!regExId1) {
						System.out.println("Integer value Expected !!!");
						System.out.println("Re-enter the Product Id : ");
						value1 = sc.nextLine();
						regExId1 = regExValidation.integerRegEx(value1);
					}
					idNumber1 = Integer.parseInt(value1);
					orders.setProductId(idNumber1);


					System.out.println("Enter the Haulier Id: ");
					String haulierId = sc.nextLine();
					boolean haulierValidation = regExValidation.integerRegEx(haulierId);
					Integer haulierNumber = 0;
					while(!haulierValidation) {
						System.out.println("Integer value Expected !!!");
						System.out.println("Re-enter the Haulier Id : ");
						haulierId = sc.nextLine();
						haulierValidation = regExValidation.integerRegEx(haulierId);
					}
					haulierNumber = Integer.parseInt(haulierId);
					orders.setHaulierId(haulierNumber);

					System.out.println("Enter the Delivery Date: ");
					orders.setDeliveryDate(sc.nextLine());

					System.out.println("Enter the Quantity: ");
					orders.setQuantity(Integer.parseInt(sc.nextLine()));

					System.out.println("Order creation: " + services.createProfile(orders));
					System.out.println(orders);
				}
				break;
			}

			case 2:
			{
				System.out.println("Enter Order ID");
				int orderId = Integer.parseInt(sc.nextLine());
				Orders order = services.searchUser(orderId);
				if(order == null){
					System.out.println("Order doesnot exists");
					throw new DeletionFailedException("Order doesnot exist");
				}
				else{
					System.out.println("Order deletion: " + services.deleteUser(orderId));
				}
				break;
			}

			case 3:
			{
				System.out.println("Enter Order ID");
				int orderId = Integer.parseInt(sc.nextLine());
				Orders orders = services.searchUser(orderId);

				if(orders == null) {
					System.out.println("Order doesnot exists");
					throw new SearchingFailedException("Order doesnot exists");

				}else {
					System.out.println(orders);
				}
				break;
			}

			case 4:
			{   
				boolean states = false;
				System.out.println("Enter Orders ID");
				int orderId=Integer.parseInt(sc.nextLine());
				System.out.println("1. Modify Delivery Date");
				System.out.println("2. Modify Quantity");

				System.out.println("Enter your choice: ");
				String choiceValue = sc.nextLine();
				boolean modifyValidation = regExValidation.integerRegEx(choiceValue);
				while(!modifyValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter your choice : ");
					choiceValue = sc.nextLine();
					modifyValidation = regExValidation.integerRegEx(choiceValue);
				}
				Integer modifyChoice = Integer.parseInt(choiceValue);

				switch(modifyChoice)
				{
				case 1:
				{
					System.out.println("Enter old Delivery Date ");
					String oldId = (sc.nextLine());
					System.out.println("Enter new Delivery Date");
					String newId = (sc.nextLine());
					states =  services.updateDeliveryDate(orderId,oldId, newId);
					if(states)
						System.out.println("modified order: " + services.searchUser(orderId) );
					else
						System.out.println("old delivery date do not match");
					break;
				}
				case 2:
				{
					System.out.println("Enter old Quantity ");
					int oldQuantity = Integer.parseInt(sc.nextLine());
					System.out.println("Enter new Quantity");
					int newQuantity = Integer.parseInt(sc.nextLine());
					states =  services.updateQuantity(orderId,oldQuantity, newQuantity);
					if(states)
						System.out.println("modified order: " + services.searchUser(orderId) );
					else
						System.out.println("Old Quantity do not match");
					break;
				}
				default: System.out.println("Invalid option!!!!!");
				}

				Orders cont=services.searchUser(orderId);
				if(cont==null){
					System.out.println("Order doesnot exists");
				}
				break;
			}

			case 5: {
				loop = false;
				break;
			}
			default :
			{
				System.out.println("invalid choice!!!!!");
			}
			}
		}
		sc.close();
	}
}
