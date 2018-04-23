package device.point_of_sale;

public class LCD implements OutputDevice {
	
	public void print(String message) {
		System.out.println("LCD - " + message);		
	}
	
	public void printProduct(Product product) {
		System.out.println("LCD - " + product.name + " " + product.price);		
	}

}
