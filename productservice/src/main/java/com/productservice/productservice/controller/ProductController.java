package com.productservice.productservice.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.productservice.productservice.model.Product;
import com.productservice.productservice.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello from product service";
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public ResponseEntity<Object> createNewProduct(@RequestBody Product product) {
        Product res =  productService.createProduct(product);
        return ResponseEntity.ok(res);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
        Product res =  productService.updateProduct(product.getProductID(),product);
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "/my-products")
    @ResponseBody
    public ResponseEntity<Object> getAllProducts(@RequestParam(value = "sellerID") String sellerID) {
        Set<Product> res =  productService.getAllProducts(sellerID);
        return ResponseEntity.ok(res);
    }

    @GetMapping(value = "/details")
    @ResponseBody
    public ResponseEntity<Object> getProduct(@RequestParam(value = "productID") String productID) {
        Product res =  productService.getProduct(productID);
        return ResponseEntity.ok(res);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<Object> deleteProduct(@RequestParam(value = "productID") String productID) {
        System.out.println(productID);
        Product res =  productService.deleteProduct(productID);
        return ResponseEntity.ok(res);
    }
}
