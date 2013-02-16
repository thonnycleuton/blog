package com.thonnycleuton.logica;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet (urlPatterns="/administrator/userlogout")
public class UserLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException
	{
		execute(request, response);
	}

	private void execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException 
	{
		request.getSession().invalidate();
		response.sendRedirect( request.getContextPath() );
	}
}
