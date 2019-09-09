package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Customer;
import com.fms.exceptions.CustomerCreationFailedException;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.exceptions.UpdationFailedException;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.RegExValidation;

public class CustomerApp {


	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		CustomerServices services = new CustomerServicesImpl();
		RegExValidation regExValidation = new RegExValidation();
		boolean loop = true;
		while(loop)
		{   
			System.out.println("--------------------------");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Modify Customer");
			System.out.println("5. Exit");
			System.out.println("---------------------------");

			System.out.println("Enter your choice:");
			String value = in.nextLine();
			boolean regExId = regExValidation.integerRegEx(value);
			while(!regExId) {
				System.out.println("Integer value Expected !!!");
				System.out.println("Re-enter your choice : ");
				value = in.nextLine();
				regExId = regExValidation.integerRegEx(value);
			}
			Integer choice = Integer.parseInt(value);


			System.out.println("Enter Customer ID");
			int no=Integer.parseInt(in.nextLine());

			switch(choice)
			{
			case 1:			// Add profile
			{
				Customer cont=services.searchCustomer(no);
				if(cont!=null){
					System.out.println("customer profile already exists");
					throw new CustomerCreationFailedException("Customer creation failed Exception!!! ");
				}
				else{
					Customer customer = new Customer();
					
					customer.setCustomerId(no);
					System.out.println("Enter the Customer Name: ");
					customer.setCustomerName(in.nextLine());
					System.out.println("Enter Street address 1: ");
					customer.setStreetAddress1(in.nextLine());
					System.out.println("Enter Street address 2: ");
					customer.setStreetAddress2(in.nextLine());
					System.out.println("Enter post code: ");
					customer.setPostCode(Integer.parseInt(in.nextLine()));
					System.out.println("Enter towncity: ");
					customer.setTownCity(in.nextLine());
					System.out.println("enter telepone number: ");
					customer.setTelephoneNo(Long.parseLong(in.nextLine()));
					System.out.println("Enter email: ");
					customer.setEmail(in.nextLine());
					System.out.println("Enter password: ");
					customer.setPassword(in.nextLine());
					boolean state = services.addCustomer(customer);
					if(state)
					{
						System.out.println(services.searchCustomer(no));
					}else{
						System.out.println("Profile creation failed");
					}
				}
				break;
			}

			case 2:					// Delete profile
			{
				Customer cont=services.searchCustomer(no);
				if(cont==null){
					System.out.println("Customer profile doesnot exists");
                     throw new DeletionFailedException("Deletion failed Exception!!! ");
				}
				else{
					System.out.println("Customer deletion: " + services.deleteCustomer(no));
				}

				break;
			}

			case 3:				// Search profile
			{
				Customer cont=services.searchCustomer(no);

				if(cont==null) {
					System.out.println("Customer profile doesnot exists");
                     throw new SearchingFailedException("Searching failed Exception!!! ");
				}else {
					System.out.println(cont);
				}
				break;
			}

			case 4:					// Modify profile
			{
				Customer cont=services.searchCustomer(no);
				if(cont==null){
					System.out.println("Customer profile doesnot exists");
                    throw new UpdationFailedException("modification Failed Exception!!! ");
				}else {
					boolean states = false;
					int option;
					System.out.println("---------------------------");
					System.out.println("1. Modify Telephone number");
					System.out.println("2. Modify Email");
					System.out.println("3. Modify Password");
					System.out.println("----------------------------");

					System.out.println("Enter your choise: ");
					String modifyChoice = in.nextLine();
					boolean modifyValidation = regExValidation.integerRegEx(modifyChoice);
					while(!modifyValidation) {
						System.out.println("Integer value Expected !!!");
						System.out.println("Re-enter your choice : ");
						modifyChoice = in.nextLine();
						modifyValidation = regExValidation.integerRegEx(modifyChoice);
					}
					option = Integer.parseInt(modifyChoice);
					int customerId = no;
					switch(option)
					{


					case 1:			//Modify telephone number
					{
						System.out.println("Enter new Number");
						long newNumber = Long.parseLong(in.nextLine());
						states =  services.updateTelephone( customerId,  newNumber) ;
						System.out.println("modified customer: " + services.searchCustomer(customerId) );
						break;
					}


					case 2:			// Modify Email
					{
						System.out.println("Enter new E-mail");
						String email = (in.nextLine());
						states =  services.updateEmail( customerId,  email);
						System.out.println("modified customer: " + services.searchCustomer(customerId) );
						break;
					}

					case 3:			// Modify password
					{
						System.out.println("Enter new Password ");
						String passwd = (in.nextLine());
						states =  services.updatePassword(customerId,  passwd);
						System.out.println("modified customer: " + services.searchCustomer(customerId) );
						break;
					}
					default: System.out.println("Invalid option!!!!!");
					}
					System.out.println("Modification: "+states);
				}
				break;
			}

			case 5: loop = false;
			break;
			default :
			{
				System.out.println("invalid choise!!!!!");
			}
			}
		}

		in.close();
	}

}


