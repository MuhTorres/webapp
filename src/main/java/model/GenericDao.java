package model;

import java.util.Dictionary;
import java.util.List;

import javax.persistence.EntityManager;

public class GenericDao {
	//private Session session;
	private EntityManager session;
	
	public GenericDao()
	{
		//this.session = new Factory().getConnection();
		//this.session = new Factory().startConnection();
	}
	
	public Usuario findUser(String id)
	{
		this.session = new Factory().startConnection();
		Usuario usuario = null;

		//session.getTransaction().begin();
		usuario = session.find(Usuario.class, id);        
        //session.getTransaction().commit();
        this.session.close();
        return usuario;		
	}
	
	public List<LogInfo> findAllLogs()
	{	
		this.session = new Factory().startConnection();
		List<LogInfo> obj = session.createQuery("SELECT * FROM LOG", LogInfo.class).getResultList();	

        this.session.close();
		return obj;
	}
	
	public void saveLog(LogInfo log)
	{
		this.session = new Factory().startConnection();
		try 
		{
			session.getTransaction().begin();
			session.persist(log);
			session.getTransaction().commit();
	        this.session.close();
		} 
		catch (Exception e) 
		{
			session.getTransaction().rollback();
	        this.session.close();
		}	
	}

	public Authorization findAuthorization(Dictionary<String, String> dictionary)
	{
		this.session = new Factory().startConnection();
		Authorization aut = null;

		session.getTransaction().begin();
		aut = session.find(Authorization.class, dictionary);
        session.getTransaction().commit();

        this.session.close();
        return aut;		
	}

	public void save(Object obj)
	{	
		this.session = new Factory().startConnection();
		try 
		{
			session.getTransaction().begin();
			session.persist(obj);
			session.getTransaction().commit();

	        this.session.close();
		} 
		catch (Exception e) 
		{
			session.getTransaction().rollback();
	        this.session.close();
		}		
	}
}
