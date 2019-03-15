package com.maven.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maven.entity.Product;
import com.maven.service.ProductService;

@Controller
@RequestMapping("/prod")
public class ProductController {
	@Autowired
	private ProductService pservice;
	
	//To list all the products
	@GetMapping("/list")
	public String listAllProducts(Model model){
		List<Product> l = pservice.listAllProducts();
		//System.out.println("Product list = "+l);
		model.addAttribute("products",l);
		return "productList";
	}
	
	//Form to add new Product
	@GetMapping("/addForm")
	public String showForm(Model model){
		Product prod = new Product();
		model.addAttribute("temp",prod);
		return "form";
	}
	
	//Saving product into database
	@PostMapping("/saveProd")
	public String saveProduct(@ModelAttribute("product") Product prod){
		pservice.saveProduct(prod);
		return "redirect:/prod/list";
	}
	
	//Form to update Product
	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("prodId")int id,Model model){
		Product prod = pservice.getProduct(id);
		model.addAttribute("temp",prod);
		return "form";
	}
	
	//Deleting product
	@GetMapping("/delete")
	public String deleteProduct(@RequestParam("prodId")int id){
		pservice.deleteProduct(id);
		return "redirect:/prod/list";
	}
	
	//To logout of the session
	@GetMapping("/logout")  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login";  
     }
	
	@GetMapping("/view")
	public String viewProduct(@RequestParam("prodId")int id,Model model){
		Product prod = pservice.getProduct(id);
		model.addAttribute("temp",prod);
		return "viewProduct";
	}
}
