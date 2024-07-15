package com.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ecom.entity.AddCart;

public interface AddCartRepository extends JpaRepository<AddCart, Integer> {
	
	 @Query(value = "select a from AddCart a where a.userId = ?1 and a.productId = ?2" )
	 AddCart findByUserIdAndProductId(int userId, int productId);
	 
	 
	 @Query(value = "select a from AddCart a where a.userId = ?1")
	 List<AddCart> findByUserId(int userId);

}
