package com.java.dao;

import com.java.beans.Haulier;

public interface HaulierDAO {
	public Haulier addHaulier(Haulier person);
	public boolean deleteHaulier(Integer haulierId);
}
