package com.ram.hibernate;
//import org.hibernate.cfg.*;
//import org.hibernate.*;
import java.util.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmployeeTestCase {
	private SessionFactory factory;

	public void createEmployee(Employee emp){
		System.out.println("About to create employee");;

		Session session = null;
		Transaction tx = null;

			try {
				session = factory.openSession();
				       System.out.println("here is the session object created " + session);
				      tx=session.beginTransaction();
				    session.save(emp);
				tx.commit();
				System.out.println("Employee Created with empno: " + emp.getEmpno());
			} catch (HibernateException e) {
				// TODO Auto-generated catch block
				tx.rollback();  // if transaction is fail your amount is back 
				System.out.println("exception while creating employee " + e);
				 e.printStackTrace();
			}
			finally{
				session.close();
			}
	}

	public Employee loadEmployee(int empno){
		Session session = null;
		Transaction tx = null;

		  try {
			session = factory.openSession();
			                     //"slect * from employee where empid=1"
			  Employee emp = (Employee) session.load(Employee.class, new Integer(empno));

			  return emp;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
	       System.out.println("employee not found");
	       e.printStackTrace();
	       return null;
		}finally{
			session.close();
		} 
	}

	public void updateEmployee(Employee emp){
		Session session = null;
		Transaction tx = null;

		 try {
			session = factory.openSession();
			 tx = session.beginTransaction();
			 
			 emp.setEname("RAJ");// raj name is updated(because session is not closed)
			 session.update(emp);
			 tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("exception while updating the object");
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public void removeEmployee(Employee emp){

		Session session = null;
		Transaction tx = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.delete(emp); // 
			tx.commit();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while removing the object");
			tx.rollback();
			e.printStackTrace();
		}finally{
			session.close();
		}
	}

	public static void main(String arr[]) throws Exception{
		EmployeeTestCase test = new EmployeeTestCase();
		
		Configuration cfg = new Configuration();
		cfg.configure();
		
		test.factory = cfg.buildSessionFactory();
		
		Employee emp1 = new Employee();
		emp1.setEname("Raju");
		emp1.setSal(900);
		emp1.setHiredate(new Date());
		emp1.setDeptno(10);
		
		test.createEmployee(emp1);
		
		
		
		Employee emp2 = new Employee();
		emp2.setEname("Ramesh");
		emp2.setSal(1100);
		emp2.setHiredate(new Date());
		emp2.setDeptno(20);
		
		test.createEmployee(emp2);

		Employee emp = test.loadEmployee(1);
		if(emp!=null){
			System.out.println("Employee name: " + emp.getEname());
			System.out.println("Employee sal: " + emp.getSal());
			System.out.println("Employee hire date: " + emp.getHiredate());
			System.out.println("Employee dept no: " + emp.getDeptno());
		}
		emp = test.loadEmployee(2);
		if(emp!=null){
			System.out.println("Employee name: " + emp.getEname());
			System.out.println("Employee sal: " + emp.getSal());
			System.out.println("Employee hire date: " + emp.getHiredate());
			System.out.println("Employee dept no: " + emp.getDeptno());
		}
		
		
		
		/*
		  if(emp!=null){ System.out.println("Employee name: " + emp.getEname());
		  System.out.println("Employee sal: " + emp.getSal());
		  System.out.println("Employee hire date: " + emp.getHiredate());
		  System.out.println("Employee dept no: " + emp.getDeptno()); }
		 
		 */
		
		
		  if(emp!=null)
		  { 
			  test.removeEmployee(emp); 
			  }  
		 

	}

}
