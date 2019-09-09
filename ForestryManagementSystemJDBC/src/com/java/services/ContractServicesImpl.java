package com.java.services;

import com.java.dao.ContractDAO;
import com.java.dao.ContractJDBCImpl;
import com.java.beans.Contract;

public class ContractServicesImpl implements ContractServices {
	private ContractDAO db = new ContractJDBCImpl();
	
	@Override
	public Contract addContractor(Contract contractor) {
		return db.addContractor(contractor);
	}

	@Override
	public boolean deleteContractor(Integer contractId) {
		return db.deleteContractor(contractId);
	}

}
