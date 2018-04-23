package device.point_of_sale;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestReceipt {
	
	Receipt receipt = new Receipt();

	@Test
	public void testAddingSameProductFewTimes() {
		Product product = new Product("test1", 0.6, "1234");
		receipt.add(product);
		receipt.add(product);
		assertEquals(receipt.getProducts().size(), 1);
		assertEquals(receipt.getSum(), 1.2, 0.001);	
	}

	@Test 
	public void TestClearAll() {
		Product product = new Product("test1", 0.6, "1234");
		receipt.add(product);
		receipt.clearAll();
		assertEquals(0, receipt.getProducts().size());
		assertEquals(0.0, receipt.getSum(), 0.001);
	}
}
