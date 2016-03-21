package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mimaraslan.Meslek;
import com.mimaraslan.Personel;

public class HibernateMerkez {

	public static void main(String[] args) {
		
		Personel personel = new Personel();
		personel.setPersonelAdi("Recep Ali");
		personel.setPersonelSoyadi("Tellio�lu");
		personel.setPersonelKayitTarihi(new Date());
		//---------------------------------------------
		Meslek meslek = new Meslek();
		meslek.setMeslekAdi("Oganizat�r");
	
		//---------------------------------------------
		personel.setMeslek(meslek);
		//---------------------------------------------
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			session.save(personel);
			session.save(meslek);
		session.getTransaction().commit();
		session.close();


	}

}
