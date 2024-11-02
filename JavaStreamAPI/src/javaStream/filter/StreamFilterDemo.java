package javaStream.filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamFilterDemo {

	public static void main(String[] args) {
		
		List<Product> listProduct = new ArrayList<>();
		for(Product product:getProducts()) {
			if(product.getPrice()>30000f)
				listProduct.add(product);
		}
		for(Product prd : listProduct)
			System.out.println(prd);

		System.out.println("#############################################################");
		
		//Using Stream API
		getProducts().stream().filter(
				(product)->product.getPrice()>45000f).
				collect(Collectors.toList()).forEach(System.out::println);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
	
	
	private static List<Product> getProducts(){
		
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(1,"HP Laptop",25000f));
		productList.add(new Product(2,"Dell Laptop",35000f));
		productList.add(new Product(3,"Apple Laptop",95000f));
		productList.add(new Product(4,"Samsung Laptop",75000f));
		productList.add(new Product(5,"Lenevo Laptop",65000f));
		productList.add(new Product(6,"Sony Laptop",70000f));
		productList.add(new Product(7,"chinese Laptop",10000f));
		
		return productList;
	}

}

class Product{
	
	private int id;
	private String name;
	private float price;
	
	public Product(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
