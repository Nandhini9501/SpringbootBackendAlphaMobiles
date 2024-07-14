package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecom.entity.RegisterUser;

public interface RegisterUserRepository extends JpaRepository<RegisterUser, Integer>{

	@Query(value = "select * from registers where email = ?1 and password = ?2" , nativeQuery = true)
	RegisterUser getUserLogin(String email,String password);
	
}
