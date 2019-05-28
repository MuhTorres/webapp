package dao;

import java.util.List;
import model.LogInfo;;

public class LogDao extends GenericDao 
{
	public LogDao()
	{
		init();
	}
	
	@Override
	public <T> List<T> findAll()
	{	
		List<LogInfo> obj = session.createQuery("SELECT l FROM LOG l", LogInfo.class).getResultList();	

		return (List<T>) obj;
	}

	@Override
	public <T> T find(String id) 
	{
		return null;
	}

	@Override
	public <T> void save(T t) 
	{
		try 
		{
			session.getTransaction().begin();
			session.persist(t);
			session.getTransaction().commit();
		} 
		catch (Exception e) 
		{
			session.getTransaction().rollback();
		}		
	}
}
