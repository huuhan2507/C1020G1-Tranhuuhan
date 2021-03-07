package com.example.service;

import com.example.entity.Cart;

import java.util.List;

public interface CartService {
    List<Cart> findAllCart();
    void saveCart(Cart cart);
}
