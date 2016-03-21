package com.hibernatetest;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mimaraslan.Personel;

public class HibernateDeneme {

	public static void main(String[] args) {
		
		Personel personel = new Personel();
		personel.setPersonelId(1);
		personel.setPersonelAdi("Mimar");
		personel.setPersonelSoyadi("Aslan");
		personel.setPersonelKayitTarihi(new Date());
		personel.setPersonelAdresi("Ukrayna Donetsk");
		//---------------------------------------------
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
			session.save(personel);
		session.getTransaction().commit();
		
		session.close();
		//---------------------------------------------
		personel = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		personel = (Personel) session.get(Personel.class, 1);
		System.out.println("ID : " + personel.getPersonelId());
		System.out.println("ADI SOYADI : " + personel.getPersonelAdi() + " " + personel.getPersonelSoyadi());
		System.out.println("KAYIT TAR�H�  : " + personel.getPersonelKayitTarihi());
		System.out.println("ADRES�  : " + personel.getPersonelAdresi());

		session.close();
		
		

	}

}
