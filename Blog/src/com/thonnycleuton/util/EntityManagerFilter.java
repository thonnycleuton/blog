package com.thonnycleuton.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="opensessioninview",urlPatterns="/*")
public class EntityManagerFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			JPAUtil.getCurrentEntityManager().getTransaction().begin();
			chain.doFilter(req, resp);
			JPAUtil.getCurrentEntityManager().getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle excetion
			JPAUtil.getCurrentEntityManager().getTransaction().rollback();
			e.printStackTrace();
			new ServletException(e);
		}finally{
			JPAUtil.closeCurrentEntityManager();
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {}
	public void destroy() {}
}
