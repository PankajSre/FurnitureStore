package com.saini.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.saini.dao.CartDAO;
import com.saini.model.Cart;
import com.saini.service.CartService;
@Service
@Transactional
public class CartServiceImpl implements CartService {

	private CartDAO cartDAO;
	@Override
	public Cart getCartById(int cartId) {
		
		return cartDAO.getCartById(cartId);
	}

	@Override
	public void addCart(Cart cart) {
		cartDAO.addCart(cart);
		
	}

}
