package com.fms.services;

import com.fms.beans.Contract;

public interface ContractServices {
	public Boolean addContract(Contract contract);
	public Contract searchContract(Integer contractId);
	public Contract deleteContract(Integer contractId);
	public Boolean updatePassword(Integer contractId, String passwd);
	public boolean updateDeliveryDay(int no, String newDay);
}
