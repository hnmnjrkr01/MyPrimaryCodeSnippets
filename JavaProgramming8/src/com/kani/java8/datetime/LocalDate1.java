package com.kani.java8.datetime;

import java.time.LocalDate;

public class LocalDate1 {

	public static void main(String[] args) {
		
		LocalDate  localdate=LocalDate.now();
		
		System.out.println(localdate.toString());
		
		System.out.println(localdate.getDayOfMonth());
		System.out.println(localdate.getDayOfYear());
		System.out.println(localdate.getDayOfMonth());
		System.out.println(localdate.getDayOfWeek().toString());
		System.out.println(localdate.isLeapYear());

	}

}
