package com.ecom.service;



import com.ecom.entity.RegisterUser;
import com.ecom.entity.Role;

public interface RoleService {

	public Role addRole(Role role);
	
	public RegisterUser addRoleExistingUser(int id,Role role);
	
	
}
