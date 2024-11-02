package java8StreamSorting;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortingDemo {

	public static void main(String[] args) {

		List<String> fruits = new LinkedList<>();
		
		fruits.add("ORANGE");
		fruits.add("BANANA");
		fruits.add("GRAPES");
		fruits.add("APPLE");
		fruits.add("AVACADO");
		fruits.add("MANGO");
		fruits.add("BLUE-BERRIES");
		
		System.out.println(fruits.stream().
				sorted(Comparator.naturalOrder()).
				collect(Collectors.toList()));

		System.out.println("---------------------------------------------------------------------");
		fruits.stream().
		sorted(Comparator.naturalOrder()).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("----------------------------------------------------------------------");
		fruits.stream().
		sorted((o1,o2)->o1.compareTo(o2)).//Lambda Expression with compareTo
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		
		System.out.println("----------------------------------------------------------------------");
		fruits.stream().
		sorted().
		collect(Collectors.toList()).
		forEach(System.out::println);
	}

}
