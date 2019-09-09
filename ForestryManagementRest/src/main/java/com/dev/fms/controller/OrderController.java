package com.dev.fms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fms.beans.Orders;
import com.dev.fms.beans.UpdateOrder;
import com.dev.fms.services.OrderServicesImpl;
import com.dev.fms.services.OrdersServices;

@RestController
public class OrderController {
	
	OrdersServices services = new OrderServicesImpl();
	
		@RequestMapping(value = "/rest/order/{id}", method = RequestMethod.GET)
		public Orders getOrder(@PathVariable("id") int orderId) {
			Orders order = null;
			order = services.searchOrder(orderId);
			return order;
		}

		@RequestMapping(value = "/rest/order/create", method = RequestMethod.POST)
		public Orders createOrder(@RequestBody Orders order) {
			services.addOrder(order);
			return order;
		}

		@RequestMapping(value = "/rest/order/delete/{id}", method = RequestMethod.DELETE)
		public Orders deleteOrder(@PathVariable("id") int orderId) {
			Orders order = services.deleteOrder(orderId);
			return order;
		}
		
		@RequestMapping(value = "/rest/order/updatedate", method = RequestMethod.PUT)
		public Boolean updateDate(@RequestBody UpdateOrder dateUpdate) {
	    Boolean e = false;
		e = services.updateDeliveryDate(dateUpdate.getOrderNo(), dateUpdate.getDeliveryDate());
		return e;
			
		}

}
