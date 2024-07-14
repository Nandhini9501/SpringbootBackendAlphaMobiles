package com.ecom.entity;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "registers")
public class RegisterUser {
	
		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		
		@Column(name = "username")
		private String userName;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "email")
		private String email;
		
		@Column(name = "contact")
		private String contact;
		
		@Column(name ="image")
		private String image;
		
		@ManyToMany
		@JoinTable(name = "user_roles" ,joinColumns = @JoinColumn(name = "id"),inverseJoinColumns = @JoinColumn(name = "roleId"))
		private Set<Role> role = new LinkedHashSet<Role>();
		
		@ManyToMany
		@JoinTable(name = "user_carts" ,joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "cartId"))
		private List<AddCart> cart = new LinkedList<>();
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getContact() {
			return contact;
		}
		public void setContact(String contact) {
			this.contact = contact;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}

		public Set<Role> getRole() {
			return role;
		}
		public void setRole(Set<Role> role) {
			this.role = role;
		}
		public List<AddCart> getCart() {
			return cart;
		}
		public void setCart(List<AddCart> cart) {
			this.cart = cart;
		}
		
		
	
}



