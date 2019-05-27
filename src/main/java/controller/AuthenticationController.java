package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GenericDao;
import model.Usuario;
import model.LogInfo;

@WebServlet("/login")
public class AuthenticationController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public AuthenticationController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = request.getParameter("tEleitor");
		String senha = request.getParameter("senha");
		
		GenericDao dao = new GenericDao();
		Usuario user = (Usuario) dao.findUser(titulo);
		String url = "";
		if(user != null && user.getSenha().equals(senha))
		{
			if(user.getNivel() == 1)
			{
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");					
				url = "votar/votacao.view.jsp";
			}
			else if(user.getNivel() == 2)
			{
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");	
				url = "autorizacao/autorizar.view.jsp";				
			}

			LogInfo log = new LogInfo();
			log.setActionDate();
			log.setActionTime();
			log.setLogId();
			log.setUserId(user.getTitulo());
			log.setDescription("O usuário de titulo " + user.getTitulo() + " fez login no sistema com nível de acesso igual a " + user.getNivel());
			dao.saveLog(log);
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
