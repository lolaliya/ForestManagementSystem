package com.dev.fms.beans;

public class UpdateProduct {
	
	Product product = new Product();
	
private int productId;
private String productDescription;

public int getProductId() {
	return product.getProductId();
}
public void setProductId(int productId) {
product.setProductId(productId);
}
public String getProductDescription() {
	return product.getProductDescription();
}
public void setProductDescription(String productDescription) {
	product.setProductDescription(productDescription);
}
@Override
public String toString() {
	return "UpdateProduct [productId=" + productId + ", productDescription=" + productDescription + "]";
}

}
