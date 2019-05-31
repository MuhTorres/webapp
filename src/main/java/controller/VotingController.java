package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AutDao;
import dao.LogDao;
import dao.VotingDao;
import model.Authorization;
import model.Votos;

@WebServlet("/votar")
public class VotingController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public VotingController() 
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		HttpSession session = request.getSession();
		String titulo = (String) request.getParameter("user");
		String candidato = (String) request.getParameter("voto");
		if(titulo == null) titulo = (String) session.getAttribute("titulo");

		Authorization aut = new AutDao().find(titulo);

		if(aut != null)
		{
			if(aut.getPodeVotar() == 'Y' && aut.getJaVotou() == 'N')
			{				
				Votos voto = new Votos();
				voto.setCandidato(Integer.parseInt(String.valueOf(candidato)));
				voto.setTitulo(aut.getTitulo());

				new VotingDao().save(voto);

				aut.setJaVotou('Y');
				new AutDao().save(aut);

				new LogDao().createAndSave(titulo, "O usuario votou no candidado de numero " + candidato == null ? "" : candidato);

				int nivel = (int) Integer.parseInt(String.valueOf(session.getAttribute("nivel")));
				session.setAttribute("titulo", titulo);
				session.setAttribute("nivel", nivel);
				
				request.getRequestDispatcher("/dashboards/Dashboard.view.jsp").forward(request, response);	
				response.getWriter().flush();	
			}
			else
			{
				new LogDao().createAndSave(titulo, "O usuario tentou votar mas nao esta autorizado!");
				response.getWriter().println("<script type=\"text/javascript\"> alert('Voce nao esta autorizado a votar!'); </script>");	
				request.getRequestDispatcher("/dashboards/Dashboard.view.jsp").forward(request, response);	
				response.getWriter().flush();	
			}
		}
		else
		{
			new LogDao().createAndSave(titulo, "O usuario tentou votar mas nao esta autorizado!2");
			response.getWriter().print("<script type=\"text/javascript\"> alert('Voce nao esta autorizado a votar!'); </script>");		
			request.getRequestDispatcher("/dashboards/Dashboard.view.jsp").forward(request, response);	
			response.getWriter().flush();	
		}
	}
}
