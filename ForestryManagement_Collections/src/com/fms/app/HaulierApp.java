package com.fms.app;

import java.util.Scanner;
import com.fms.beans.Haulier;
import com.fms.exceptions.HaulierCreationFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.RegexValidation;

public class HaulierApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RegexValidation regExValidation = new RegexValidation();
		HaulierServices services = new HaulierServicesImpl();
		Boolean loop = true;
		while(loop)
		{
			System.out.println("-----------------------");
			System.out.println("1. Add Haulier");
			System.out.println("2. Delete Haulier");
			System.out.println("3. Search Haulier");
			System.out.println("4. Modify Haulier");
			System.out.println("5. Exit");
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
				System.out.println("Enter Haulier ID");
				String haulierId = sc.nextLine();
				boolean haulierIdValidation = regExValidation.integerRegEx(haulierId);
				Integer haulierNumber = 0;
				while(!haulierIdValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the customer Id : ");
					haulierId = sc.nextLine();
					haulierIdValidation = regExValidation.integerRegEx(haulierId);
				}
				haulierNumber = Integer.parseInt(haulierId);

				Haulier haul = services.searchUser(haulierNumber);
				if(haul!= null){
					System.out.println("Haulier profile already exists");

				}
				else{
					Haulier haulier = new Haulier();
					haulier.setHaulierId(haulierNumber);

					System.out.println("Enter the Haulier name: ");
					haulier.setHaulierName(sc.nextLine());

					System.out.println("Enter the Street address1: ");
					haulier.setStreetAddress1(sc.nextLine());

					System.out.println("Enter the Street address2: ");
					haulier.setStreetAddress2(sc.nextLine());

					System.out.println("Enter the Town city: ");
					haulier.setTownCity(sc.nextLine());

					System.out.println("Enter the Postcode: ");
					haulier.setPostCode(sc.nextLine());

					System.out.println("Enter the Telephone: ");
					haulier.setTelephoneNo(Integer.parseInt(sc.nextLine()));

					System.out.println("Enter the Email: ");
					String email =  sc.nextLine();
					haulier.setEmail(email);
					boolean regExEmail = regExValidation.emailRegEx(email);
					while(regExEmail == false )
					{
						System.out.println("Enter correct Email");
						System.out.println("Enter the Email :");
						email =  sc.nextLine();
						regExEmail = regExValidation.emailRegEx(email);

					}
					haulier.setEmail(email);

					System.out.println("Profile creation: " + services.createProfile(haulier));
					System.out.println(haulier);
				}

				break;
			}

			case 2:
			{
				System.out.println("Enter Haulier ID");
				int no=Integer.parseInt(sc.nextLine());
				Haulier haul=services.searchUser(no);
				if(haul==null){
					System.out.println("Haulier profile doesnot exists");
					throw new HaulierCreationFailedException("Haulier doesnot found");
				}
				else{
					System.out.println("Haulier deletion: " + services.deleteUser(no));
				}
				break;
			}

			case 3:
			{
				System.out.println("Enter Haulier ID");
				int haulierId=Integer.parseInt(sc.nextLine());
				Haulier haulier=services.searchUser(haulierId);

				if(haulier==null) {
					System.out.println("Haulier profile doesnot exists");
					throw new SearchingFailedException("Haulier doesnot Exits");
				}else {
					System.out.println(haulier);
				}

				break;
			}

			case 4:
			{
				boolean states;
				System.out.println("Enter Haulier ID");
				int haulierId=Integer.parseInt(sc.nextLine());

				System.out.println("1. Modify telephone number");
				System.out.println("2. Modify Email");
				System.out.println("Enter your choice: ");
				choice = Integer.parseInt(sc.nextLine());

				switch(choice)
				{
				case 1:
				{
					System.out.println("Enter old telephone number ");
					int oldNmbr = Integer.parseInt(sc.nextLine());
					System.out.println("Enter new telephone number");
					int newNmbr = Integer.parseInt(sc.nextLine());
					states =  services.updateTelephone(haulierId,oldNmbr, newNmbr);
					if(states)
						System.out.println("modified Haulier: " + services.searchUser(haulierId) );
					else
						System.out.println("Telephone number do not match");
					break;
				}

				case 2:
				{
					System.out.println("Enter old Email ");
					String oldEmail = (sc.nextLine());
					System.out.println("Enter new Email");
					String newEmail = (sc.nextLine());
					states =  services.updateEmail(haulierId,oldEmail, newEmail);
					if(states)
						System.out.println("modified Haulier: " + services.searchUser(haulierId) );
					else
						System.out.println("Email do not match");
					break;
				}
				default: System.out.println("Invalid option!!!!!");
				}
				Haulier cont=services.searchUser(haulierId);
				if(cont==null){
					System.out.println("Haulier profile doesnot exists");
				}

				break;
			}

			case 5 :
			{
				loop = false;
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

