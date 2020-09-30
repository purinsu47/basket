package com.gofluent.shopping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gofluent.shopping.model.Basket;

public interface BasketRepository extends JpaRepository<Basket, Long> {
	
	@Query(value = "Inset into basket value(item) values (?1) where id = ?2",nativeQuery = true)
	void addToCart(Long itemId, String basketId);

}
