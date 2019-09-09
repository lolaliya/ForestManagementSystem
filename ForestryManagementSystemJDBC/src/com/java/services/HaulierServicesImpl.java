package com.java.services;

import com.java.beans.Haulier;
import com.java.dao.HaulierDAO;
import com.java.dao.HaulierJDBCImpl;

public class HaulierServicesImpl implements HaulierServices{
	private HaulierDAO db = new HaulierJDBCImpl();
	
	@Override
	public Haulier addHaulier(Haulier haulier) {
	 return db.addHaulier(haulier);
	}

	@Override
	public boolean deleteHaulier(Integer haulierId) {
		return db.deleteHaulier(haulierId);
	}

}
