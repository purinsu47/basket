package com.gofluent.shopping.service;

import java.util.List;

import com.gofluent.shopping.model.Product;

public interface ProductService{
	
	List<Product> listByBasket(Long basketId);

}
