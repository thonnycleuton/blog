package com.thonnycleuton.logica;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thonnycleuton.dao.GenericDAO;
import com.thonnycleuton.dao.GenericJPADAO;
import com.thonnycleuton.entity.Usuario;

@WebServlet (urlPatterns="/userlogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GenericDAO dao = new GenericJPADAO();
	List usuarioLista;
	Usuario usuario;
	
	public void init() throws ServletException {
		
	}
	
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");


		String queryName = "select a from Usuario a where nome='" + username
				+ "'";
		
		usuarioLista = dao.find(queryName);
		
		for (Iterator iterator = usuarioLista.iterator(); iterator.hasNext();) {
			usuario = (Usuario) iterator.next();
		}
		
		String userPassword = usuario.getPassword();
		
		if(userPassword!=null && userPassword.equals(password)) {
			request.getSession().setAttribute("usuario", username);
			response.sendRedirect("administrator/");
		}
		else {
			request.setAttribute("message", "Nome de usuário ou senha inválidos");
			getServletContext().getRequestDispatcher("/loginForm.jsp")
				.forward(request, response);
		}
	}
}