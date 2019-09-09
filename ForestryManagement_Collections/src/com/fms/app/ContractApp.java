package com.fms.app;

import java.util.Scanner;

import com.fms.beans.Contract;
import com.fms.exceptions.ContractCreationFailedException;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.services.ContractServices;
import com.fms.services.ContractServicesImpl;
import com.fms.services.RegexValidation;

public class ContractApp {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		RegexValidation regExValidation = new RegexValidation();
		ContractServices services = new ContractServicesImpl();
		Contract contract = new Contract();
		boolean loop = true;
		while(loop)
		{   System.out.println("----------------------------");
		System.out.println("1. Add Contractor");
		System.out.println("2. Delete Contractor");
		System.out.println("3. Search Contractor");
		System.out.println("4. Modify Contractor");
		System.out.println("5. Exit");
		System.out.println("----------------------------");

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
			System.out.println("Enter Contractor No");
			String contractNo = sc.nextLine();
			boolean contractIdValidation = regExValidation.integerRegEx(contractNo);
			Integer contractId = 0;
			while(!contractIdValidation) {
				System.out.println("Integer value Expected !!!");
				System.out.println("Re-enter the Contractor No : ");
				contractNo = sc.nextLine();
				contractIdValidation = regExValidation.integerRegEx(contractNo);
			}
			contractId = Integer.parseInt(contractNo);
			Contract contract1 = services.searchUser(contractId);

			if(contract1 != null){
				System.out.println("Contractor profile already exists");
				throw new ContractCreationFailedException("Contractor Updation Failed");
			}
			else{
				contract.setContractNo(contractId);
				System.out.println("Enter the Password: ");
				contract.setPassword(sc.nextLine());


				System.out.println("Enter the Customer Id: ");
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
				contract.setCustomerId(customerIdNumber);


				System.out.println("Enter the Product Id: ");
				String productId = sc.nextLine();
				boolean productIdValidation = regExValidation.integerRegEx(productId);
				Integer productNumber = 0;
				while(!productIdValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the Product Id : ");
					productId = sc.nextLine();
					productIdValidation = regExValidation.integerRegEx(productId);
				}
				productNumber = Integer.parseInt(productId);
				contract.setProductId(productNumber);


				System.out.println("Enter the Haulier Id: ");
				String haulierId = sc.nextLine();
				boolean haulierIdValidation = regExValidation.integerRegEx(haulierId);
				Integer haulierNumber = 0;
				while(!haulierIdValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the Haulier Id : ");
					haulierId = sc.nextLine();
					haulierIdValidation = regExValidation.integerRegEx(haulierId);
				}
				haulierNumber = Integer.parseInt(haulierId);
				contract.setHaulierId(haulierNumber);


				System.out.println("Enter the Delivery Date: ");
				contract.setDeliveryDate(sc.nextLine());


				System.out.println("Enter the Delivery Day: ");
				contract.setDeliveryDay(sc.nextLine());


				System.out.println("Enter the Quantity: ");
				String quantity = sc.nextLine();
				boolean quantityValidation = regExValidation.integerRegEx(quantity);
				Integer quantityValue = 0;
				while(!quantityValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the quantity : ");
					quantity = sc.nextLine();
					quantityValidation = regExValidation.integerRegEx(quantity);
				}
				quantityValue = Integer.parseInt(quantity);
				contract.setQuantity(quantityValue);


				if (contract!=null) {
					System.out.println("Profile creation: " + services.createProfile(contract));
					System.out.println(contract);
				}
			}
		}
		break; 

		case 2:
		{
			System.out.println("Enter Contractor ID");
			int contractId = Integer.parseInt(sc.nextLine());
			Contract contract2 = services.searchUser(contractId);
			if(contract2 == null){
				System.out.println("Contractor profile doesnot exists");
				throw new  DeletionFailedException("Contractor deletion Failed ");
			}
			else{
				System.out.println("Contractor deletion: " + services.deleteUser(contractId));
			}
			break;
		}


		case 3:
		{
			System.out.println("Enter Contractor ID");
			int contractId=Integer.parseInt(sc.nextLine());
			Contract contract3=services.searchUser(contractId);

			if(contract3==null) {
				System.out.println("Contractor profile doesnot exists");
				throw new SearchingFailedException("Contractor Not Found");
			}else {
				System.out.println(contract3);
			}
			break;
		}

		case 4:
		{   
			boolean states;
			System.out.println("Enter Contractor ID");
			int userId=Integer.parseInt(sc.nextLine());

			System.out.println("1. Modify CustomerId");
			System.out.println("2. Modify HaulierId");
			System.out.println("3. Modify ProductId");
			System.out.println("4. Modify Delivery Date");
			System.out.println("5. Modify Delivery Day");
			System.out.println("6. Modify Quantity");
			System.out.println("7. Modify Password");
			System.out.println("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			switch(choice)
			{
			case 1:
			{
				System.out.println("Enter old CustomerId ");
				int oldId = Integer.parseInt(sc.nextLine());
				System.out.println("Enter new CustomerId");
				int newId = Integer.parseInt(sc.nextLine());
				states = services.updateCustomerId(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("CustomerId do not match");
				break;
			}

			case 2:
			{
				System.out.println("Enter old HaulierId ");
				int oldId = Integer.parseInt(sc.nextLine());
				System.out.println("Enter new HaulierId");
				int newId = Integer.parseInt(sc.nextLine());
				states =  services.updateHaulierId(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("HaulierId do not match");
				break;
			}

			case 3:
			{
				System.out.println("Enter old ProductId ");
				int oldId = Integer.parseInt(sc.nextLine());
				System.out.println("Enter new ProductId");
				int newId = Integer.parseInt(sc.nextLine());
				states =  services.updateProductId(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("Product Id do not match");
				break;
			}

			case 4:
			{
				System.out.println("Enter old Delivery Date ");
				String oldId = (sc.nextLine());
				System.out.println("Enter new Delivery Date");
				String newId = (sc.nextLine());
				states = services.updateDeliveryDate(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " +services.searchUser(userId) );
				else
					System.out.println("old delivery date do not match");	
				break;
			}

			case 5:
			{
				System.out.println("Enter old Delivery Day ");
				String oldId = (sc.nextLine());
				System.out.println("Enter new Delivery Day");
				String newId = (sc.nextLine());
				states =  services.updateDeliveryDay(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("Old Delivery day do not match");
				break;
			}

			case 6:
			{
				System.out.println("Enter old Quantity ");
				int oldId = Integer.parseInt(sc.nextLine());
				System.out.println("Enter new Quantity");
				int newId = Integer.parseInt(sc.nextLine());
				states = services.updateQuantity(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("Old Quantity do not match");
				break;
			}

			case 7:
			{
				System.out.println("Enter old Password ");
				String oldId = (sc.nextLine());
				System.out.println("Enter new Password");
				String newId = (sc.nextLine());
				states =  services.updatePassword(userId,oldId, newId);
				if(states)
					System.out.println("modified contractor: " + services.searchUser(userId) );
				else
					System.out.println("Password do not match");
				break;
			}

			default: System.out.println("Invalid option!!!!!");
			}

			Contract cont=services.searchUser(userId);
			if(cont==null){
				System.out.println("Contractor profile doesnot exists");

			}break;
		}

		case 5: loop = false;
		break;

		default :
		{
			System.out.println("invalid choise!!!!!");
		}
		}
		}
		sc.close();
	}
}
