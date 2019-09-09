package com.fms.repo;

import java.util.HashMap;
import com.fms.beans.Contract;
import com.fms.beans.Customer;

public class CustomerRepository {
	public static HashMap<Integer, Customer> db = new HashMap<>();

	public CustomerRepository(){
		Customer user1 = new Customer();
		user1.setCustomerId(1);
		user1.setCustomerName("Ajay");
		user1.setStreetAddress1("#44 1st Avennue");
		user1.setStreetAddress2("Pasadena");
		user1.setTownCity("Bangalore");
		user1.setPostCode("B0010");
		user1.setTelephoneNo(165161);
		user1.setEmail("xyz@abc.com");
		user1.setPassword("root");
		db.put(1, user1);

		Customer user2 = new Customer();
		user2.setCustomerId(2);
		user2.setCustomerName("Ajith");
		user2.setStreetAddress1("#212 2nd Avennue");
		user2.setStreetAddress2("Srirampura");
		user2.setTownCity("Bangalore");
		user2.setPostCode("B0010");
		user2.setTelephoneNo(12255);
		user2.setEmail("def@abc.com");
		user2.setPassword("root");
		db.put(2, user2);

		Customer user3 = new Customer();
		user3.setCustomerId(3);
		user3.setCustomerName("Akriti");
		user3.setStreetAddress1("#421 3rd Avennue");
		user3.setStreetAddress2("Dallas");
		user3.setTownCity("Bangalore");
		user3.setPostCode("B0010");
		user3.setTelephoneNo(5151515);
		user3.setEmail("ghi@abc.com");
		user3.setPassword("root");
		db.put(3, user3);
	}
}