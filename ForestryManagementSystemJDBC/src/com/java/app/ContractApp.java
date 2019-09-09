package com.java.app;

import java.sql.Date;
import java.util.Scanner;
import com.java.beans.Contract;
import com.java.exceptions.CreationFailedException;
import com.java.exceptions.DeletionFailedException;
import com.java.services.ContractServices;
import com.java.services.ContractServicesImpl;
import com.java.services.RegexValidation;

public class ContractApp {
	static RegexValidation regExValidation = new RegexValidation();
	public static void main(String[] args) throws Exception {
		boolean loop = true;
		ContractServices services = new ContractServicesImpl();
		Scanner in = new Scanner(System.in);
		while(loop){
			System.out.println("1. AddContractor");
			System.out.println("2. DeleteContractor");
			System.out.println("3. Exit");

			System.out.println("Enter your choice");
			String values = in.nextLine();
			boolean regExChoise = regExValidation.integerRegEx(values);
			while(!regExChoise) {
				System.out.println("Integer value epected!!!");
				System.out.println("Re-enter your choise:");
				values = in.nextLine();
				regExChoise = regExValidation.integerRegEx(values);
			}
			Integer choice = Integer.parseInt(values);

			switch(choice)
			{
			case 1 :
				Contract contract = new Contract();
				System.out.println("Enter the Contract No :");
				values = in.nextLine();
				boolean regExId = regExValidation.integerRegEx(values);
				while(!regExId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter your choise:");
					values = in.nextLine();
					regExId = regExValidation.integerRegEx(values);
				}
				Integer contNo = Integer.parseInt(values);
				contract.setContractNo(contNo);

				System.out.println("Enter the Customer id :");
				values = in.nextLine();
				boolean regExCustId = regExValidation.integerRegEx(values);
				Integer custId=0;
				while(!regExCustId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					values = in.nextLine();
					regExCustId = regExValidation.integerRegEx(values);
				}
				custId = Integer.parseInt(values);
				contract.setCustomerId(custId);

				System.out.println("Enter the Product Id :");
				String value = in.nextLine();
				boolean regExProdId = regExValidation.integerRegEx(value);
				Integer prodId = 0;
				while(!regExProdId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the product id:");
					value = in.nextLine();
					regExProdId = regExValidation.integerRegEx(value);
				}
				prodId  = Integer.parseInt(value);
				contract.setProductId(prodId);

				System.out.println("Enter the Haulier Id :");
				value = in.nextLine();
				boolean regExHaulId = regExValidation.integerRegEx(value);
				Integer haulId = 0;
				while(!regExHaulId) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the haulier id:");
					value = in.nextLine();
					regExHaulId = regExValidation.integerRegEx(value);
				}
				haulId  = Integer.parseInt(value);

				contract.setHaulierId(haulId);

				System.out.println("Enter the Delivery Date :");
				String tempDate = in.nextLine();
				contract.setDeliveryDate(Date.valueOf(tempDate));

				System.out.println("Enter the Delivery Day :");
				contract.setDeliveryDay(in.nextLine());

				System.out.println("Enter the Quantity Required :");
				value = in.nextLine();
				boolean regExQuantity = regExValidation.integerRegEx(value);
				Integer quantity = 0;
				while(!regExQuantity) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the quantity :");
					value = in.nextLine();
					regExQuantity = regExValidation.integerRegEx(value);
				}
				quantity  = Integer.parseInt(value);
				contract.setQuantity(quantity);

				Contract addContract = services.addContractor(contract);
				if(addContract!=null) {
					System.out.println(addContract);
				}else {
					System.out.println("Profile creation failed");
					throw new CreationFailedException("Contract profile creation failed");
				}
				break;

			case 2 : 
				System.out.println("Enter the Contractor No :");
				value = in.nextLine();
				boolean regExcontNo = regExValidation.integerRegEx(value);
				Integer contractNumber = 0;
				while(!regExcontNo) {
					System.out.println("Integer value epected!!!");
					System.out.println("Re-enter the customer id:");
					value = in.nextLine();
					regExcontNo = regExValidation.integerRegEx(value);
				}
				contractNumber  = Integer.parseInt(value);
				boolean delContract = services.deleteContractor(contractNumber);
				if(delContract) {
					System.out.println("Profile deletion:" + delContract);
				}else {
					System.out.println("Profile creation failed");
					throw new DeletionFailedException("Contract profile deletion failed");
				}
				break;

			case 3: loop = false;
			break;
			default : System.out.println("Not a valid Option !!!!!!");
			}
		}
		in.close();
	}


}
