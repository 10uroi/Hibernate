package com.mimaraslan.magaza;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
public class Main {
	public static void main(String[] args) {		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		@SuppressWarnings("deprecation")
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

	  //String hql = "FROM Urun M WHERE M.id = 2";                                            
		String hql = "FROM Urun M WHERE M.id = :parametre";  
		
		Query query = session.createQuery(hql); 
		
		query.setParameter("parametre",3); 
		
		List<?> list = query.list();
		System.out.println("Kay�t say�s� : " + list.size());
		Iterator<?> iterator = list.iterator();

		while (iterator.hasNext()) {
			System.out.println("---------------");
			Object o = (Object) iterator.next();
			Urun urun = (Urun) o;
			System.out.println("�r�n Ad�    : " + urun.getUrunAdi());
			System.out.println("�r�n Fiyat� : " + urun.getUrunFiyati());
			System.out.println("---------------");
		}
		session.close();
		factory.close();
	}
}

