package com.corejava.multithreading;
   class MyThread1 implements Runnable 
  {
	  public void run()
	  {
		  for(int i=1;i<=100;i++)
			  System.out.println(i);
	  }               
  }
public class ThreadDevlopmentInterface {

	public static void main(String[] args) {
		
				MyThread1 my=new MyThread1();
				Thread t1=new Thread(my);
		        t1.start();
		}

}
