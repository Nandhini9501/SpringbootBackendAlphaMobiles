package com.ecom.serviceImp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecom.entity.AddCart;
import com.ecom.repository.AddCartRepository;
import com.ecom.service.AddCartService;

@Service
public class AddCartServiceImp implements AddCartService {
	
	@Autowired
	AddCartRepository addCartRepo;

	@Override
	public String addToCart(int userId, String userName, int productId, String productName, String productPrice,
			String productDes, String productImg, int quantity) {
		
		AddCart exCart = addCartRepo.findByUserIdAndProductId(userId, productId);
		
		if(exCart != null) 
		{
			exCart.setQuantity(exCart.getQuantity() + quantity);
			addCartRepo.save(exCart);
		}
		else
		{
			
			AddCart cart = new AddCart();
			cart.setUserId(userId);
			cart.setUserName(userName);
			cart.setProductId(productId);
			cart.setProductName(productName);
			cart.setProductPrice(productPrice);
			cart.setProductDes(productDes);
			cart.setProductImg(productImg);
			cart.setQuantity(quantity);
//		cart.setCreatedAt(LocalDateTime.now());
			
			addCartRepo.save(cart);
			
		}
		
		return "Items Added SuccessFully";
	}

	@Override
	public List<AddCart> getCart() {
		
		return addCartRepo.findAll();
	}


	
	@Override
	public List<AddCart> getCartById(int userId) {
		
		return addCartRepo.findByUserId(userId);
	}

	@Override
	public boolean removeFromCart(int cartId) {
		if(addCartRepo.existsById(cartId))
		{
			addCartRepo.deleteById(cartId);
			return true;
		}
		return false;
	}
	
	
}
