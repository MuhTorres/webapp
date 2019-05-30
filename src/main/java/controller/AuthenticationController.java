package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import dao.LogDao;
import dao.UsuarioDao;
import model.LogInfo;
import model.Usuario;

@WebServlet("/autenticar")
public class AuthenticationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AuthenticationController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		HttpSession session = request.getSession();
		Gson gson = new Gson();
		String titulo = request.getParameter("titulo");
		String senha = request.getParameter("senha");
		
		UsuarioDao dao = new UsuarioDao();
		Usuario user = (Usuario) dao.find(titulo);
		
		if(user != null && user.getSenha().equals(senha))
		{
			String descricao = "O usuario de titulo " + titulo + " fez login no sistema com nivel de acesso igual a " + user.getNivel();
			
				response.setStatus(HttpServletResponse.SC_OK);	
				saveLog(titulo, descricao);	
				String userString = gson.toJson(user);	
				session.setAttribute("usuario", userString);				
				session.setAttribute("titulo", user.getTitulo());
				session.setAttribute("nivel", user.getNivel());
				request.setAttribute("nivel", user.getNivel());
				
				session.setMaxInactiveInterval(120);
				request.getRequestDispatcher("dashboards/Dashboard.view.jsp").forward(request, response);						

			dao.destroy();
			titulo = null;
			senha = null;
			user = null;
			dao = null;
		}
		else
		{
			String url = request.getHeader("referer");
			request.getRequestDispatcher("").forward(request, response);	
			
			response.getWriter().print("<script>alert('Usuario nao encontrado');</script>");
			dao.destroy();
			titulo = null;
			senha = null;
			user = null;
			dao = null;
		}
	}

	public void saveLog(String titulo, String descricao)
	{
		LogDao lDao = new LogDao();
		LogInfo log = new LogInfo();
		log.setActionDate();
		log.setActionTime();
		log.setLogId();
		log.setUserId(titulo);
		log.setDescription(descricao);
		lDao.saveLog(log);
		lDao.destroy();
	}
}
