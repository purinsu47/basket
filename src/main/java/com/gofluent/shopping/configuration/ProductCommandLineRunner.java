package com.gofluent.shopping.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.gofluent.shopping.model.Product;
import com.gofluent.shopping.repositories.ProductRepository;

@Component
public class ProductCommandLineRunner implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		for (Product product : productRepository.findAll()) {
			System.out.println(product.toString());
		}

	}

}
