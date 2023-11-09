package com.sellerservice.sellerservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sellerservice.sellerservice.model.Product;

@FeignClient("PRODUCT-SERVICE")
public interface ProductInterface {
    @PostMapping(value = "/product/create")
    @ResponseBody
    public ResponseEntity<Object> createNewProduct(@RequestBody Product product);

    @PutMapping(value = "/product/update")
    @ResponseBody
    public ResponseEntity<Object> updateProduct(@RequestBody Product product);

    @GetMapping(value = "/product/my-products")
    @ResponseBody
    public ResponseEntity<Object> getAllProducts(@RequestParam(value = "sellerID") String sellerID);

    @GetMapping(value = "/product/details")
    @ResponseBody
    public ResponseEntity<Object> getProduct(@RequestParam(value = "productID") String productID);

    @DeleteMapping(value = "/product/delete")
    @ResponseBody
    public ResponseEntity<Object> deleteProduct(@RequestParam(value = "productID") String productID);
}
