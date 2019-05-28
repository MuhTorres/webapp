package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		Gson gson = new Gson();
		String titulo = request.getParameter("titulo");
		String senha = request.getParameter("senha");
		
		GenericDao dao = new GenericDao();
		Usuario user = (Usuario) dao.findUser(titulo);
		String url = "";
		if(user != null && user.getSenha().equals(senha))
		{
			String descricao = "O usuario de titulo " + titulo + " fez login no sistema com nivel de acesso igual a " + user.getNivel();
			if(user.getNivel() == 1)
			{				
				response.setStatus(HttpServletResponse.SC_OK);
				//url = "votar/votacao.view.jsp";			
				saveLog(titulo, descricao, dao);	
				//request.getSession().setAttribute("usuario", user);								
				//request.getSession().setAttribute("data", jsonInString);
				String jsonInString = gson.toJson(user);	
				response.getWriter().print(jsonInString);
				response.getWriter().flush();
			}
			else if(user.getNivel() == 2)
			{
				response.setStatus(HttpServletResponse.SC_OK);
				//url = "autorizacao/autorizar.view.jsp";		
				saveLog(titulo, descricao, dao);	
				//request.getSession().setAttribute("usuario", user);									
				//request.getSession().setAttribute("url", url);
				String jsonInString = gson.toJson(user);	
				PrintWriter pw = response.getWriter();
				pw.print(jsonInString);	
				pw.flush();
			}					
			dao.CloseConnection();
			titulo = null;
			url = null;
			senha = null;
			user = null;
			dao = null;
		}
	}

	public void saveLog(String titulo, String descricao, GenericDao dao)
	{
		LogInfo log = new LogInfo();
		log.setActionDate();
		log.setActionTime();
		log.setLogId();
		log.setUserId(titulo);
		log.setDescription(descricao);
		dao.saveLog(log);
	}
}
