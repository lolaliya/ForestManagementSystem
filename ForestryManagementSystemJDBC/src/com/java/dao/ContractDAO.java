package com.java.dao;

import com.java.beans.Contract;

public interface ContractDAO {
	public Contract addContractor(Contract cont);
	public boolean deleteContractor(Integer contractId);
}
