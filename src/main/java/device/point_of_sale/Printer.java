package device.point_of_sale;

import java.util.Map;

public class Printer implements OutputDevice {

	public void print(String message) {
		System.out.println("PRINTER - " + message);		
	}
	
	public void printProduct(Product product) {
		System.out.println("PRINTER - " + product.name + " " + product.price);
	}
	
	public void printTotalProducts(Map<Product, Integer> totalProducts) {
		System.out.println("PRINTER - total:");
		for(Map.Entry<Product, Integer> e : totalProducts.entrySet())
			System.out.println(e.getKey().name + " " + e.getValue() + " " + e.getKey().price);
	}
}
