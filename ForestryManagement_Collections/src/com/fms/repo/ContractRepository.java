package com.fms.repo;

import java.util.HashMap;
import com.fms.beans.Contract;

public class ContractRepository {
	public static HashMap<Integer, Contract> db = new HashMap<>();

	public ContractRepository(){
		Contract user1 = new Contract();
		user1.setContractNo(1);
		user1.setCustomerId(1);
		user1.setHaulierId(1);
		user1.setDeliveryDate("25-03-2019");
		user1.setDeliveryDay("tuesday");
		user1.setProductId(1);
		user1.setQuantity(356);
		user1.setPassword("root");
		db.put(1, user1);

		Contract user2 = new Contract();
		user2.setContractNo(2);
		user2.setCustomerId(2);
		user2.setHaulierId(2);
		user2.setDeliveryDate("31-05-1999");
		user2.setDeliveryDay("wednesday");
		user2.setProductId(2);
		user2.setQuantity(357);
		user2.setPassword("root");
		db.put(2, user2);

		Contract user3 = new Contract();
		user3.setContractNo(3);
		user3.setCustomerId(3);
		user3.setHaulierId(3);
		user3.setDeliveryDate("16-10-2008");
		user3.setDeliveryDay("friday");
		user3.setProductId(3);
		user3.setQuantity(951);
		user3.setPassword("root");
		db.put(3, user3);
	}
}