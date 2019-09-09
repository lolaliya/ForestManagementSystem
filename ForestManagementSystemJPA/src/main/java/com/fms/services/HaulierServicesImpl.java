package com.fms.services;

import com.fms.beans.Haulier;
import com.fms.dao.HaulierDAO;
import com.fms.dao.HaulierJPAImpl;

public class HaulierServicesImpl implements HaulierServices{

	private HaulierDAO db = new HaulierJPAImpl();

	public Boolean addHaulier(Haulier haulier) {
		return db.addHaulier(haulier);
	}

	public Haulier searchHaulier(Integer haulierId) {
		return db.searchHaulier(haulierId);
	}

	public Haulier deleteHaulier(Integer haulierId) {
		return db.deleteHaulier(haulierId);
	}

	public Boolean updatePassword(Integer haulierId, String passwd) {
		return db.updatePassword(haulierId, passwd);
	}

	@Override
	public Boolean updateTelephone(Integer haulierId, long number) {
		return db.updateTelephone(haulierId, number);
	}

	@Override
	public Boolean updateEmail(Integer haulierId, String email) {
		return db.updateEmail(haulierId, email);
	}


}
