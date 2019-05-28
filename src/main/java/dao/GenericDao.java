package dao;

import java.util.List;
import model.*;
import org.hibernate.Session;

public abstract class GenericDao {
	protected Session session;

	public void init()
	{
		this.session = new Factory().getConnection();
	}

	public void destroy()
	{
		this.session.close();
	}
	
	public abstract <T> T find(String id);

	public abstract <T> List<T> findAll();

	public abstract <T> void save(T t);
	
	public List<LogInfo> findAllLogs()
	{	
		List<LogInfo> obj = session.createQuery("SELECT l FROM LOG l", LogInfo.class).getResultList();	

		return obj;
	}
	
	public List<Authorization> findAllAut()
	{	
		List<Authorization> obj = session.createQuery("SELECT a FROM AUTORIZACAO a", Authorization.class).getResultList();	

		return obj;
	}
	
	public void saveLog(LogInfo log)
	{
		try 
		{
			session.getTransaction().begin();
			session.persist(log);
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			session.getTransaction().rollback();
		}	
	}
	
	public void saveAut(Authorization obj)
	{	
		try 
		{
			session.getTransaction().begin();
			session.persist(obj);
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			session.getTransaction().rollback();
		}		
	}
}
