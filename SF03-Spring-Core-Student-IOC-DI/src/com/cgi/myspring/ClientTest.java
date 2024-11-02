package com.cgi.myspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class ClientTest {

	public static void main(String[] args) { //1.
		                                                 //2
	ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		                            //3
 StudentService gs1=(StudentService)factory.getBean("courseService1");
		   //9
		gs1.allCourses();
		
		//11
		StudentService gs2=(StudentService)factory.getBean("courseService2");
		
		//17
		gs2.allCourses();
		
				
	}  //19
} //20
