package com.mimaraslan.magaza;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
public class Main { 
	public static void main(String[] args)
	{		
		Configuration cfg = new Configuration();                     
		cfg.configure("hibernate.cfg.xml");                                           
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();						
//Query query = session.createQuery("from Urun    u");  
//Query query = session.createQuery("from Urun AS u");  
//Query query = session.createQuery("FROM Urun    u");                                      	
//Query query = session.createQuery("FROM Urun AS u");    
		
  String hql = "FROM Urun AS U";  
  Query query = session.createQuery(hql);  
  
		List<?> list =query.list();
		System.out.println("Kay�t say�s� : "+list.size());		
		Iterator<?> it = list.iterator();
		
		while(it.hasNext())
		{
			Object o = (Object)it.next();
			Urun urun = (Urun)o;
			System.out.println("�r�n id : "+urun.getUrunId());
			System.out.println("�r�n Ad� : "+urun.getUrunAdi());
			System.out.println("�r�n Fiyat� : "+urun.getUrunFiyati());
			System.out.println("----------------------");
		}				
		session.close();
		factory.close();
	}
}







