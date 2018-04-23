package device.point_of_sale;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestProductsDatabase {

	ProductsDatabase db = new ProductsDatabase();
	
	@Test
	public void testGetProductsName() {
		assertEquals("aa", db.getProduct("0000").name);
	}

	@Test
	public void testProductNotInDatabase() {
		assertEquals(null, db.getProduct("0010"));
	}

}
