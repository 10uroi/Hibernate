package com.mimaraslan.okul;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mimaraslan.util.HibernateUtil;
public class Main {
	public static void main(String[] args) {
		Session session 
			   = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Adres adres = new Adres("Kocaeli �niversitesi Caddesi", 
					"Kocaeli", "K�rfez", "061453");
			// cascade=all kullan�lmamas�na ra�men adres kaydedilir
		    // session.save(adres);
			
			Ogrenci ogrenci1 = new Ogrenci("G�lay K�lek�i", adres);
			Ogrenci ogrenci2 = new Ogrenci("Burcu Tas", adres);
			Ogrenci ogrenci3 = new Ogrenci("Bilal Karahan", adres);
	
			session.save(ogrenci1);
			session.save(ogrenci2);
			session.save(ogrenci3);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}

