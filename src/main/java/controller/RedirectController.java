package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LogDao;
import model.LogInfo;

@WebServlet("/redirect")
public class RedirectController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public RedirectController() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		HttpSession session = request.getSession();
		String pagina = request.getParameter("pagina");
        String titulo = (String) session.getAttribute("titulo");
		saveLog(titulo, "O usuário foi redirecionado para a seguinte url " + pagina);	
		session.setAttribute("titulo", titulo);
		session.setAttribute("nivel", (String) session.getAttribute("nivel").toString());
        request.getRequestDispatcher(pagina).forward(request, response);			
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
