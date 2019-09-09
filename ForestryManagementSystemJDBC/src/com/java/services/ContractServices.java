package com.java.services;

import com.java.beans.Contract;

public interface ContractServices {
	public Contract addContractor(Contract cont);
	public boolean deleteContractor(Integer contractId);
}
