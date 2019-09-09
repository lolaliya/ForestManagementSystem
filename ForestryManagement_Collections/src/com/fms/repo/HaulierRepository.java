package com.fms.repo;

import java.util.HashMap;
import com.fms.beans.Haulier;

public class HaulierRepository {
	public static HashMap<Integer, Haulier> db = new HashMap<>();

	public HaulierRepository(){
		Haulier user1 = new Haulier();
		user1.setHaulierId(1);
		user1.setHaulierName("Dev");
		user1.setStreetAddress1("#324 4th Block");
		user1.setStreetAddress2("Sanjaynagar");
		user1.setTownCity("Bangalore");
		user1.setPostCode("SDF213161");
		user1.setTelephoneNo(656565);
		user1.setEmail("cab@ola.com");
		db.put(1, user1);

		Haulier user2 = new Haulier();
		user2.setHaulierId(2);
		user2.setHaulierName("Devendra");
		user2.setStreetAddress1("#124 7th Block");
		user2.setStreetAddress2("Nagar");
		user2.setTownCity("Mysore");
		user2.setPostCode("FFD31351");
		user2.setTelephoneNo(655087875);
		user2.setEmail("cab1@ola1.com");
		db.put(2, user2);

		Haulier user3 = new Haulier();
		user3.setHaulierId(3);
		user3.setHaulierName("Pablo");
		user3.setStreetAddress1("#122 7th Block");
		user3.setStreetAddress2("Medillen");
		user3.setTownCity("Columbia");
		user3.setPostCode("DSGGSG05151");
		user3.setTelephoneNo(8596596);
		user3.setEmail("cab2@ola2.com");
		db.put(3, user3);
	}
}