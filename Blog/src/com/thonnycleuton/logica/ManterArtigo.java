package com.thonnycleuton.logica;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thonnycleuton.dao.*;
import com.thonnycleuton.entity.Artigo;
import com.thonnycleuton.entity.Usuario;

@WebServlet(urlPatterns="/administrator/artigo")
public class ManterArtigo extends HttpServlet {
	
	@SuppressWarnings("unchecked")
	@Override
	protected void service (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		GenericDAO dao = new GenericJPADAO();
		List <Artigo> artigos = null;
		Artigo artigo;
		int id;
		
		RequestDispatcher dispatcher = null;
		String acao = req.getParameter("acao");
		
		if (acao.equals("list")){
			artigos = dao.find(Artigo.class);
			req.setAttribute("artigos", artigos);
			dispatcher = req.getRequestDispatcher("index.jsp");
		}
		
		if (acao.equals("add")){
			dispatcher = req.getRequestDispatcher("index.jsp");
		}
		
		if (acao.equals("edit")){
			id = Integer.valueOf(req.getParameter("id"));
			artigo = (Artigo) dao.find(Artigo.class, id);
			req.setAttribute("artigo", artigo);
			dispatcher = req.getRequestDispatcher("index.jsp");
		}
		
		if (acao.equals("save")){
			
			artigo = new Artigo();
			Date date = new Date();
			id = Integer.valueOf(req.getParameter("autor"));
			Usuario autor = (Usuario) dao.find(Usuario.class, id);
			
			artigo.setAutor(autor);
			artigo.setTitulo(req.getParameter("titulo"));
			artigo.setConteudo(req.getParameter("conteudo"));
			artigo.setData(date);
			try{
				artigo.setId(Integer.parseInt(req.getParameter("id")));
			}catch (Exception e){
				
			}
			artigo = (Artigo) dao.save(artigo);
			resp.sendRedirect("artigo?acao=list");
		}
		
		if (acao.equals("remove")){
			//Excluir e exibir listagem
			resp.sendRedirect("artigo?acao=list");
		}
		
		if (dispatcher != null)
			dispatcher.forward(req, resp);
	}
}