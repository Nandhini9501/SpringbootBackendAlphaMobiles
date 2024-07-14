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

import com.ecom.service.RegisterUserService;
import com.ecom.Dto.requestDto.RegisterUserRequestDto;
import com.ecom.Dto.responseDto.RegisterUserResponseDto;
import com.ecom.entity.RegisterUser;

@RestController
@RequestMapping("/registerApi")
public class RegisterUserController {
		
	@Autowired
	RegisterUserService regUserService;

	@PostMapping("/register")   
	 public RegisterUser registerUser(@RequestBody RegisterUser reg) {
		
	        return regUserService.registerUser(reg);	        
	        
	   }
	
	
	
	@PostMapping("/login")
	public RegisterUserResponseDto loginForm(@RequestBody RegisterUser reg) {
	    return regUserService.login(reg);
	}

	
	@GetMapping("/getData")
	public List<RegisterUser> getUserData() {
		
		return regUserService.getUserData();
		
	}
	
	
	@PostMapping("/edit/{id}")
	public RegisterUser editData(@PathVariable int id, @RequestBody RegisterUser r) {
		
		
		return regUserService.editData(id, r);
	}
	
	@GetMapping("/view/{id}")
	public RegisterUser viewData(@PathVariable int id) {
		
		return regUserService.viewData(id);
	}
	
	
	@GetMapping("/delete/{id}")
	public String deleteData(@PathVariable int id)
	{
		return regUserService.deleteData(id);
	}
	
	
	@PostMapping("/createUser")
	public String createUser(@RequestBody RegisterUser user)
	{

		regUserService.createUser(user);
		return "user created successfully";
	}
	

	
	@PostMapping("/uploadimg")
	public String uploadImage(@RequestParam ("file") MultipartFile m) throws IOException {
//		System.out.println("mDATA============"+m);
		String image =regUserService.imageUpload(m);
		return image;
	}
	
	@PostMapping("/addRoleDto")
	public RegisterUser addRoleData(@RequestBody RegisterUserRequestDto reqDto) {
		
		return regUserService.addRoleData(reqDto);
		
	}
}
