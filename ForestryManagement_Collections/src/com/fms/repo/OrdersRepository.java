package com.fms.repo;

import java.util.HashMap;
import com.fms.beans.Orders;

public class OrdersRepository {
	public static HashMap<Integer, Orders> db = new HashMap<>();

	public OrdersRepository(){
		Orders user1 = new Orders();
		user1.setOrderNo(1);
		user1.setCustomerId(1);
		user1.setHaulierId(1);
		user1.setDeliveryDate("31-03-1997");
		user1.setProductId(1);
		user1.setQuantity(4);
		db.put(1, user1);

		Orders user2 = new Orders();
		user2.setOrderNo(2);
		user2.setCustomerId(2);
		user2.setHaulierId(2);
		user2.setDeliveryDate("11-07-2019");
		user2.setProductId(2);
		user2.setQuantity(47);
		db.put(2, user2);

		Orders user3 = new Orders();
		user3.setOrderNo(3);
		user3.setCustomerId(3);
		user3.setHaulierId(3);
		user3.setDeliveryDate("19-09-2018");
		user3.setProductId(3);
		user3.setQuantity(465);
		db.put(3, user3);
	}
}