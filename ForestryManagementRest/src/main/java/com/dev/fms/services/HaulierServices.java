package com.dev.fms.services;

import com.dev.fms.beans.Haulier;

public interface HaulierServices {
	public Boolean addHaulier(Haulier haulier);
	public Haulier searchHaulier(Integer haulierId);
	public Haulier deleteHaulier(Integer haulierId);
	public Boolean updateTelephone(Integer haulierId, long number);
	public Boolean updateEmail(Integer haulierId, String email);
	public Boolean updatePassword(Integer haulierId, String passwd);
}