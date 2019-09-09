package com.fms.app;

import java.util.Scanner;
import com.fms.beans.Customer;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.RegexValidation;


public class CustomerApp {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		RegexValidation regExValidation = new RegexValidation();
		CustomerServices services = new CustomerServicesImpl();
		Customer customer = new Customer();
		Boolean loop = true;
		while(loop)
		{   
			System.out.println("----------------------------");
			System.out.println("1. Add Customer");
			System.out.println("2. Delete Customer");
			System.out.println("3. Search Customer");
			System.out.println("4. Modify Customer");
			System.out.println("5. Exit"); 
			System.out.println("-------------------------------");
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
				System.out.println("Enter Customer Id");
				String customerId = sc.nextLine();
				boolean customerIdValidation = regExValidation.integerRegEx(customerId);
				Integer customerIdNumber = 0;
				while(!customerIdValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the customer Id : ");
					customerId = sc.nextLine();
					customerIdValidation = regExValidation.integerRegEx(customerId);
				}
				customerIdNumber = Integer.parseInt(customerId);
				

			Customer customer1 = services.searchUser(customerIdNumber);
				if(customer1 != null){
					System.out.println("Customer profile already exists");

				}
				else{
					customer.setCustomerId(customerIdNumber);

					System.out.println("Enter the Customer name: ");
					customer.setCustomerName(sc.nextLine());

					System.out.println("Enter the Street address1: ");
					customer.setStreetAddress1(sc.nextLine());

					System.out.println("Enter the Street address2: ");
					customer.setStreetAddress2(sc.nextLine());

					System.out.println("Enter the Town city: ");
					customer.setTownCity(sc.nextLine());

					System.out.println("Enter the Postcode: ");
					customer.setPostCode(sc.nextLine());

					System.out.println("Enter the Telephone: ");
					customer.setTelephoneNo(Integer.parseInt(sc.nextLine()));

					System.out.println("Enter the Email: ");
					String email =  sc.nextLine();
					customer.setEmail(email);
					boolean regExEmail = regExValidation.emailRegEx(email);
					while(regExEmail == false )
					{
						System.out.println("Enter correct Email");
						System.out.println("Enter the Email :");
						email =  sc.nextLine();
						regExEmail = regExValidation.emailRegEx(email);

					}
					customer.setEmail(email);

					System.out.println("Enter the Password: ");
					customer.setPassword(sc.nextLine());

					System.out.println("Profile creation: " + services.createProfile(customer));
					System.out.println(customer);
				}
				break;
			}

			case 2:
			{
				System.out.println("Enter Customer ID");
				int customerId=Integer.parseInt(sc.nextLine());
				Customer customer2 =services.searchUser(customerId);
				if(customer2 == null){
					System.out.println("Customer profile doesnot exists");
					throw new  DeletionFailedException("Customer deletion Failed ");
				}
				else{
					System.out.println("Customer deletion: " + services.deleteUser(customerId));
				}

				break;
			}

			case 3:
			{
				System.out.println("Enter Customer ID");
				int customerId=Integer.parseInt(sc.nextLine());
				Customer customer3 =services.searchUser(customerId);

				if(customer3 == null) {
					System.out.println("Customer profile doesnot exists");
					throw new SearchingFailedException("Customer Not Found");

				}else {
					System.out.println(customer3);
				}
				break;
			}

			case 4:
			{
				boolean states;
				System.out.println("Enter Customer ID");
				int customerId=Integer.parseInt(sc.nextLine());

				System.out.println("1. Modify telephone number");
				System.out.println("2. Modify Email");
				System.out.println("3. Modify Password");
				System.out.println("Enter your choise: ");
				choice = Integer.parseInt(sc.nextLine());

				switch(choice)
				{
				case 1:
				{
					System.out.println("Enter old telephone number ");
					int oldNmbr = Integer.parseInt(sc.nextLine());
					System.out.println("Enter new telephone number");
					int newNmbr = Integer.parseInt(sc.nextLine());
					states =  services.updateTelephone(customerId,oldNmbr, newNmbr);
					if(states)
						System.out.println("modified customer: " + services.searchUser(customerId) );
					else
						System.out.println("CustomerId do not match");
					break;
				}

				case 2:
				{
					System.out.println("Enter old Email ");
					String oldEmail = (sc.nextLine());
					System.out.println("Enter new Email");
					String newEmail = (sc.nextLine());
					states =  services.updateEmail(customerId,oldEmail, newEmail);
					if(states)
						System.out.println("modified customer: " + services.searchUser(customerId) );
					else
						System.out.println("old delivery date do not match");
					break;
				}

				case 3:
				{
					System.out.println("Enter old Password ");
					String oldId = (sc.nextLine());
					System.out.println("Enter new Password");
					String newId = (sc.nextLine());
					states =  services.updatePassword(customerId,oldId, newId);
					if(states)
						System.out.println("modified customer: " + services.searchUser(customerId) );
					else
						System.out.println("Old Password do not match");
					break;
				}
				default: System.out.println("Invalid option!!!!!");


				}

				Customer cont=services.searchUser(customerId);
				if(cont==null){
					System.out.println("Customer profile doesnot exists");

				}else {
					choice = 4;
				}

				break;
			}

			case 5:
			{
				loop =false;
				break;
			}

			default :
			{
				System.out.println("invalid choise!!!!!");
			}
			}
		}sc.close();
	}
}
