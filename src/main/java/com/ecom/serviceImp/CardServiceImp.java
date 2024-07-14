package com.ecom.serviceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.repository.CardRepository;
import com.ecom.service.CardService;
import com.ecom.entity.Card;

@Service
public class CardServiceImp implements CardService {
	
	@Autowired
	CardRepository cardRepo;


	@Override
	public String createCard(String ct, String cp, String cd, MultipartFile m) throws IOException {
		
		byte[] bytes = m.getBytes();
		String fileLoc = "E://SpringBoot/EcomAlphaMobiles/src/main/resources/Images/" + m.getOriginalFilename();
		Path path = Paths.get(fileLoc);
		Files.write(path, bytes);
		
		Card c = new Card();
		
		c.setCardTitle(ct);
		c.setCardPrice(cp);
		c.setCardDes(cd);
		c.setCardImage(m.getOriginalFilename());
		
		cardRepo.save(c);
		return m.getOriginalFilename();
	}
	
	
//	@Override
//	public String createCard(CardRequestDto reqDto, MultipartFile m) throws IOException {
//		
//		byte[] bytes = m.getBytes();
//		String fileLoc = "E://SpringBoot/RegistrationProject/src/main/resources/Images/" + m.getOriginalFilename();
//		Path path = Paths.get(fileLoc);
//		Files.write(path, bytes);
//		
//		Card c = new Card();
//		
//		c.setCardTitle(reqDto.getCardTitle());
//		c.setCardPrice(reqDto.getCardPrice());
//		c.setCardImage(m.getOriginalFilename());
//		
//		cardRepo.save(c);
//		return m.getOriginalFilename();
//	}


	@Override
	public List<Card> getAllCards() {
		
		
		return cardRepo.findAll();
	}

	@Override
	public Card getCardById(int id) {
		
		return cardRepo.findById(id).get();
	}


	@Override
	public Card editCard(int id, Card c) {
		Card card = cardRepo.findById(id).get();
		card.setCardTitle(c.getCardTitle());
		card.setCardPrice(c.getCardPrice());
		card.setCardDes(c.getCardDes());
		card.setCardImage(c.getCardImage());
		cardRepo.save(card);
		return card;
	}


	@Override
	public Card viewCard(int id) {
		Card card = cardRepo.findById(id).get();
		return card;
	}


	@Override
	public String deleteCard(int id) {
		Card card = cardRepo.findById(id).get();
		cardRepo.delete(card);
		return "Deleted Sucessfully";
	}


	@Override
	public void createCard(Card c) {
		Card card = new Card();
		card.setCardTitle(c.getCardTitle());
		card.setCardPrice(c.getCardPrice());
		card.setCardImage(c.getCardImage());
		
		cardRepo.save(card);
		
	}


	@Override
	public String imageUpload(MultipartFile m) throws IOException {
		byte[] bytes = m.getBytes();
		String fileLoc = "E://SpringBoot/EcomAlphaMobiles/src/main/resources/Images/" + m.getOriginalFilename();
		Path path = Paths.get(fileLoc);
		Files.write(path, bytes);
		return m.getOriginalFilename();
	}
	
	

	
}
