package device.point_of_sale;

import java.util.Vector;

public class ProductsDatabase {
	private Vector<Product> allProducts;
	
	public ProductsDatabase() {
		allProducts = new Vector<Product>();
		allProducts.add(new Product("aa", 1.02, "0000"));
		allProducts.add(new Product("bb", 4.99, "0001"));
		allProducts.add(new Product("cc", 0.68, "0002"));
		allProducts.add(new Product("dd", 12.65, "0003"));
	}
	
	public Product getProduct(String codeScanned) {
		for(Product product : allProducts)
			if(product.code.equals(codeScanned)) {
				return product;
			}
		return null;
	}
}
