package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;
import model.Usuario;

@WebServlet("/logs")
public class LogController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public LogController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		request.getRequestDispatcher("log/log.view.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = request.getParameter("tEleitor");
		String senha = request.getParameter("senha");
		
		GenericDao dao = new UsuarioDao();
		Usuario user = (Usuario) dao.find(titulo);
		
		if(user != null && user.getSenha().equals(senha))
		{
			if(user.getNivel() == 1)
			{
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");					
				request.getRequestDispatcher("votar/votacao.view.jsp").forward(request, response);
			}
		}
	}
}
