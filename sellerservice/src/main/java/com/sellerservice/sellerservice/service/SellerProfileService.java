package com.sellerservice.sellerservice.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sellerservice.sellerservice.model.Seller;
import com.sellerservice.sellerservice.repository.Seller.SellerRepository;

@Service
public class SellerProfileService {
    final private SellerRepository sellerRepository;

    public SellerProfileService(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }
    public Seller getSellerDetailsByEmail(String email) {
        Optional<Seller> seller = sellerRepository.findByEmail(email);
        if(seller.isPresent()) return seller.get();
        return null;
    }
    public Seller getSellerDetailsByID(String sellerID) {
        Optional<Seller> seller = sellerRepository.findById(sellerID);
        if(seller.isPresent()) return seller.get();
        return null;
    }
    public Seller editSellerName(String newSellerName, Optional<String> email, Optional<String> sellerID) {
        Seller seller = null;
        if(email.isPresent()) seller = getSellerDetailsByEmail(email.get());
        else if(sellerID.isPresent()) seller = getSellerDetailsByID(sellerID.get());
        else return null;
        seller.setName(newSellerName);
        sellerRepository.save(seller);
        return seller;
    }
}
