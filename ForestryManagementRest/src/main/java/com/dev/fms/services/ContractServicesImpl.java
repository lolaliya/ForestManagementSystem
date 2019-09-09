package com.dev.fms.services;

import com.dev.fms.beans.Contract;
import com.dev.fms.dao.ContractDAO;
import com.dev.fms.dao.ContractJPAImpl;

public class ContractServicesImpl implements ContractServices{

	private ContractDAO db = new ContractJPAImpl();

	public Boolean addContract(Contract contract) {
		return db.addContract(contract);
	}

	public Contract searchContract(Integer contractId) {
		return db.searchContract(contractId);
	}

	public Contract deleteContract(Integer contractId) {
		return db.deleteContract(contractId);
	}

	public Boolean updatePassword(Integer contractId, String passwd) {
		return db.updatePassword(contractId, passwd);
	}

}
