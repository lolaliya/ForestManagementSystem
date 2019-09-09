package com.dev.fms.services;

import com.dev.fms.beans.Contract;

public interface ContractServices {
	public Boolean addContract(Contract contract);
	public Contract searchContract(Integer contractId);
	public Contract deleteContract(Integer contractId);
	public Boolean updatePassword(Integer contractId, String passwd);
}
