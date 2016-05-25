package com.saini.controller;

import java.util.List;
import java.util.Map;

import com.saini.model.*;
import com.saini.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FurnitureController {

	@Autowired
	private ProductsService productsService;

	@RequestMapping(value = { "/", "/index" })
	public ModelAndView indexPage() {

		return new ModelAndView("index");
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contactPage() {
		return new ModelAndView("contactPage");
	}

	@RequestMapping(value = "/login")
	public ModelAndView loginPage(@RequestParam(value="error", required = false)
	String error,@RequestParam(value="logout", required = false)String logout,Model model) {
		if(error != null){
			model.addAttribute("error", "Invalid username and password");
			System.out.println(error);
			}

			if (logout !=null){
			model.addAttribute("msg", "You have been logged out successfully !!!!");
			}
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/signUp")
	public ModelAndView signUpPage() {

		return new ModelAndView("signUpPage");
	}

	@RequestMapping(value = "/about")
	public ModelAndView aboutPage() {

		return new ModelAndView("aboutPage");
	}

	
	 @RequestMapping(value = "/test", method = RequestMethod.GET)
	 public ModelAndView testPage() {
	 
	 return new ModelAndView("test"); }
	

	@RequestMapping(value = "/products")
	public String productsPage(ModelMap model) {
     
		List<Products> products=productsService.getAllProducts();
	
		model.addAttribute("products", products);
		return "products";
	}

	 
	@RequestMapping(value = "/prodRegistration", method = RequestMethod.GET)
	public String registrationPage(Map<String, Object> map) {
		Products prodRegistration = new Products();
		map.put("prodRegistration", prodRegistration);
		map.put("productList", productsService.getAllProducts());
		return "prodRegistration";

	}

	@RequestMapping(value = "/prodRegistration.do", method = RequestMethod.GET)
	public String doActions(@ModelAttribute Products products,
			BindingResult results, @RequestParam String action,
			Map<String, Object> map) {
		Products productResult = new Products();
		switch (action.toLowerCase()) {
		case "add":
                  productsService.add(products);
                  productResult=products;
			break;
		case "edit":
			productsService.edit(products);
            productResult=products;
			break;
		case "delete":
			productsService.delete(products.getProductId());
            productResult=new Products();
			break;
		case "search":
               Products searchProducts=productsService.getProduct(products.getProductId());
               productResult=searchProducts !=null ? searchProducts : new Products();
			break;

		}
		map.put("prodRegistration", productResult);
		map.put("productList", productsService.getAllProducts());
		return "prodRegistration";

	}
/*
	@RequestMapping(value = "/viewProduct")
	public String viewPage(ModelMap model) {
     
		Products p=new Products();
		Products view=productsService.getProduct(p.getProductId());
	
		model.addAttribute("view", view);
		return "viewProduct";
	}
	*/
	@RequestMapping("/viewProduct")
	public String getProductById(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		return "viewProduct";
	}
	/*
	@RequestMapping("delete")
	 public ModelAndView deleteUser(@RequestParam("productId") int productId) {
	  productsService.delete(productId);
	  return new ModelAndView("redirect:products");
	 }
	 */
	
}
