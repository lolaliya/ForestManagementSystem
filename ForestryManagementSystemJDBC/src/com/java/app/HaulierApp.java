package com.java.app;

import java.util.Scanner;

import com.java.beans.Haulier;
import com.java.exceptions.DeletionFailedException;
import com.java.exceptions.CreationFailedException;
import com.java.services.HaulierServices;
import com.java.services.HaulierServicesImpl;
import com.java.services.RegexValidation;

public class HaulierApp {
	static HaulierServices services = new HaulierServicesImpl();
	static RegexValidation rv = new RegexValidation(); 
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);

		Boolean loop = true;
		while(loop)	{
			System.out.println("1. Add Haulier");
			System.out.println("2. Delete Haulier");
			System.out.println("3. Exit");
			System.out.println("Enter your choice");
			int choice = Integer.parseInt(in.nextLine());
			
			Haulier haulier = new Haulier();
			System.out.println("Enter the haulier id :");
			String value = in.nextLine();
			boolean regExId = rv.integerRegEx(value);
			Integer idNumber=0;
			while(!regExId) {
				System.out.println("Integer value epected!!!");
				System.out.println("Re-enter the haulier id:");
				value = in.nextLine();
				regExId = rv.integerRegEx(value);
			}
			idNumber = Integer.parseInt(value);
			haulier.setHaulierId(idNumber);
			
			switch(choice)
			{
			case 1 :			// Add Haulier
			{
				System.out.println("Enter the haulier Name :");
				String haulierName = in.nextLine();
				boolean regExName = rv.stringRegEx(haulierName);
				while(!regExName){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the haulier Name");
					haulierName = in.nextLine();
					regExName = rv.stringRegEx(haulierName);
				}
				haulier.setHaulierName(haulierName);

				System.out.println("Enter the Street Address 1 :");
				haulier.setStreetAddress1(in.nextLine());

				System.out.println("Enter the Streeet Address 2 :");
				haulier.setStreetAddress2(in.nextLine());

				System.out.println("Enter the Town City :");
				String townCity = in.nextLine();
				boolean regExTownCity = rv.stringRegEx(townCity);
				while(!regExTownCity){
					System.out.println("String data expected!!!");
					System.out.println("Re-enter the town city:");
					townCity = in.nextLine();
					regExTownCity = rv.stringRegEx(townCity);
				}
				haulier.setTownCity(townCity);

				System.out.println("Enter the Post Code :");
				String postCode = in.nextLine();
				boolean regExPostCode = rv.integerRegEx(postCode);
				Integer postsCode=0;
				while(!regExPostCode) {
					System.out.println("Enter proper postcode!!!");
					postCode = in.nextLine();
					regExPostCode = rv.integerRegEx(postCode);
				}
				postsCode = Integer.parseInt(postCode);
				haulier.setPostCode(postsCode);

				System.out.println("Enter the Telephone no :");
				String telephone = in.nextLine();
				boolean regExTelephone = rv.telephoneRegEx(telephone);
				long telephoneNumber = 0;
				while(!regExTelephone) {
					System.out.println("Enter proper telephone number!!!");
					telephone = in.nextLine();
					regExTelephone = rv.telephoneRegEx(telephone);
				}
				telephoneNumber = Long.parseLong(telephone);
				haulier.setTelephoneNo(telephoneNumber);

				System.out.println("Enter the Email :");
				String email = in.nextLine();
				boolean regExEmail = rv.emailRegEx(email);
				while(!regExEmail) {
					System.out.println("Enter proper email id!!!");
					email = in.nextLine();
					regExEmail = rv.emailRegEx(email);
				}
				haulier.setEmail(email);
				
				haulier = services.addHaulier(haulier);

				if(haulier!=null) {
					System.out.println(haulier);
				}else {
					System.out.println("Profile creation failed");
					throw new CreationFailedException("Haulier profile creation failed");
				}
				break;
			}

			case 2 : 
			{
				System.out.println("Enter the Customer id :");
				value = in.nextLine();
				regExId = rv.integerRegEx(value);
				 idNumber=0;
				while(!regExId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExId = rv.integerRegEx(value);
				}
				idNumber = Integer.parseInt(value);
				int cid = idNumber;
				boolean deleteCustomer = services.deleteHaulier(cid);
				if(deleteCustomer) {
					System.out.println("Profile deletion successful");
				}else {
					System.out.println("Profile deletion failed");
					throw new DeletionFailedException("Haulier profile deletion failed");
				}
				break;
			}

			case 3: loop = false;
			break;
			default : System.out.println("Not a valid Option !!!!!!");
			}
		}
		in.close();
	}
}

