package com.thonnycleuton.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns="/*")
public class Filtro implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		String recurso = ((HttpServletRequest)req).getRequestURI();
		String acao = ((HttpServletRequest)req).getParameter("acao");
		System.out.println("LOG: Filtro in action!!!");
		System.out.println("\tAcessando Recurso: " + recurso);
		System.out.println("\tAcessando Acao: " + acao);
		
		if (((HttpServletRequest)req).getSession().getAttribute("usuario") == null 
				&& recurso.equals("/projeto-montadora/montadora") 
					&& !acao.equals("list")){
			System.out.println("\tAcesso Negado!");
			//((HttpServletResponse)resp).sendRedirect("montadora?acao=list");
			((HttpServletResponse)resp).getWriter().println("ACESSO NEGADO!");
		}else {
			System.out.println("\tAcesso Liberado!");
			System.out.println("--------------------------------");
			chain.doFilter(req, resp);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	
		
	

}
