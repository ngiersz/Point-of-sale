package device.point_of_sale;

public class Product {
	public String code;
	public double price;
	public String name;
	
	public Product(String n, double p, String c) {
		this.name = n;
		this.price = p;
		this.code = c;
	}	
}
