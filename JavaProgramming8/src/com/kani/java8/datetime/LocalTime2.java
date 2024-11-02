package com.kani.java8.datetime;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class LocalTime2 {

	public static void main(String[] args) {
		
		LocalDateTime  localdatetime=LocalDateTime.now();
		
		System.out.println(localdatetime.toString());
		
		System.out.println(localdatetime.getDayOfMonth());
		System.out.println(localdatetime.getHour());
		System.out.println(localdatetime.getNano());
		System.out.println(localdatetime.getSecond());
		
	}

}
