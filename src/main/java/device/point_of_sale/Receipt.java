package device.point_of_sale;

import java.util.HashMap;
import java.util.Map;

public class Receipt {
	private Map<Product, Integer> products;
	private double sum;
	
	public Receipt() {
		products = new HashMap<Product, Integer>();
		sum = 0.0;
	}
	
	public Map<Product, Integer> getProducts() {
		return products;
	}
	
	public double getSum() {
		return sum;
	}
	
	public void clearAll() {
		products.clear();
		sum = 0.0;
	}
	
	public void add(Product added) {
		if(!products.containsKey(added))
			products.put(added, 1);
		else 
			incrementProductsQuantity(added);
		addToSum(added.price);
	}
	
	private void incrementProductsQuantity(Product added) {
		int temp = products.get(added);
		temp++;
		products.replace(added, temp);
	}
	
	// I've done this because adding 1.02+4.99+1.02 gave me 7.029999999999999 instead of 7.03
	// probably because of IEEE Standard for Floating-Point Arithmetic
	private void addToSum(double added) {
		sum = (double)(sum*100 + added*100)/100;
	}
	
}
