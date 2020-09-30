package com.gofluent.shopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.shopping.model.Product;
import com.gofluent.shopping.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> listByBasket(Long basketId) {
		return productRepository.listByBasketId(basketId);
	}

}
