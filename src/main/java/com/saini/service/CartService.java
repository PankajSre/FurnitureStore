package com.saini.service;

import com.saini.model.Cart;

public interface CartService {

	Cart getCartById(int cartId);

	public void addCart(Cart cart);
}
