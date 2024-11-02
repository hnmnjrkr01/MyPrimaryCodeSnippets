package com.kani.java8.datetime;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test {
	
	public static void main(String[] args) {
		
		BufferedReader ins = null;
		PrintWriter outs = null;
		
		try {
			outs = new PrintWriter(new FileWriter("tt"));
			ins = new BufferedReader(new FileReader("tt"));
			
			Stream.of("RED","GREEN","BLUE").forEach(outs::println);
			outs.flush();
			

				List<String> l = ins.lines().collect(Collectors.toList());
				l.stream().forEach(System.out::println);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
 