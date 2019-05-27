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

@WebServlet("/votar")
public class VotingController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public VotingController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//request.getRequestDispatcher("log/log.view.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String titulo = request.getParameter("usuario");
		//String candidato = request.getParameter("candidato");
		
		GenericDao dao = new GenericDao();
		Dictionary<String, String> dic = new Hashtable<String, String>(); 
		dic.put("USER_ID", titulo);

		Authorization authorization =  dao.findAuthorization(dic);
		if(authorization == null)
		{
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");	
		}
	}
}
