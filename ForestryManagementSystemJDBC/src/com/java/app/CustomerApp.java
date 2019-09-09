package com.java.app; 

import java.util.Scanner;

import com.java.exceptions.CreationFailedException;
import com.java.exceptions.DeletionFailedException;
import com.java.exceptions.UpdationFailedException;
import com.java.services.CustomerServices;
import com.java.services.CustomerServicesImpl;
import com.java.services.RegexValidation;
import com.java.beans.Customer;

public class CustomerApp {

	static RegexValidation regexValid = new RegexValidation(); 

	public static void main(String[] args) throws Exception{
		Customer customer = new Customer();
		Customer customer1 = new Customer();
		CustomerServices services = new CustomerServicesImpl();
		Scanner in = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("1. AddCustomer");
			System.out.println("2. ModifyCustomer");
			System.out.println("3. DeleteCustomer");
			System.out.println("4. Exit");

			System.out.println("Enter your choice");
			String values = in.nextLine();
			boolean regExChoise = regexValid.integerRegEx(values);
			while(!regExChoise) {
				System.out.println("Integer value epected!!!");
				System.out.println("Re-enter your choise:");
				values = in.nextLine();
				regExChoise = regexValid.integerRegEx(values);
			}
			Integer choise = Integer.parseInt(values);

			switch(choise)
			{
			case 1 :
			{

				System.out.println("Enter the Customer id :");
				String value = in.nextLine();
				boolean regExId = regexValid.integerRegEx(value);
				Integer idNumber=0;
				while(!regExId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExId = regexValid.integerRegEx(value);
				}
				idNumber = Integer.parseInt(value);
				customer.setCustomerId(idNumber);

				System.out.println("Enter the Customer Name :");
				String customerName = in.nextLine();
				boolean regExName = regexValid.stringRegEx(customerName);
				while(!regExName){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					customerName = in.nextLine();
					regExName = regexValid.stringRegEx(customerName);
				}
				customer.setCustomerName(customerName);

				System.out.println("Enter the Street Address 1 :");
				customer.setStreetAddress1(in.nextLine());

				System.out.println("Enter the Streeet Address 2 :");
				customer.setStreetAddress2(in.nextLine());

				System.out.println("Enter the Town City :");
				String townCity = in.nextLine();
				boolean regExTownCity = regexValid.stringRegEx(townCity);
				while(!regExTownCity){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the town city:");
					townCity = in.nextLine();
					regExTownCity = regexValid.stringRegEx(townCity);
				}
				customer.setTownCity(townCity);

				System.out.println("Enter the Post Code :");
				String postCode = in.nextLine();
				boolean regExPostCode = regexValid.integerRegEx(postCode);
				Integer postsCode=0;
				while(!regExPostCode) {
					System.out.println("Enter proper postcode!!!");
					postCode = in.nextLine();
					regExPostCode = regexValid.integerRegEx(postCode);
				}
				postsCode = Integer.parseInt(postCode);
				customer.setPostCode(postsCode);

				System.out.println("Enter the Telephone no :");
				String telephone = in.nextLine();
				boolean regExTelephone = regexValid.telephoneRegEx(telephone);
				long telephoneNumber = 0;
				while(!regExTelephone) {
					System.out.println("Enter proper telephone number!!!");
					telephone = in.nextLine();
					regExTelephone = regexValid.telephoneRegEx(telephone);
				}
				telephoneNumber = Long.parseLong(telephone);
				customer.setTelephoneNo(telephoneNumber);

				System.out.println("Enter the Email :");
				String email = in.nextLine();
				boolean regExEmail = regexValid.emailRegEx(email);
				while(!regExEmail) {
					System.out.println("Enter proper email id!!!");
					email = in.nextLine();
					regExEmail = regexValid.emailRegEx(email);
				}
				customer.setEmail(email);

				System.out.println("Enter the Customer password (The password length should be minimum 4 charecters and can be upto 8 charecters) :");
				String password = in.nextLine();
				boolean regExPassword = regexValid.passwordRegEx(password);
				while(!regExPassword) {
					System.out.println("Enter proper password as per given criteria!!!");
					password = in.nextLine();
					regExPassword = regexValid.passwordRegEx(password);
				}
				customer.setPassword(password);
				customer = services.addCustomer(customer);

				if(customer!=null) {
					System.out.println(customer);
				}else {
					System.out.println("Profile creation failed");
					throw new CreationFailedException("Customer profile creation failed");
				}
				break;
			}

			case 2:
			{
				System.out.println("Enter the Customer id :");
				String value = in.nextLine();
				boolean regExId = regexValid.integerRegEx(value);
				Integer idNumber=0;
				while(!regExId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExId = regexValid.integerRegEx(value);
				}
				idNumber = Integer.parseInt(value);
				customer1.setCustomerId(idNumber);

				System.out.println("Enter the Customer Name :");
				String customerName = in.nextLine();
				boolean regExName = regexValid.stringRegEx(customerName);
				while(!regExName){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the Customer Name");
					customerName = in.nextLine();
					regExName = regexValid.stringRegEx(customerName);
				}
				customer1.setCustomerName(customerName);

				System.out.println("Enter the Street Address 1 :");
				customer1.setStreetAddress1(in.nextLine());

				System.out.println("Enter the Streeet Address 2 :");
				customer1.setStreetAddress2(in.nextLine());

				System.out.println("Enter the Town City :");
				String townCity = in.nextLine();
				boolean regExTownCity = regexValid.stringRegEx(townCity);
				while(!regExTownCity){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the town city:");
					townCity = in.nextLine();
					regExTownCity = regexValid.stringRegEx(townCity);
				}
				customer1.setTownCity(townCity);

				System.out.println("Enter the Post Code :");
				String postCode = in.nextLine();
				boolean regExPostCode = regexValid.integerRegEx(postCode);
				Integer postsCode=0;
				while(!regExPostCode) {
					System.out.println("Enter proper postcode!!!");
					postCode = in.nextLine();
					regExPostCode = regexValid.integerRegEx(postCode);
				}
				postsCode = Integer.parseInt(postCode);
				customer1.setPostCode(postsCode);

				System.out.println("Enter the Telephone no :");
				String telephone = in.nextLine();
				boolean regExTelephone = regexValid.telephoneRegEx(telephone);
				while(!regExTelephone) {
					System.out.println("Enter proper telephone number!!!");
					telephone = in.nextLine();
					regExTelephone = regexValid.telephoneRegEx(telephone);
				}
				long telephoneNumber = Long.parseLong(telephone);
				customer1.setTelephoneNo(telephoneNumber);

				System.out.println("Enter the Email :");
				String email = in.nextLine();
				boolean regExEmail = regexValid.emailRegEx(email);
				while(!regExEmail) {
					System.out.println("Enter proper email id!!!");
					email = in.nextLine();
					regExEmail = regexValid.emailRegEx(email);
				}
				customer1.setEmail(email);

				System.out.println("Enter the Customer password (The password length should be minimum 4 charecters and can be upto 8 charecters) :");
				String password = in.nextLine();
				boolean regExPassword = regexValid.passwordRegEx(password);
				while(!regExPassword) {
					System.out.println("Enter proper password as per given criteria!!!");
					password = in.nextLine();
					regExPassword = regexValid.passwordRegEx(password);
				}
				customer1.setPassword(password);
				customer1 = services.modifyCustomer(customer1,customer1.getCustomerId());
				if(customer1!=null) {
					System.out.println(customer1);
				}else {
					System.out.println("Profile updation failed");
					throw new UpdationFailedException("Customer profile updation failed");
				}
				break;
			}

			case 3 : 
			{
				System.out.println("Enter the Customer id :");
				String value = in.nextLine();
				boolean regExId = regexValid.integerRegEx(value);
				Integer idNumber=0;
				while(!regExId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExId = regexValid.integerRegEx(value);
				}
				idNumber = Integer.parseInt(value);
				int cid = idNumber;

				System.out.println("Enter the Password :");
				String password = in.nextLine();
				boolean regExPassword = regexValid.passwordRegEx(password);
				while(!regExPassword) {
					System.out.println("Enter proper password as per given criteria!!!");
					password = in.nextLine();
					regExPassword = regexValid.passwordRegEx(password);
				}
				String newPassword = password;
				boolean deleteCustomer = services.deleteCustomer(cid, newPassword);
				if(deleteCustomer) {
					System.out.println("Profile deletion successful");
				}else {
					System.out.println("Profile deletion failed");
					throw new DeletionFailedException("Customer profile deletion failed");
				}
				break;
			}

			case 4: loop = false;
			break;
			default : System.out.println("Not a valid Option !!!!!!");
			}
		}
		in.close();
	}
}
