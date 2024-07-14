package com.ecom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.entity.Card;

public interface CardService {

	public List<Card> getAllCards();

	public Card getCardById(int id);

//	String createCard(CardRequestDto reqDto, MultipartFile m) throws IOException;
	
	String createCard(String st, String cp, String cd, MultipartFile m) throws IOException;
	
	Card editCard(int id, Card c);
	
	Card viewCard(int id);
	
	String deleteCard(int id);
	
	void createCard(Card c);
	
	String imageUpload(MultipartFile m) throws IOException;
	
}
