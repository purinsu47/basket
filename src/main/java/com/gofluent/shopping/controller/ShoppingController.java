package com.gofluent.shopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gofluent.shopping.model.Basket;
import com.gofluent.shopping.model.Item;
import com.gofluent.shopping.model.Product;
import com.gofluent.shopping.service.BasketService;
import com.gofluent.shopping.service.ItemService;
import com.gofluent.shopping.service.ProductService;
import com.gofluent.shopping.util.Success;

@RestController
@RequestMapping("/api/")
public class ShoppingController {

	@Autowired
	BasketService basketService;
	
	@Autowired
	ItemService itemService;
	
	@Autowired
	ProductService productService;

	public static final Logger logger = LoggerFactory.getLogger(ShoppingController.class);

	@RequestMapping(value = "basket", method = RequestMethod.POST)
	public ResponseEntity<?> addBasket() {
		Basket basketEntity = basketService.saveBasket(new Basket());
		logger.info("Basket created.");
		return new ResponseEntity<Basket>(basketEntity, HttpStatus.OK);
	}
	
	@RequestMapping(value = "basket/{basketId}/addToCart/{productId}", method = RequestMethod.POST)
	public ResponseEntity<?> addToCart(@PathVariable("basketId") Long id, @PathVariable("productId") Long productId) {
		Item item = new Item();
		item.setBasketId(id);
		item.setProductId(productId);
		itemService.addToCart(item);
		Success success = new Success(true, "Added to Cart");
		logger.info("Product successfully added to cart.");
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}
	
	@RequestMapping(value = "basket/{basketId}", method = RequestMethod.GET)
	public ResponseEntity<?> basketList(@PathVariable("basketId") Long id) {
		List<Product> productList = productService.listByBasket(id);
		logger.info("Product list.");
		return new ResponseEntity<List<Product>>(productList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "basket/delete/{itemId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteItemToCart(@PathVariable("itemId") Long id) {
		itemService.deleteItem(id);
		Success success = new Success(true, "Successfully Deleted");
		logger.info("Removed item from the basket.");
		return new ResponseEntity<Success>(success, HttpStatus.OK);
	}
	
	@RequestMapping(value = "basket/total/{basketId}", method = RequestMethod.GET)
	public ResponseEntity<?> basketTotal(@PathVariable("basketId") Long id) {
		String total = itemService.totalPrice(id);
		logger.info("Total price " + total);
		return new ResponseEntity<String>(total, HttpStatus.OK);
	}
	

}
