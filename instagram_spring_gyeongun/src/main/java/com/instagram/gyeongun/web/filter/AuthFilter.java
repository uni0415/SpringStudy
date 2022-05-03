package com.instagram.gyeongun.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.instagram.gyeongun.domain.user.User;

/**
 * Servlet Filter implementation class AuthFilter
 */
public class AuthFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse)response;
		HttpSession session = httpServletRequest.getSession();
		User user = (User)session.getAttribute("principal");
		
		String path = httpServletRequest.getRequestURI();
		
		if(path.contains("/gyeongun/auth")) {
			if(user!=null) {
				httpServletResponse.sendRedirect("/gyeongun/");
				return;
			}
		}else if(path.contains("/gyeongun/static")) {
			
		}else {
			if(user == null) {
				httpServletResponse.sendRedirect("/gyeongun/auth/signin");
				return;
			}
		}
		
		chain.doFilter(request, response);
	}
	
	public void destroy() {

	}


}
