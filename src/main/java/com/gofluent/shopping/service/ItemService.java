package com.gofluent.shopping.service;

import com.gofluent.shopping.model.Item;

public interface ItemService {
	
	void addToCart(Item item);
	
	void deleteItem(Long id);
	
	String totalPrice(Long id);

}
