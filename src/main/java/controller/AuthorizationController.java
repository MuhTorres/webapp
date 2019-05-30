package controller;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

import dao.AutDao;
import dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Authorization;
import model.Usuario;

@WebServlet("/autorizar")
public class AuthorizationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AuthorizationController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String usuario = (String) request.getParameter("titulo");
		String titulo = request.getParameter("titulo");
		Gson gson = new Gson();		
		
		AutDao dao = new AutDao();
		Authorization aut = dao.find(titulo);
		int varPassagem = 0;
		
		if(aut != null && aut.getTitulo().equals(titulo))
		{
			Usuario user = dao.find(titulo);
			
			varPassagem = 1;
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			String jsonInString = gson.toJson(user);
			request.setAttribute("usuario", user.getNome());
			request.setAttribute("data", jsonInString);
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Gson gson = new Gson();
		String titulo = request.getParameter("titulo");
		String autBy = request.getParameter("autBy");
		
		AutDao dao = new AutDao();
		Authorization aut = dao.find(titulo);
		int varPassagem = 0;
		
		if(aut != null && aut.getTitulo().equals(titulo))
		{
			Usuario user = dao.find(titulo);
			
			varPassagem = 1;
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			String jsonInString = gson.toJson(user);
			request.setAttribute("usuario", user.getNome());
			request.setAttribute("data", jsonInString);
		}
		
				
		if(varPassagem == 0)
		{
			Authorization authorization = new Authorization();
			authorization.setActionDate();
			authorization.setAutorizadoPor(autBy);
			authorization.setJaVotou('N');
			authorization.setPodeVotar('Y');
			authorization.setTitulo(titulo);
			dao.saveAut(authorization);
		}
	}
}
