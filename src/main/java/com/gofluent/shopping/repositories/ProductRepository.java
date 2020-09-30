package com.gofluent.shopping.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gofluent.shopping.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query(value = "SELECT * FROM PRODUCT p right join ITEM i on p.id=i.product_id where i.basket_id = ?1", nativeQuery = true)
	List<Product> listByBasketId(Long id);

}
