package com.fms.app;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.fms.beans.Contract;
import com.fms.beans.Customer;
import com.fms.beans.Haulier;
import com.fms.beans.Product;
import com.fms.exceptions.ContractCreationFailedException;
import com.fms.exceptions.DeletionFailedException;
import com.fms.exceptions.SearchingFailedException;
import com.fms.exceptions.UpdationFailedException;
import com.fms.services.ContractServices;
import com.fms.services.ContractServicesImpl;
import com.fms.services.CustomerServices;
import com.fms.services.CustomerServicesImpl;
import com.fms.services.HaulierServices;
import com.fms.services.HaulierServicesImpl;
import com.fms.services.OrderServicesImpl;
import com.fms.services.ProductServices;
import com.fms.services.ProductServicesImpl;
import com.fms.services.RegExValidation;

public class ContractApp 
{
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(System.in);
		ContractServices services = new ContractServicesImpl();
		CustomerServices services1 = new CustomerServicesImpl(); 
		ProductServices services2 = new ProductServicesImpl();
		HaulierServices services3 = new HaulierServicesImpl();
		RegExValidation regExValidation = new RegExValidation();
		new OrderServicesImpl(); 

		boolean loop = true;
		while(loop)
		{
			System.out.println("--------------------------");
			System.out.println("1. Add Contractor");
			System.out.println("2. Delete Contractor");
			System.out.println("3. Search Contractor");
			System.out.println("4. Modify Contractor");
			System.out.println("5. Exit");
			System.out.println("-----------------------------");

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


			switch(choice)
			{
			case 1:			// Add profile
			{

				System.out.println("Enter Contractor ID");
				String contractId = in.nextLine();
				boolean contractValidation = regExValidation.integerRegEx(contractId); //check for regEx validation
				while(!contractValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the contractNo : ");
					contractId = in.nextLine();
					contractValidation = regExValidation.integerRegEx(contractId);
				}
				int no  = Integer.parseInt(contractId);
				Contract cont=services.searchContract(no);
				if(cont!=null){
					System.out.println("Contractor profile already exists");
					throw new ContractCreationFailedException("Contract creation failed!!! "); 
				}
				else{
					Contract contract = new Contract();

					contract.setContractNo(no);

					System.out.println("Enter the Customer Id: ");
					int customerId = Integer.parseInt(in.nextLine());
					List<Customer> customers = new ArrayList<Customer>();
					customers.add(services1.searchCustomer(customerId));
					contract.setCustomers(customers);

					System.out.println("Enter the Product Id: ");
					int productId = Integer.parseInt(in.nextLine());
					List<Product> products = new ArrayList<Product>();
					products.add(services2.searchProduct(productId));
					contract.setProducts(products);

					System.out.println("Enter the Haulier Id: ");
					int haulierId = Integer.parseInt(in.nextLine());
					List<Haulier> hauliers = new ArrayList<Haulier>();
					hauliers.add(services3.searchHaulier(haulierId));
					contract.setHauliers(hauliers);

					System.out.println("Enter the Delivery Date: ");
					String tempDate = in.nextLine();
					contract.setDeliveryDate(Date.valueOf(tempDate));

					System.out.println("Enter the Delivery Day: ");
					contract.setDeliveryDay(in.nextLine());

					System.out.println("Enter password: ");
					contract.setPassword(in.nextLine());

					boolean state = services.addContract(contract);
					if(state)
					{
						System.out.println(services.searchContract(no));
					}else{
						System.out.println("Profile creation failed");
					}
				}

				break;
			}

			case 2:			//Delete profile
			{
				System.out.println("Enter Contractor ID");
				String contractId = in.nextLine();
				boolean contractValidation = regExValidation.integerRegEx(contractId); //check for regEx validation
				while(!contractValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the contractNo : ");
					contractId = in.nextLine();
					contractValidation = regExValidation.integerRegEx(contractId);
				}
				int no  = Integer.parseInt(contractId);
				Contract cont=services.searchContract(no);
				if(cont==null){
					System.out.println("Contractor profile doesnot exists");
					throw new DeletionFailedException("Deletion failed Exception!!! ");
				}
				else{
					System.out.println("Contractor deletion: " + services.deleteContract(no));
				}
				break;
			}

			case 3:			// Search profile
			{

				System.out.println("Enter Contractor ID");
				String contractId = in.nextLine();
				boolean contractValidation = regExValidation.integerRegEx(contractId); //check for regEx validation
				while(!contractValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the contractNo : ");
					contractId = in.nextLine();
					contractValidation = regExValidation.integerRegEx(contractId);
				}
				int no  = Integer.parseInt(contractId);
				Contract cont=services.searchContract(no);

				if(cont==null) {
					System.out.println("Contractor profile doesnot exists");
					throw new SearchingFailedException("Search failed Exception!!! ");
				}else {
					System.out.println(cont);
				}
				break;
			}

			case 4:			// Modify profile
			{

				System.out.println("Enter Contractor ID");
				String contractId = in.nextLine();
				boolean contractValidation = regExValidation.integerRegEx(contractId); //check for regEx validation
				while(!contractValidation) {
					System.out.println("Integer value Expected !!!");
					System.out.println("Re-enter the contractNo : ");
					contractId = in.nextLine();
					contractValidation = regExValidation.integerRegEx(contractId);
				}
				int no  = Integer.parseInt(contractId);
				Contract cont=services.searchContract(no);
				if(cont==null){
					System.out.println("Contractor profile doesnot exists");
					throw new UpdationFailedException("Updation Not Possible!!! ");

				}else {
					boolean states = false;
					int option;
					System.out.println("----------------------------");
					System.out.println("1. Modify Delivery Day");
					System.out.println("2. Modify Password");
					System.out.println("-----------------------------");

					System.out.println("Enter your choice:");
					String modifyChoice = in.nextLine();
					boolean modifyValidation = regExValidation.integerRegEx(modifyChoice);
					while(!modifyValidation) {
						System.out.println("Integer value Expected !!!");
						System.out.println("Re-enter your choice : ");
						modifyChoice = in.nextLine();
						modifyValidation = regExValidation.integerRegEx(modifyChoice);
					}
					option = Integer.parseInt(modifyChoice);

					switch(option)
					{

					case 1:
					{
						System.out.println("Enter new Delivery Day");
						String newDay = (in.nextLine());
						states =  services.updateDeliveryDay(no, newDay);
						System.out.println("modified contractor: " + services.searchContract(no) );
						break;
					}

					case 2:
					{
						System.out.println("Enter Password ");
						String passwd = (in.nextLine());
						states =  services.updatePassword(no,  passwd);
						System.out.println("modified contractor: " + services.searchContract(no) );
						break;
					}
					default: System.out.println("Invalid option!!!!!");
					}
					System.out.println("Modification: "+states);
				}
			}
			break;
			case 5: 					// Exit
				loop = false;
				break;

			default :
			{
				System.out.println("invalid choice!!!!!");
			}
			}

		}

		in.close();
	}
}


