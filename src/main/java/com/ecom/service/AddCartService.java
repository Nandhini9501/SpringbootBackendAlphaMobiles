package com.ecom.service;

import java.util.List;

import com.ecom.entity.AddCart;

public interface AddCartService {
	
	String addToCart(int userId ,String userName ,int productId, String productName, String productPrice, String productDes , String productImg , int quantity  );
	
	List<AddCart>  getCart();
	
	List<AddCart> getCartById(int userId);
	
	boolean removeFromCart(int cartId);
	
}
