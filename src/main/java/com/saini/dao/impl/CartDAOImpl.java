package com.saini.dao.impl;

import javax.persistence.PersistenceContext;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.saini.dao.CartDAO;
import com.saini.model.Cart;
@Repository
@PersistenceContext
public class CartDAOImpl implements CartDAO{

	private SessionFactory sessionFactory;
	@Override
	public Cart getCartById(int cartId) {
	
		return (Cart)sessionFactory.getCurrentSession().get(Cart.class,cartId);
	}

	@Override
	public void addCart(Cart cart) {
		sessionFactory.getCurrentSession().save(cart);
		
	}

}
