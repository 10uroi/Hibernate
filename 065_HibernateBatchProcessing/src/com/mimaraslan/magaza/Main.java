package com.mimaraslan.magaza;

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.criterion.Projections;

public class Main {
	public static void main(String[] args) {		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		@SuppressWarnings("deprecation")
		SessionFactory sessionFactory = cfg.buildSessionFactory();

/*//
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		for ( int i=0; i<100000; i++ ) {                               
		    Urun urun = new Urun();
		    session.save(urun);
		    
		    if ( i % 25 == 0 ) {   							
		        session.flush(); 
		        session.clear(); 
		    } 
		}
	
		tx.commit();
		session.close();
	*/	
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
								//SORGUYU BURADA KEND�M�Z YAZDIK
/*
  ScrollableResults urunCursor = session.createQuery("FROM URUN")
  .scroll(); 
*/ //SUNUCU TARAFINDAK� KAYITLARI GEZERKEN scroll KULLANIYORUZ

		
										  //SORGUYU �S�MLE ALDIK
  ScrollableResults urunCursor = session.getNamedQuery("GetUrun") 
			    .setCacheMode(CacheMode.IGNORE)
			    .scroll(ScrollMode.FORWARD_ONLY);
 
			int sayac=0; //SAYA�
			
			while ( urunCursor.next() ) { //B�R SONRAK� KAYIT
				Urun urun = (Urun) urunCursor.get(0);
				//urun.guncelleUrun(); //KEND� METODUMUZLA DA G�NCELLEYEN�L�RD�K
				session.update(urun); //OTURUM NESNES� �ZER�NDEN G�NCELLE
			    if ( ++sayac % 25 == 0 ) {  //SAYA�I MOD 25'E G�RE ��LE
			        session.flush();  //TRANSACTION ARALARINDA 
			        				  //�NBELLKETEK� VER�LER� KALICI HALE GET�R.
			        session.clear();  
			        //�NBELLKEKTE ���ME OLMASIN D�YE 
			        //��� B�TEN NESNELER� Y�NET�ML� OLMADAN �IKAR.
			    }
			}
			
			tx.commit();
			session.close();	
    }
}
