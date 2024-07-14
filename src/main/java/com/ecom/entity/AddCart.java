package com.ecom.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "addCarts")
public class AddCart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cartId")
	private int cartId;
	
	@Column(name = "productName")
	private String productName;
	
	@Column(name = "productPrice")
	private String productPrice;
	
	@Column(name = "userId")
	private int userId;
	
	@Column(name = "userName")
	private int userName;
	
	@Column(name = "productDes")
	private String productDes;

	@Column(name  = "productImg")
	private String productImg;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "createdAt")
	private Date createdAt;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getProductDes() {
		return productDes;
	}

	public void setProductDes(String productDes) {
		this.productDes = productDes;
	}

	public String getProductImg() {
		return productImg;
	}

	public void setProductImg(String productImg) {
		this.productImg = productImg;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	

}