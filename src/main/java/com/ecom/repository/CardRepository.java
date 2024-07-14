package com.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.entity.Card;

public interface CardRepository extends JpaRepository<Card,Integer> {

}
