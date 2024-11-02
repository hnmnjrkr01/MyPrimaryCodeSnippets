package com.corejava.multithreading;
  class MyThread extends Thread
  {
	  public void run()
	  {
		  for(int i=1;i<=100;i++)
			  System.out.println(i);
	  }
  }
public class ThreadDevlopment {

	public static void main(String[] args) {
		
		
		MyThread m1=new MyThread();
		m1.start();
		MyThread m2=new MyThread();
		m2.start();
		
		}

}
