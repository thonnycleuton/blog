package com.thonnycleuton.logica;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thonnycleuton.dao.GenericDAO;
import com.thonnycleuton.dao.GenericJPADAO;
import com.thonnycleuton.entity.Artigo;
import com.thonnycleuton.entity.Usuario;

@WebServlet(urlPatterns="/administrator/usuario")
public class ManterUsuario extends HttpServlet{
	
	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		GenericDAO dao = new GenericJPADAO();
		List <Usuario> usuarios = null;
		Usuario usuario;
		int id;
		
		RequestDispatcher dispatcher = null;
		String acao = req.getParameter("acao");
		
		if (acao.equals("list")){
			usuarios = dao.find(Usuario.class);
			req.setAttribute("usuarios", usuarios);
			dispatcher = req.getRequestDispatcher("index.jsp");
		}
		
		if (acao.equals("add")){
			dispatcher = req.getRequestDispatcher("index.jsp");
		} 
		
		if (acao.equals("edit")){
			id = Integer.valueOf(req.getParameter("id"));
			usuario = (Usuario) dao.find(Usuario.class, id);
			req.setAttribute("artigo", usuario);
			dispatcher = req.getRequestDispatcher("index.jsp");
		}

		if (acao.equals("save")){
			
			usuario = new Usuario();
			usuario.setNome(req.getParameter("nome"));
			usuario.setEmail(req.getParameter("email"));
			usuario.setPassword(req.getParameter("password"));
			try{
				usuario.setId(Integer.parseInt(req.getParameter("id")));
			}catch (Exception e){
				
			}
			usuario = (Usuario) dao.save(usuario);
			resp.sendRedirect("usuario?acao=list");
		}
		
		if (acao.equals("remove")){
			//Excluir e exibir listagem
			resp.sendRedirect("usuario?acao=list");
		}
		
		if (dispatcher != null)
			dispatcher.forward(req, resp);
	}
}