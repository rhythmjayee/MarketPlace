package com.sellerservice.sellerservice.service;

import org.springframework.stereotype.Service;

import com.sellerservice.sellerservice.repository.Seller.SellerRepository;

@Service
public class SellerProductService {
    final private SellerRepository sellerRepository;

    public SellerProductService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
}
