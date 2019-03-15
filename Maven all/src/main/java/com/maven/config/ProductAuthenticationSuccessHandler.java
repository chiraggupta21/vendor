package com.maven.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class ProductAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	//default login web page as per the roles
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		authorities.forEach(authority -> {
			if(authority.getAuthority().equals("ROLE_USER")){
				try{
					redirectStrategy.sendRedirect(request, response, "/prod/list");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else if(authority.getAuthority().equals("ROLE_ADMIN")){
				try{
					redirectStrategy.sendRedirect(request, response, "/admin");
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			else{
				throw new IllegalStateException();
			}
		});
	}
	
}
