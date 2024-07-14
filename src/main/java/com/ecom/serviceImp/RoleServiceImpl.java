package com.ecom.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ecom.entity.RegisterUser;
import com.ecom.entity.Role;
import com.ecom.repository.RegisterUserRepository;
import com.ecom.repository.RoleRepository;
import com.ecom.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepo;
	
	@Autowired
	RegisterUserRepository regRepo;

	@Override
	public Role addRole(Role role) {
		
		return roleRepo.save(role);
	}

	@Override
	public RegisterUser addRoleExistingUser(int id, Role role) {
		RegisterUser ru = regRepo.findById(id).get();
		ru.getRole().add(role);
		regRepo.save(ru);
		return ru;
	}

	
	
}
