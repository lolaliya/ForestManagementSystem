package com.dev.fms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.dev.fms.beans.Haulier;
import com.dev.fms.beans.UpdateHaulier;
import com.dev.fms.services.HaulierServices;
import com.dev.fms.services.HaulierServicesImpl;

@RestController
public class HaulierController {
	HaulierServices services = new HaulierServicesImpl();

	@RequestMapping(value = "/rest/haulier/{id}", method = RequestMethod.GET)
	public Haulier getHaulier(@PathVariable("id") int haulierId) {
		//Haulier haulier = null;
		Haulier haulier = services.searchHaulier(haulierId);
		return haulier;
	}
	
	@RequestMapping(value = "/rest/haulier/create", method = RequestMethod.POST)
	public Haulier createHaulier(@RequestBody Haulier haulier) {
		services.addHaulier(haulier);
		return haulier;
	}

	@RequestMapping(value = "/rest/haulier/delete/{id}", method = RequestMethod.DELETE)
	public Haulier deleteHaulier(@PathVariable("id") int haulierId) {
		Haulier haulier = services.deleteHaulier(haulierId);
		return haulier;
	}
	@RequestMapping(value = "/rest/haulier/updatepassword", method = RequestMethod.PUT)
	public Boolean updatePassword(@RequestBody UpdateHaulier passwordUpdate) {
		Boolean e = false;
		e = services.updatePassword(passwordUpdate.getHaulierId(), passwordUpdate.getPassword());
		return e;

	}
	
	@RequestMapping(value = "/rest/haulier/updatetelephoneno", method = RequestMethod.PUT)
	public Boolean updateTelephone(@RequestBody UpdateHaulier telephoneUpdate) {
		Boolean e = false;
		e = services.updateTelephone(telephoneUpdate.getHaulierId(), telephoneUpdate.getTelephoneNo());
		return e;

	}
	
	@RequestMapping(value = "/rest/haulier/updateemail", method = RequestMethod.PUT)
	public Boolean updateEmail(@RequestBody UpdateHaulier emailUpdate) {
		Boolean e = false;
		e = services.updateEmail(emailUpdate.getHaulierId(), emailUpdate.getEmail());
		return e;
	}
}
