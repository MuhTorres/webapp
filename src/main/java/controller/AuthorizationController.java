package controller;

import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

import dao.AutDao;
import dao.GenericDao;
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
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		if(request.getParameter("javotou").toString().equals("-1"))
			loadAuthorization(request, response);
		else
			saveAuthorization(request, response);		
	}

	public void loadAuthorization(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		String usuario = (String) request.getParameter("usuario");
		Gson gson = new Gson();				
		
		UsuarioDao uDao = new UsuarioDao();
		Usuario user = uDao.find(usuario);
		uDao.destroy();

		AutDao autDao = new AutDao();
		System.out.println(user.getTitulo());
		Authorization aut = autDao.find(user.getTitulo());

		if (aut != null) {
			String javotou = aut.getJaVotou() == 'Y' ? "Sim" : "Nao";
			String liberado = aut.getPodeVotar() == 'Y' ? "Sim" : "Nao";
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json; charset=utf-8");
			String jsonInString = gson.toJson(user);
			request.setAttribute("nome", user.getNome());
			request.setAttribute("usuario", usuario);
			request.setAttribute("javotou", javotou);
			request.setAttribute("liberado", liberado);
			request.setAttribute("usuarioData", jsonInString);			
			request.getRequestDispatcher("/autorizar/autorizar.view.jsp").forward(request, response);	
		} else {

			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json; charset=utf-8");
			String jsonInString = gson.toJson(user);
			request.setAttribute("nome", user.getNome());
			request.setAttribute("usuario", usuario);
			request.setAttribute("javotou", "Nao");
			request.setAttribute("liberado", "Nao");
			request.setAttribute("usuarioData", jsonInString);			
			request.getRequestDispatcher("/autorizar/autorizar.view.jsp").forward(request, response);	
		}
	}

	public void saveAuthorization(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		Gson gson = new Gson();
		String titulo = request.getParameter("usuario");
		String autBy = request.getParameter("func");
		
		GenericDao dao = new AutDao();
		Authorization aut = dao.find(titulo);
		dao.destroy();
		int varPassagem = 0;
		
		if(aut != null && aut.getTitulo().equals(titulo))
		{
			dao = new UsuarioDao();
			Usuario user = dao.find(titulo);
			
			String javotou = aut.getJaVotou() == 'Y' ? "Sim" : "Nao";
			String liberado = aut.getPodeVotar() == 'Y' ? "Sim" : "Nao";
			varPassagem = 1;
			response.setStatus(HttpServletResponse.SC_OK);
			response.setContentType("application/json");
			String jsonInString = gson.toJson(user);
			request.setAttribute("usuario", titulo);
			request.setAttribute("javotou", "Nao");
			request.setAttribute("liberado", "Nao");
			request.setAttribute("nome", user.getNome());
			request.setAttribute("data", jsonInString);
			dao.destroy();
			request.getRequestDispatcher("/autorizar/autorizar.view.jsp").forward(request, response);	
		}		
				
		if(varPassagem == 0)
		{
			dao = new AutDao();
			Authorization authorization = new Authorization();
			authorization.setActionDate();
			authorization.setAutorizadoPor(autBy);
			authorization.setJaVotou('N');
			authorization.setPodeVotar('Y');
			authorization.setTitulo(titulo);
			authorization.setAutorizacao();
			dao.saveAut(authorization);			
			response.getWriter().print("<script>alert('Usuario autorizado!');</script>");
			request.getRequestDispatcher("/autorizar/autorizar.view.jsp").forward(request, response);	
			
		}
	}
}
