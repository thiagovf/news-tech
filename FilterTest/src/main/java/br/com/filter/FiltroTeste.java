package br.com.filter;

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

public class FiltroTeste implements Filter {
	
//	private FilterConfig config;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		HttpServletResponse httpResponse = (HttpServletResponse)response;
		
		HttpSession session = httpRequest.getSession(false);// don't create if it doesn't exist
		Object usuarioObj = session.getAttribute("usuario");
		if(session != null && !session.isNew() && usuarioObj != null) {
			request.setAttribute("usuario", usuarioObj);
		    chain.doFilter(request, response);
		} else {
			httpResponse.sendRedirect("login.jsp");
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	    System.out.println("Instance created of " + getClass().getName());
//	    this.config = filterConfig;
	}

}
