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
			Adres adres = new Adres("F.S.M. Caddesi", 
									"Ankara", "Merkez", "341453");
			// cascade=all kullan�lmamas�na ra�men adres kaydedilir
		    // session.save(adres);
			
			Ogrenci ogrenci1 = new Ogrenci("�mer Karaca", adres);
			Ogrenci ogrenci2 = new Ogrenci("Recep �zcan", adres);
	
			session.save(ogrenci1);
			session.save(ogrenci2);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}








