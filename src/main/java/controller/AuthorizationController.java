package controller;

import java.io.IOException;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Authorization;
import model.GenericDao;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = request.getParameter("titulo");
		String autBy = request.getParameter("autBy");
		
		GenericDao dao = new GenericDao();
		Dictionary<String, String> dic = new Hashtable<String, String>(); 
		dic.put("USER_ID", titulo);

		Authorization authorization =  dao.findAuthorization(dic);

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");	
		response.getWriter().print("{data: {nome: "+ titulo + "}}");
		
		if(authorization == null)
		{
			authorization = new Authorization();
			authorization.setAutorizacao();
			authorization.setActionDate();
			authorization.setAutorizadoPor(autBy);
			authorization.setJaVotou('N');
			authorization.setPodeVotar('Y');
			authorization.setTitulo(titulo);
			dao.save(authorization);
		}
	}
}
