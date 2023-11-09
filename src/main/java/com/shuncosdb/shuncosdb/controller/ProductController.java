package com.shuncosdb.shuncosdb.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shuncosdb.shuncosdb.model.Product;
import com.shuncosdb.shuncosdb.service.ProductService;



@RestController
@RequestMapping("/shuncos/products")
public class ProductController {
	
    private final ProductService productService;
    //Relaciones
    //private GenreService genreService;
    //private AuthorService authorService;
	
	@Autowired
    public ProductController(ProductService productService) {
		this.productService = productService;
	}

	// GET all products
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

	// GET products by model
    @GetMapping("/model/{model_txt}")
    public ResponseEntity<List<Product>> getProductsByModel(@PathVariable String model_txt) {
        List<Product> products = productService.getProductsByModel(model_txt);
        return ResponseEntity.ok(products);
    }

    // GET a single product by id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // POST a new product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    // PUT to update a product
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Product updatedProd = productService.updateProduct(id, productDetails);
        if (updatedProd != null) {
            return ResponseEntity.ok(updatedProd);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE a product
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
    	Product prod = productService.getProductById(id);
        if (prod != null) {
        	productService.deleteProduct(id);
            return ResponseEntity.ok().<Void>build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
	
}
