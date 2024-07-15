package com.ecom.serviceImp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.repository.RegisterUserRepository;
import com.ecom.service.RegisterUserService;
import com.ecom.Dto.requestDto.RegisterUserRequestDto;
import com.ecom.Dto.responseDto.RegisterUserResponseDto;
import com.ecom.entity.RegisterUser;
import com.ecom.entity.Role;

@Service
public class RegisterUserServiceImp implements RegisterUserService {

	@Autowired
	RegisterUserRepository regUserRepo;
	
	
	@Override
	public void createUser(RegisterUser u) {
		RegisterUser user = new RegisterUser();
		user.setContact(u.getContact());
		user.setEmail(u.getEmail());
		user.setPassword(u.getPassword());
		user.setUserName(u.getUserName());
		user.setImage(u.getImage());
		
		regUserRepo.save(user);
		
	}


	@Override
	public String imageUpload(MultipartFile f) throws IOException {
		byte[] bytes = f.getBytes();
		String fileLoc = "E://SpringBoot/EcomAlphaMobiles/src/main/resources/Images/" + f.getOriginalFilename();
		Path path = Paths.get(fileLoc);
		Files.write(path, bytes);
		return f.getOriginalFilename();
	}


	@Override
	public RegisterUser registerUser(RegisterUser us) {
		RegisterUser user = new RegisterUser();
		user.setContact(us.getContact());
		user.setEmail(us.getEmail());
		user.setPassword(us.getPassword());
		user.setUserName(us.getUserName());
		user.setImage(us.getImage());
		
		regUserRepo.save(user);
		return regUserRepo.save(user);
	}


	public RegisterUserResponseDto login(RegisterUser r) {
	    RegisterUser login = regUserRepo.getUserLogin(r.getEmail(), r.getPassword());

	    RegisterUserResponseDto res = new RegisterUserResponseDto();

	    res.setUserName(login.getUserName());
	    res.setRole(login.getRole());
	    res.setEmail(login.getEmail());
	    res.setPassword(login.getPassword());
	    res.setId(login.getId());
	   
	    
	    
	    for (Role re : login.getRole()) {
//	    	 System.out.println(re.getRoleName());
	        if (re.getRoleName().equals("ROLE_ADMIN")) {
	        	
	            res.setAdmin(true); 
	        }
	      
	    }
	    
	    return res;    
	}


	@Override
	public List<RegisterUser> getUserData() {
		List<RegisterUser> regUs = regUserRepo.findAll();
		return regUs;
	}


	@Override
	public RegisterUser editData(int id, RegisterUser ru) {
		RegisterUser reg = 	regUserRepo.findById(id).get();
		reg.setUserName(ru.getUserName());
		reg.setPassword(ru.getPassword());
		reg.setEmail(ru.getEmail());
		reg.setContact(ru.getContact());
		reg.setImage(ru.getImage());
		regUserRepo.save(reg);
		return reg;
	}


	@Override
	public RegisterUser viewData(int id) {
		RegisterUser reg = regUserRepo.findById(id).get();
		return reg;
	}


	@Override
	public String deleteData(int id) {

		RegisterUser r = regUserRepo.findById(id).get();
		regUserRepo.delete(r);
		return "Deleted Succesfully";
	}

	@Override
	public RegisterUser addRoleData(RegisterUserRequestDto reqDto) {
		RegisterUser r = new RegisterUser();
		r.setUserName(reqDto.getUserName());
		r.setPassword(reqDto.getPassword());
		r.setRole(reqDto.getRole());
		regUserRepo.save(r);
		return r;
	}
	
}
