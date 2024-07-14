package com.ecom.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.service.CardService;
import com.ecom.entity.Card;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	CardService cardService;
	
	@PostMapping("/addCard")
	public String createCard(@RequestParam ("title") String ct, @RequestParam ("price") String cp, @RequestParam ("description") String cd, @RequestParam ("file") MultipartFile m) throws IOException
	{
		return cardService.createCard(ct, cp ,cd , m);
	}
	
	@GetMapping("/getAllCards")
	public List<Card> getAllCards()  {
		return cardService.getAllCards();
	}
	
	@GetMapping("/getCardById/{id}")
	public Card getCardById(@PathVariable int id){
		return cardService.getCardById(id);
	}
	
	@PostMapping("/editCard/{id}")
	public Card editCard(@PathVariable int id , @RequestBody Card c) {
		return cardService.editCard(id, c);
	}
	
	@GetMapping("/viewCard/{id}")
	public Card viewCard(@PathVariable int id) {
		return cardService.viewCard(id);
	}
	
	@GetMapping("/deleteCard/{id}")
	public String deleteCard(@PathVariable int id) {
		return cardService.deleteCard(id);
	}
	
	@PostMapping("/createCard")
	public String createCard(@RequestBody Card c) {
		cardService.createCard(c);
		return "Card created Successfully";
	}
	
	@PostMapping("/uploadImg")
	public String imageUpload(@RequestParam ("file") MultipartFile m) throws IOException {
		String image = cardService.imageUpload(m);
		return image;
	}
	
	
	
	//DTO
//	@PostMapping("/addCard")
//	public String createCard(@RequestBody CardRequestDto reqDto, @RequestParam ("file") MultipartFile m) throws IOException
//	{
//		return cardService.createCard(reqDto , m);
//	}

}
