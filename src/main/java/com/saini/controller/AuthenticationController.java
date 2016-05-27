package com.saini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.saini.model.Cart;
import com.saini.model.User_Authentication;
import com.saini.model.User_Authorization;
import com.saini.service.CartService;
import com.saini.service.User_AuthenticationService;
import com.saini.service.User_AuthorizationService;

@Controller
public class AuthenticationController {

	@Autowired
	private User_AuthenticationService service;
    private CartService cartService;
	
	@RequestMapping("/signUp")
	
	   public String signUpPage() {
	      return "signUpPage";
	   }
	@ModelAttribute("instuser")
	public User_Authentication authentication()
	{
		return new User_Authentication();
	}
	@RequestMapping("/adduser")
	public String addNewProduct(@ModelAttribute("instuser") User_Authentication user , BindingResult result)
	{
	   
	   service.addUser(user);
	   User_Authorization roleAuth=new User_Authorization();
	   roleAuth.setRole("ROLE_USER");
	   roleAuth.setUserid(user.getUserid());
	   
	   service.addRole(roleAuth);
		return "index";
	}
	
	
	@RequestMapping("/customerRegistration")
	 public String customerRegisterPage() {
	      return "customerRegistration";
	   }
	@ModelAttribute("instCustomer")
	
	@RequestMapping("/addCustomer")
	public String addNewCustomer(@ModelAttribute("instCustomer") Cart cart , BindingResult result)
	{
	   cart=new Cart();
	   cart.setUserid(1);
	   cart.setActive(true);
	   cartService.addCart(cart);
	/*
	   User_Authentication userAuth=new User_Authentication();
	   userAuth.setUserid(cart.getUserid());
	   userAuth.setUsername(cart.getUsername());
	   userAuth.setPassword(cart.getPassword());
	   userAuth.setMobile(cart.getMobile());
	   userAuth.setActive(true);
	   userAuth.setEmail(cart.getEmail());
	   
	   User_Authorization roleAuth=new User_Authorization();
	   roleAuth.setRole("ROLE_USER");
	   roleAuth.setUserid(cart.getUserid());
	   service.addUser(userAuth);
	   service.addRole(roleAuth);
	   */
	  
		return "index";
	}
}
