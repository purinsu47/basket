package com.gofluent.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.shopping.model.Basket;
import com.gofluent.shopping.repositories.BasketRepository;

@Service("basketService")
public class BasketServiceImpl implements BasketService {

	@Autowired
	private BasketRepository basketRepository;

	@Override
	public Basket saveBasket(Basket basket) {
		return basketRepository.save(basket);
	}

}
