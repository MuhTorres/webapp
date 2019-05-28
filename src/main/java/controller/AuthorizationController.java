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
		String titulo = request.getParameter("titulo");
		Gson gson = new Gson();		
		
		UsuarioDao uDao = new UsuarioDao();
		Usuario user = uDao.find(titulo);
		
		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		//PrintWriter writer = response.getWriter();
		String jsonInString = gson.toJson(user);
		request.setAttribute("usuario", user.getNome());
		request.setAttribute("data", jsonInString);
		response.getWriter().print(jsonInString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Gson gson = new Gson();
		String titulo = request.getParameter("titulo");
		String autBy = request.getParameter("autBy");
		
		UsuarioDao dao = new UsuarioDao();
		List<Authorization> auts = dao.findAllAut();
		int varPassagem = 0;
		for(Authorization aut : auts)
		{
			if(aut.getTitulo().equals(titulo))
			{
				//response.setContentType("application/json");
				Usuario user = dao.find(titulo);
				
				varPassagem = 1;
				response.setStatus(HttpServletResponse.SC_OK);
				response.setContentType("application/json");
		        //PrintWriter writer = response.getWriter();
				String jsonInString = gson.toJson(user);
				request.setAttribute("usuario", user.getNome());
				request.setAttribute("data", jsonInString);
				//response.setCharacterEncoding("UTF-8");	
				response.getWriter().print(jsonInString);
				break;
			}
		}
				
		if(varPassagem == 0)
		{
			Authorization authorization = new Authorization();
			authorization.setAutorizacao();
			authorization.setActionDate();
			authorization.setAutorizadoPor(autBy);
			authorization.setJaVotou('N');
			authorization.setPodeVotar('Y');
			authorization.setTitulo(titulo);
			dao.saveAut(authorization);
		}
	}
}
