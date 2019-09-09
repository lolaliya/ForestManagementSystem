package com.dev.fms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fms.beans.Contract;
import com.dev.fms.beans.UpdateContract;
import com.dev.fms.services.ContractServices;
import com.dev.fms.services.ContractServicesImpl;

@RestController
public class ContractController {
	ContractServices services = new ContractServicesImpl();

	@RequestMapping(value = "/rest/contract/{id}", method = RequestMethod.GET)
	public Contract getContractor(@PathVariable("id") int contractId) {
		Contract contract = null;
		contract = services.searchContract((contractId));
		return contract;
	}

	@RequestMapping(value = "/rest/contract/create", method = RequestMethod.POST)
	public Contract createContract(@RequestBody Contract contract) {
		services.addContract(contract);
		return contract;
	}

	@RequestMapping(value = "/rest/contract/delete/{id}", method = RequestMethod.DELETE)
	public Contract deleteContract(@PathVariable("id") int contractId) {
		Contract contract = services.deleteContract(contractId);
		return contract;
	}

	@RequestMapping(value = "/rest/contract/updatepassword", method = RequestMethod.PUT)
	public Boolean updatePassword(@RequestBody UpdateContract passwordUpdate) {
    Boolean e = false;
	e = services.updatePassword(passwordUpdate.getContractId(), passwordUpdate.getPassword());
	return e;
		
	}
}
