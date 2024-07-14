package com.ecom.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cardId")
	 private int cardId;
	
	@Column(name = "cardTitle")
	 private String cardTitle;
	
	@Column(name = "cardPrice")
	private String cardPrice;
	
	@Column(name = "cardDes")
	private String cardDes;
	 

	@Column(name = "CardImage")
	 private String CardImage;

	
	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

	public String getCardTitle() {
		return cardTitle;
	}

	public void setCardTitle(String cardTitle) {
		this.cardTitle = cardTitle;
	}
	
	
	public String getCardPrice() {
		return cardPrice;
	}
	
	public void setCardPrice(String cardPrice) {
		this.cardPrice = cardPrice;
	}

	public String getCardImage() {
		return CardImage;
	}

	public void setCardImage(String cardImage) {
		CardImage = cardImage;
	}

	public String getCardDes() {
		return cardDes;
	}

	public void setCardDes(String cardDes) {
		this.cardDes = cardDes;
	}
	
	
	 
	 
	 

}

