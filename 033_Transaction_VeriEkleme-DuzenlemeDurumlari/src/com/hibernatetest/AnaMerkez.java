package com.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mimaraslan.Personel;

public class AnaMerkez {
	public static void main(String[] args) {	
			
	Personel personel = new Personel();	 
		
		personel.setPersonelAdi("Dilek");
		personel.setPersonelSoyadi("�zl�");
		
SessionFactory sessionFactory 
= new Configuration().configure().buildSessionFactory();
Session session = sessionFactory.openSession();
//-----------------------------------------------
	session.beginTransaction(); 	
		personel.setPersonelAdi("K�bra");   
		personel.setPersonelSoyadi("Kendirli");  
		session.save(personel);               
	session.getTransaction().commit();
	session.close();	
	
	System.out.println("Ekleme sonras� : " + 
						personel.getPersonelAdi() +" "+ 
						personel.getPersonelSoyadi() );		
//-----------------------------------------------
	session = sessionFactory.openSession();     
	session.beginTransaction();                               
		personel.setPersonelAdi("Zehra");   
		personel.setPersonelSoyadi("K�ra�");  
		session.update(personel);											
	session.getTransaction().commit();
	session.close();	

	System.out.println("G�nceleme sonras� : " + 
						personel.getPersonelAdi() +" "+ 
						personel.getPersonelSoyadi() );	
	}
}


















