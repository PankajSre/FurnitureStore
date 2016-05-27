package com.saini.dao;

import com.saini.model.Cart;

public interface CartDAO {

	 Cart getCartById(int cartId);
	 
	 public void addCart(Cart cart);
}
