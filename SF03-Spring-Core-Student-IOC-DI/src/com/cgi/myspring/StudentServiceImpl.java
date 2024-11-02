package com.cgi.myspring;

public class StudentServiceImpl implements StudentService {
  String courses; //8.  MacAir2021M1   16. MacPro2021M1 
	
    public StudentServiceImpl() {
	
    }                             //6. MacAir2021M1
   public StudentServiceImpl(String courses)
   {
	   this.courses=courses;  //7 MacAir2021M1
   }                        
   
              //14
    public void setCourses(String courses)
    {
    	this.courses=courses; //15 MacPro2021M1
    }
   
	   //10      //18
    public void allCourses() {
		System.out.println("Your Courses:"+courses);
		
		
	}
	
	

}
