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

                                                   
		String hql = "SELECT U.urunAdi, SUM(U.urunFiyati) " + 
				     "FROM Urun U " +
	                 "GROUP BY U.urunAdi";
		
		Query query = session.createQuery(hql);
		
		List<?> list = query.list();
		System.out.println("Kay�t say�s� : " + list.size());
		Iterator<?> iterator = list.iterator();

		while(iterator.hasNext())
		{
			Object o[] = (Object[])iterator.next();
						
			System.out.println("�r�n Ad� : "+o[0]+ " - Toplam Fiyat�: "+o[1]);                           
						
			System.out.println("----------------");
		}				
		session.close();
		factory.close();
	}
}

