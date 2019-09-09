package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Haulier;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.HaulierCreationFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.exceptions.UpdationFailedException;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.RegExValidation;

public class HaulierApp {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		HaulierServices services = new HaulierServicesImpl();
		RegExValidation regExValidation = new RegExValidation();
		boolean loop = true;
		while(loop)
		{    
			System.out.println("--------------------------");
			System.out.println("1. Add haulier");
			System.out.println("2. Delete haulier");
			System.out.println("3. Search haulier");
			System.out.println("4. Modify haulier");
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
			case 1:			// Add profile
			{

				System.out.println("Enter Haulier ID");
				int no=Integer.parseInt(in.nextLine());

				Haulier haul=services.searchHaulier(no);
				if(haul!=null){
					System.out.println("haulier profile already exists");
				}
				else{
					Haulier haulier = new Haulier();
					haulier.setHaulierId(no);
					System.out.println("Enter the haulier Name: ");
					haulier.setHaulierName(in.nextLine());
					System.out.println("Enter Street address 1: ");
					haulier.setStreetAddress1(in.nextLine());
					System.out.println("Enter Street address 2: ");
					haulier.setStreetAddress2(in.nextLine());
					System.out.println("Enter post code: ");
					haulier.setPostCode(Integer.parseInt(in.nextLine()));
					System.out.println("Enter towncity: ");
					haulier.setTownCity(in.nextLine());
					System.out.println("enter telepone number: ");
					haulier.setTelephoneNo(Long.parseLong(in.nextLine()));
					System.out.println("Enter email: ");
					haulier.setEmail(in.nextLine());
					System.out.println("Enter password: ");
					haulier.setPassword(in.nextLine());
					System.out.println(haulier);
					boolean state = services.addHaulier(haulier);
					if(state)
					{
						System.out.println(services.searchHaulier(no));
					}else{
						System.out.println("Profile creation failed");
						throw new HaulierCreationFailedException("Haulier Creation Failed Exception!!!  ");
					}
				}
				break;
			}

			case 2:					// Delete profile
			{
				System.out.println("Enter Haulier ID");
				int no=Integer.parseInt(in.nextLine());
				Haulier haulier=services.searchHaulier(no);
				if(haulier==null){
					System.out.println("Haulier profile doesnot exists");
					throw new DeletionFailedException("Delition failed Exception!!! ");
				}
				else{
					System.out.println("Haulier deletion: " + services.deleteHaulier(no));
				}

				break;
			}

			case 3:				// Search profile
			{
				System.out.println("Enter Haulier ID");
				int no=Integer.parseInt(in.nextLine());
				Haulier haulier=services.searchHaulier(no);

				if(haulier==null) {
					System.out.println("Haulier profile doesnot exists");
					throw new SearchingFailedException(" Haulier Search failed Exception!!! ");
				}else {
					System.out.println(haulier);
				}
				choise = 4;
				break;
			}

			case 4:					// Modify profile
			{
				System.out.println("Enter Haulier ID");
				int no=Integer.parseInt(in.nextLine());
				Haulier haulier = services.searchHaulier(no);
				if(haulier==null){
					System.out.println("Haulier profile doesnot exists");
					throw new UpdationFailedException("Haulier Updation failed Exception !!! ");

				}else {
					boolean states = false;
					int option;

					System.out.println("---------------------------");
					System.out.println("1. Modify Telephone number");
					System.out.println("2. Modify Email");
					System.out.println("3. Modify Password");
					System.out.println("------------------------------");

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


					int haulierId = no;

					switch(option)
					{


					case 1:			//Modify telephone number
					{
						System.out.println("Enter new Number");
						long newNumber = Long.parseLong(in.nextLine());
						states =  services.updateTelephone( haulierId,  newNumber) ;
						System.out.println("modified haulier: " + services.searchHaulier(haulierId) );
						break;
					}


					case 2:			// Modify Email
					{
						System.out.println("Enter new E-mail");
						String email = (in.nextLine());
						states =  services.updateEmail( haulierId,  email);
						System.out.println("modified haulier: " + services.searchHaulier(haulierId) );
						break;
					}

					case 3:			// Modify password
					{
						System.out.println("Enter new Password ");
						String passwd = (in.nextLine());
						states =  services.updatePassword(haulierId,  passwd);
						System.out.println("modified haulier: " + services.searchHaulier(haulierId) );
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
