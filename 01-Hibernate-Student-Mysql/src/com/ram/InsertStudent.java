package com.ram;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//Insert Student object as record into DB
public class InsertStudent 
{	 public static void main(String arg[]) 
	{ 	
		Configuration cfg = new Configuration();//1. Strat hibernate frame work
		cfg.configure("hibernate.cfg.xml");  //2. Load hibernate configuration file
		SessionFactory factory = cfg.buildSessionFactory(); //3. Build Session Factory create ,manage pool of connection
		//  Factory object   --
		Session session= factory.openSession();//4. Open Session
		
		    Transaction tx = session.beginTransaction();	//5. Begin Transaction (up to 5 H.A)	
		
		        Student s1 = new Student();
		                s1.setSno(9);
		                s1.setSname("ram");
		                s1.setEmail("ram@gmail.com");
		                s1.setMobile(77777777);
			      session.save(s1);//6. 
			     
			      Student s2 = new Student();
	                s2.setSno(111);
	                s2.setSname("raj");
	                s2.setEmail("raj@gmail.com");
	                s2.setMobile(1111); 
	                session.save(s2);
			      
		//s.flush();//7. Record will inserted but not commited
		
		tx.commit();//8.In this step record will inserted into database
			session.close();
		
	}}