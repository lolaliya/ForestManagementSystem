package com.dev.fms.beans;

public class UpdateContract {

	Contract contract = new Contract();
	private int contractId;
	private String password;
	
	
	public int getContractId() {
		return contract.getContractNo();
	}
	public void setContractId(int contractId) {
		contract.setContractNo(contractId);
	}
	public String getPassword() {
		return contract.getPassword();
	}
	public void setPassword(String password) {
		contract.setPassword(password);
	}
	@Override
	public String toString() {
		return "UpdateContract [contractId=" + contractId + ", password=" + password + "]";
	}

}
