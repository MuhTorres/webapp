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
		List<LogInfo> obj = session.createQuery("SELECT l FROM LOG l ORDER BY l.actionTime", LogInfo.class).getResultList();	

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

	public void createAndSave(String titulo, String descricao)
	{
		LogInfo log = new LogInfo();
		log.setActionDate();
		log.setActionTime();
		log.setLogId();
		log.setUserId(titulo);
		log.setDescription(descricao);
		save(log);
	}
}
