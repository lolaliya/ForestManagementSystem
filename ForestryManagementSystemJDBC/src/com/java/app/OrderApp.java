package com.java.app;

import java.sql.Date;
import java.util.Scanner;
import com.java.beans.Orders;
import com.java.exceptions.CreationFailedException;
import com.java.exceptions.ModificationFailedException2;
import com.java.services.OrderServices;
import com.java.services.OrderServicesImpl;
import com.java.services.RegexValidation;

public class OrderApp {
	static RegexValidation regExValidation = new RegexValidation(); 
	public static void main(String[] args) throws Exception{

		OrderServices services = new OrderServicesImpl();
		Scanner in = new Scanner(System.in);
		int choice ;
		boolean loop = true;

		while(loop)
		{
			System.out.println("1. AddOrders");
			System.out.println("2. ModifyOrders");
			System.out.println("3. DeleteOrders");
			System.out.println("4. Exit");
			System.out.println("Enter your choice");
			choice = Integer.parseInt(in.nextLine());
			switch(choice)
			{
			case 1 :					// Add profile

				Orders order = new Orders();
				System.out.println("Enter the order No :");
				String value = in.nextLine();
				boolean regExOrdId = regExValidation.integerRegEx(value);
				while(!regExOrdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the order no:");
					value = in.nextLine();
					regExOrdId = regExValidation.integerRegEx(value);
				}
				int orderNo = Integer.parseInt(value);
				order.setOrderNo(orderNo);

				System.out.println("Enter the customer id :");
				value = in.nextLine();
				boolean regExCustId = regExValidation.integerRegEx(value);
				while(!regExCustId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExCustId = regExValidation.integerRegEx(value);
				}
				int custId = Integer.parseInt(value);
				order.setCustomerId(custId);

				System.out.println("Enter the product Id :");
				value = in.nextLine();
				boolean regExProdId = regExValidation.integerRegEx(value);
				while(!regExProdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the product id:");
					value = in.nextLine();
					regExProdId = regExValidation.integerRegEx(value);
				}
				int prodId = Integer.parseInt(value);
				order.setProductId(prodId);

				System.out.println("Enter the haulier Id :");
				value = in.nextLine();
				boolean regExHaulId = regExValidation.integerRegEx(value);
				while(!regExHaulId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the haulier id:");
					value = in.nextLine();
					regExHaulId = regExValidation.integerRegEx(value);
				}
				int haulId = Integer.parseInt(value);
				order.setHaulierId(haulId);

				System.out.println("Enter the Delivery Date :");
				String tempDate = in.nextLine();
				order.setDeliveryDate(Date.valueOf(tempDate));

				System.out.println("Enter the Quantity required :");
				value = in.nextLine();
				boolean regExQuantity = regExValidation.integerRegEx(value);
				while(!regExQuantity) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the haulier id:");
					value = in.nextLine();
					regExQuantity = regExValidation.integerRegEx(value);
				}
				int quantity = Integer.parseInt(value);
				order.setQuantity(quantity);

				Orders orders = services.addOrders(order);
				if(orders!=null) {
					System.out.println(orders);
				}else {
					System.out.println("Order creation failed");
					throw new CreationFailedException("Orders creation failed");
				}
				break;


			case 2: 				// Modify profile

				System.out.println("Enter the Order No :");
				value = in.nextLine();
				regExOrdId = regExValidation.integerRegEx(value);
				while(!regExOrdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExOrdId = regExValidation.integerRegEx(value);
				}
				orderNo = Integer.parseInt(value);
				System.out.println("Enter modifying quantity:");
				value = in.nextLine();
				boolean regExNewQuantity = regExValidation.integerRegEx(value);
				while(!regExNewQuantity) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the haulier id:");
					value = in.nextLine();
					regExNewQuantity = regExValidation.integerRegEx(value);
				}
				int newQuantity = Integer.parseInt(value);
				System.out.println("order modification: " + services.modifyOrders(orderNo,newQuantity));
				break;


			case 3 :				// Delete profile

				System.out.println("Enter the order No :");
				value = in.nextLine();
				regExOrdId = regExValidation.integerRegEx(value);
				while(!regExOrdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExOrdId = regExValidation.integerRegEx(value);
				}
				orderNo = Integer.parseInt(value);
				boolean delOrders = services. deleteOrders(orderNo);
				if(delOrders)
				{
					System.out.println("Order deletion: " + delOrders);
				}else {
					System.out.println("order deletion failed");
					throw new ModificationFailedException2("Orders modification failed");
				}
				break;


			case 4: 				// Exit
				loop = false;
				break;
			default : System.out.println("Not a valid Option !!!!!!");
			}
		}
		in.close();
	}

}




