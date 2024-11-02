package java8StreamSorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeStreamSort {

	public static void main(String[] args) {

		
		List<Employee> employeeList = new ArrayList<>();
		
		employeeList.add(new Employee(4, 40, "Sushil Kekre", 75000f));
		employeeList.add(new Employee(3, 35, "Sona Kekre", 55000f));
		employeeList.add(new Employee(8, 28, "Vibhore Manjrekar", 110000f));
		employeeList.add(new Employee(2, 30, "Purva Pagnis", 35000f));
		employeeList.add(new Employee(1, 20, "Neha Manjrekar", 25000f));
		employeeList.add(new Employee(5, 45, "Heena Manjekar", 65000f));
		employeeList.add(new Employee(6, 56, "Gauri Kekre", 80000f));
		employeeList.add(new Employee(7, 77, "Gaurav Kekre", 100000f));

		//Sorting the list 
		List<Employee> sortedEmployeeList = employeeList.stream().sorted(new Comparator<Employee>() {
			public int compare(Employee emp1, Employee emp2) {
				return (int) (emp1.getSalary()-emp2.getSalary());
			}}).collect(Collectors.toList());
		sortedEmployeeList.forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------------");	
		employeeList.stream().
		sorted((e1,e2)->(int)(e1.getSalary()-e2.getSalary())).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------------");	
		employeeList.stream().
		sorted(Comparator.comparingDouble(Employee::getSalary)).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------------");	
		employeeList.stream().
		sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------------");	
		employeeList.stream().
		sorted(Comparator.comparingDouble(Employee::getAge).reversed()).
		collect(Collectors.toList()).
		forEach(System.out::println);
		
		System.out.println("-----------------------------------------------------------------------------");	
		employeeList.stream().
		sorted(Comparator.comparingDouble(Employee::getId)).
		collect(Collectors.toList()).
		forEach(System.out::println);
 	}
	
	
	

}
