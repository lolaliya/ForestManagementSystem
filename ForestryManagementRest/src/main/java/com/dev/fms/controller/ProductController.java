package com.dev.fms.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.fms.beans.Product;
import com.dev.fms.beans.UpdateProduct;
import com.dev.fms.services.ProductServices;
import com.dev.fms.services.ProductServicesImpl;


@RestController
public class ProductController {
	
	ProductServices services = new ProductServicesImpl();
	
		@RequestMapping(value = "/rest/product/{id}", method = RequestMethod.GET)
		public Product getProduct(@PathVariable("id") int productId) {
			Product product = null;
			product = services.searchProduct(productId);
			return product;
		}

		@RequestMapping(value = "/rest/product/create", method = RequestMethod.POST)
		public Product createProduct(@RequestBody Product product) {
			services.addProduct(product);
			return product;
		}

		@RequestMapping(value = "/rest/product/delete/{id}", method = RequestMethod.DELETE)
		public Product deleteProduct(@PathVariable("id") int productId) {
			Product product = services.deleteProduct(productId);
			return product;
		}


		@RequestMapping(value = "/rest/product/updatedescription", method = RequestMethod.PUT)
		public Boolean updateDescription(@RequestBody UpdateProduct descriptionUpdate) {
	    Boolean e = false;
		e = services.updateProduct(descriptionUpdate.getProductId(), descriptionUpdate.getProductDescription());
		return e;
			
		}
}
