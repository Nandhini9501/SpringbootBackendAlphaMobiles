package com.ecom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ecom.Dto.requestDto.RegisterUserRequestDto;
import com.ecom.Dto.responseDto.RegisterUserResponseDto;
import com.ecom.entity.RegisterUser;

public interface RegisterUserService {

	void createUser(RegisterUser u);
	
	String imageUpload(MultipartFile f) throws IOException;
	
	RegisterUser registerUser(RegisterUser u);
	
	RegisterUserResponseDto login(RegisterUser r);
	
	List<RegisterUser> getUserData();
	
	RegisterUser editData(int id,RegisterUser ru);
	
	RegisterUser viewData(int id);
	
	String deleteData(int id);
	
	public RegisterUser addRoleData(RegisterUserRequestDto reqDto);
	
}
