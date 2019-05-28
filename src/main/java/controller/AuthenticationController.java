package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.LogDao;
import dao.UsuarioDao;
import model.LogInfo;
import model.Usuario;

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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		Gson gson = new Gson();
		String titulo = request.getParameter("titulo");
		String senha = request.getParameter("senha");
		
		UsuarioDao dao = new UsuarioDao();
		Usuario user = (Usuario) dao.find(titulo);

		if(user != null && user.getSenha().equals(senha))
		{
			String descricao = "O usuario de titulo " + titulo + " fez login no sistema com nivel de acesso igual a " + user.getNivel();
			if(user.getNivel() == 1)
			{				
				response.setStatus(HttpServletResponse.SC_OK);
				//url = "votar/votacao.view.jsp";			
				saveLog(titulo, descricao);	
				//request.getSession().setAttribute("usuario", user);								
				//request.getSession().setAttribute("data", jsonInString);
				String jsonInString = gson.toJson(user);	
				response.getWriter().print(jsonInString);
				response.setStatus(HttpServletResponse.SC_OK);
				response.getWriter().flush();
			}
			else if(user.getNivel() == 2)
			{
				//url = "autorizacao/autorizar.view.jsp";		
				saveLog(titulo, descricao);	
				//request.getSession().setAttribute("usuario", user);									
				//request.getSession().setAttribute("url", url);
				String jsonInString = gson.toJson(user);	
				PrintWriter pw = response.getWriter();
				pw.print(jsonInString);	
				response.setStatus(HttpServletResponse.SC_OK);
				pw.flush();
			}			

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
