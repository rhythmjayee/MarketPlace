package com.sellerservice.sellerservice.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sellerservice.sellerservice.feign.ProductInterface;
import com.sellerservice.sellerservice.model.Product;
import com.sellerservice.sellerservice.model.Seller;
import com.sellerservice.sellerservice.repository.Seller.SellerRepository;

@Service
public class SellerProductService {
    final private SellerRepository sellerRepository;
    final private ProductInterface productInterface;

    public SellerProductService(SellerRepository sellerRepository, ProductInterface productInterface) {
        this.sellerRepository = sellerRepository;
        this.productInterface = productInterface;
    }

    public Product addProduct(String sellerID, Product newProduct) {
        Product product = new Product(
                    sellerID, newProduct.getProductName(),
                    newProduct.getProductDescription(), newProduct.getProductQuantity());
        Product res = (Product) productInterface.createNewProduct(product).getBody();
        Optional<Seller> dbRes = sellerRepository.findById(sellerID);
        Seller seller = dbRes.get();
        seller.addProduct(product.getProductID());
        sellerRepository.save(seller);
        return res;
    }
    public Product updateProduct(Product newProduct) {
        Product product = (Product) productInterface.updateProduct(newProduct).getBody();
        return product;
    }
    public Product deleteProduct(String sellerID, String productID) {
        Product product = (Product) productInterface.deleteProduct(productID).getBody();
        Optional<Seller> dbRes = sellerRepository.findById(sellerID);
        Seller seller = dbRes.get();
        seller.deleteProduct(productID);
        sellerRepository.save(seller);
        return product;
    }
    public ResponseEntity<Object> getProduct(String productID) {
        ResponseEntity<Object> product = productInterface.deleteProduct(productID);
        return product;
    }
    public ResponseEntity<Object> getAllProducts(String sellerID) {
        ResponseEntity<Object> productList = productInterface.getAllProducts(sellerID);
        return productList;
    } 

}
