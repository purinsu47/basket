package com.gofluent.shopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gofluent.shopping.model.Item;
import com.gofluent.shopping.repositories.ItemRepository;

@Service
public class ItemServiceImpll implements ItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Override
	public void addToCart(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void deleteItem(Long id) {
		itemRepository.deleteById(id);
		
	}

	@Override
	public String totalPrice(Long id) {
		return itemRepository.totalPrice(id);
	}

}
