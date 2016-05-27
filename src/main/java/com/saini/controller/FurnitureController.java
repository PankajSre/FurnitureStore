package com.saini.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.saini.model.*;
import com.saini.service.ProductsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
			}

			if (logout !=null){
			model.addAttribute("msg", "You have been logged out successfully !!!!");
			}
			
		return new ModelAndView("loginPage");
	}

	 @RequestMapping(value = "/login", method = RequestMethod.POST)
	    public String doLogin(@Valid @ModelAttribute("validate") Login validate,
	            BindingResult result, Map<String, Object> model) {
	 
	        if (result.hasErrors()) {
	            return "loginPage";
	        }
	 
	        return "loginPage";
	    }

	@RequestMapping(value = "/about")
	public ModelAndView aboutPage() {

		return new ModelAndView("aboutPage");
	}


	@RequestMapping(value = "/products")
	public String productsPage(ModelMap model) {
     
		List<Products> products=productsService.getAllProducts();
	
		model.addAttribute("products", products);
		return "products";
	}
	
	

	/*
	@RequestMapping("/admin/prodRegistration")
	
	   public String productRegistration() {
	      return "prodRegistration";
	   }
	@ModelAttribute("insertProductCommand")
	public Products construct()
	{
	return new Products();
	}
*/

	
	@RequestMapping(value = "/prodRegistration")
	public String registrationPage(ModelMap map) {
		Products prodRegistration = new Products();
		map.put("products", prodRegistration);
		return "prodRegistration";

	}
	@ModelAttribute("products")
	public Products getLast()
	{
		return new Products();
	}
	@RequestMapping(value="/admin/prodRegistration",method=RequestMethod.POST)
	public ModelAndView insertProduct(@ModelAttribute("products")
	Products p, HttpServletRequest request, BindingResult result)
	{
		System.out.println(p.getProductId());
		ServletContext context=request.getServletContext(); 
		String path=context.getRealPath("/resources/"+p.getProductId()+".jpg"); 
		System.out.println("Path = "+path); 
		System.out.println("File name = "+p.getImagePath().getOriginalFilename()); 
		File f=new File(path); 
		if(!p.getImagePath().isEmpty()) {
			try { 
		   //filename=p.getImagePath().getOriginalFilename(); 
			byte[] bytes=p.getImagePath().getBytes();
			BufferedOutputStream bs=new BufferedOutputStream(new FileOutputStream(f));
			bs.write(bytes); 
			bs.close(); 
			System.out.println("Image uploaded");
			productsService.add(p);
			
			System.out.println("Data Inserted");
			}
			catch(Exception ex)
			{
			System.out.println(ex.getMessage());
			}
			}
		
	      return new ModelAndView("prodRegistration");
	
	}
	
/*
	@RequestMapping(value = "/admin/prodRegistration.do", method = RequestMethod.GET)
	public String doActions(@ModelAttribute Products products,
			BindingResult results, @RequestParam String action,
			Map<String, Object> map,HttpServletRequest request) {
		Products productResult = new Products();
		switch (action) {
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
	*/

	@RequestMapping("/viewProduct")
	public String getProductById(@RequestParam("productId") int productId, Model model){
		Products p = productsService.getProduct(productId);
		model.addAttribute("product", p);
		return "viewProduct";
	}
	
	@RequestMapping("/delete")
	 public String deleteUser(@RequestParam int productId) {
		productsService.delete(productId);
	  return "redirect:products";
	 }
	
	@ModelAttribute("edit")
	public Products sayHello()
	{
		return new Products();	
	}
	@RequestMapping(value="/editProduct",method=RequestMethod.GET)
	public String editProductById(@RequestParam("productId") Products p, Model model){		
		productsService.add(p);
		model.addAttribute("product",p);
		return "editProduct";
	}
	 
	 @RequestMapping(value="/admin/editProcess", method=RequestMethod.POST)
	    public ModelAndView edditingTeam(@ModelAttribute Products product, @PathVariable Integer id) {
	         
	        ModelAndView modelAndView = new ModelAndView("products");
	         product=new Products();
	        productsService.edit(product);    
	        return modelAndView;
	    }
}
