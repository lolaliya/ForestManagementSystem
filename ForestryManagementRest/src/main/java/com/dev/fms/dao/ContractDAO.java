package com.dev.fms.dao;

import com.dev.fms.beans.Contract;

public interface ContractDAO {
	
	public Boolean addContract(Contract contract);
	public Contract searchContract(Integer contractId);
	public Contract deleteContract(Integer contractId);
	public Boolean updatePassword(Integer contractId, String passwd);
}
