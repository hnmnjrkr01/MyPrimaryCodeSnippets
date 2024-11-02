package javaStream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class CreateStreamDemo {
	
	public static void main(String[] args) {
		
		Stream<String> stream1 = Stream.of("a","b","c","d","e");
		stream1.forEach(System.out::println);
		
		Collection<String> collection = Arrays.asList("JAVA","PYTHON","J2EE","SPRING","SQL","mONGO-DB");
		collection.stream().forEach(System.out::println);
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		list.stream().forEach(System.out::println);
		
		Set<String> set = new HashSet<>(collection);
		set.stream().forEach(System.out::println);
		
		int array[]= {1,2,3,4,5};
		IntStream stream2 = Arrays.stream(array);
		stream2.forEach(System.out::println);
		
		double arrDouble[]= {1.1,1.2,1.3,1.4,1.5};
		DoubleStream stream3 = Arrays.stream(arrDouble);
		stream3.forEach(System.out::println);

	}

}
