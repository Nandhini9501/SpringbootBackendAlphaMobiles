package com.ecom.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.entity.AddCart;
import com.ecom.service.AddCartService;

@RestController
@RequestMapping("/cart")
public class AddCartController {
	
	@Autowired
	AddCartService addCartService;

	@PostMapping("/add")
	public String addToCart(@RequestParam ("userId") int userId, @RequestParam ("userName") String userName, @RequestParam ("productId") int productId,
			@RequestParam("productName") String productName, @RequestParam ("productPrice") String productPrice, @RequestParam ("productDes") String productDes,
			@RequestParam ("productImg") String productImg, @RequestParam ("quantity") int quantity) {


		addCartService.addToCart(userId, userName, productId, productName, productPrice, productDes, productImg, quantity);
		
		return "Item added to cart successfully";
	}
	
	
	@GetMapping("/getCart")
	public List<AddCart> getCart()
	{
		return addCartService.getCart();
	}
	

	@GetMapping("/getCartById/{userId}")
	public List<AddCart> getCartById(@PathVariable ("userId") int userId)
	{
		return addCartService.getCartById(userId);
	}
	
	@GetMapping("/removeProduct/{cartId}")
	public  String removeProduct(@PathVariable int cartId) 
	{
		boolean isRemoved = addCartService.removeFromCart(cartId);
		
		if(! isRemoved)
		{
			return "Product Not Removed";
		}
		
		return "Product Removed Successfully";
	}
	
	@PostMapping("/updateQuantity")
    public String updateQuantity(@RequestParam int userId, @RequestParam int productId, @RequestParam int quantity) {
        return addCartService.updateQuantity(userId, productId, quantity);
    }
	
}
