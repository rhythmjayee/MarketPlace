package com.productservice.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productservice.productservice.model.Product;
import com.productservice.productservice.repository.Product.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product newProduct) {
        Product product = new Product(
                    newProduct.getSellerID(), newProduct.getProductName(),
                    newProduct.getProductDescription(), newProduct.getProductQuantity());
        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
    public Product updateProduct(String productID, Product newProduct) {
        Optional<Product> dbRes = productRepository.findById(productID);
        if(!dbRes.isPresent()) return null;
        Product product = dbRes.get();
        product.setProductName(newProduct.getProductName());
        product.setProductQuantity(newProduct.getProductQuantity());
        product.setImageLink(newProduct.getImageLink());
        product.setProductDescription(newProduct.getProductDescription());

        productRepository.save(product);
        return product;
    }
    public Product deleteProduct(String productID) {
        Product product = getProduct(productID);
        if(product == null) return null;
        productRepository.deleteById(productID);
        return product;
    }
    public Product getProduct(String productID) {
        Optional<Product> dbRes = productRepository.findById(productID);
        if(!dbRes.isPresent()) return null;
        return dbRes.get();
    }
    public List<Product> getAllProducts(String sellerID) {
        List<Product> productList = productRepository.findAllProductsBySellerID(sellerID);
        return productList;
    } 
    
}
