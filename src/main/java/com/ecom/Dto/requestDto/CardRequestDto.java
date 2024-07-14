package com.ecom.Dto.requestDto;

public class CardRequestDto {

	 private int cardId;
	 private String cardTitle;
	 private String cardPrice;
	 private String cardDes;
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
