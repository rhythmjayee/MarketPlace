package com.sellerservice.sellerservice.controller;

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

import com.sellerservice.sellerservice.model.Product;
import com.sellerservice.sellerservice.service.SellerProductService;

@RestController
@RequestMapping(value = "/seller/product")
public class SellerProductController {
    @Autowired
    private SellerProductService sellerProductService;

    @GetMapping(value = "/hello")
    public String hello() {
        return "hello from product service";
    }

    @PostMapping(value = "/new")
    @ResponseBody
    public ResponseEntity<Object> createNewProduct(@RequestBody Product product) {
        Product res =  sellerProductService.addProduct(product.getSellerID(), product);
        return ResponseEntity.ok(res);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return sellerProductService.updateProduct(product);
    }

    @GetMapping(value = "/my-products")
    @ResponseBody
    public ResponseEntity<Object> getAllProducts(@RequestParam(value = "sellerID") String sellerID) {
        return sellerProductService.getAllProducts(sellerID);
    }

    @GetMapping(value = "/details")
    @ResponseBody
    public ResponseEntity<Product> getProduct(@RequestParam(value = "productID") String productID) {
        return sellerProductService.getProduct(productID);
    }

    @DeleteMapping(value = "/delete")
    @ResponseBody
    public ResponseEntity<Product> deleteProduct(@RequestParam(value = "sellerID") String sellerID, 
                                                @RequestParam(value = "productID") String productID) {
        return sellerProductService.deleteProduct(sellerID, productID);
    }
}
