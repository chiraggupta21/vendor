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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maven.entity.Vendor;
import com.maven.service.VendorService;

@Controller
@RequestMapping("/vend")
public class VendorController {
	
	@Autowired
	private VendorService vservice;
	
	@GetMapping("/list")
	public String listAllVendors(Model model){
		List<Vendor> l = vservice.listAllVendors();
		model.addAttribute("vendors",l);
		return "vendorList";
	}
	
	@GetMapping("/view")
	public String viewVendor(@RequestParam("vendId")int id,Model model){
		Vendor vend = vservice.getVendor(id);
		model.addAttribute("temp",vend);
		return "viewVendor";
	}
	
	@GetMapping("/logout")  
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {  
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();  
        if (auth != null){      
           new SecurityContextLogoutHandler().logout(request, response, auth);  
        }  
         return "redirect:/login";  
     }
}
