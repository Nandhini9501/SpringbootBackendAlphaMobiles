package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ecom.entity.RegisterUser;
import com.ecom.entity.Role;
import com.ecom.service.RegisterUserService;
import com.ecom.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	RegisterUserService regService;

	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role r) {
		
		return roleService.addRole(r);
		
	}
	
	@PostMapping("/addRoleExistingUser/{id}")
	public RegisterUser addRoleExistingUser(@PathVariable int id,@RequestBody Role role) {
		
		return roleService.addRoleExistingUser(id, role);
	}
	
	
	
}
