package device.point_of_sale;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import java.util.HashMap;

public class TestDevice {
	LCD lcd = mock(LCD.class);
	BarCodeScanner barCodeScanner = mock(BarCodeScanner.class);
	Printer printer = mock(Printer.class);
	ProductsDatabase db = mock(ProductsDatabase.class);
	Receipt receipt = mock(Receipt.class);
	Device dev;
	
	@Before
	public void init() {
		dev = new Device(lcd, printer, barCodeScanner, db, receipt);
	}
	
	@Test
	public void testExit() {
		when(barCodeScanner.getType()).thenReturn(BarCodeType.EXIT);
		dev.scanAndCheck();
		verify(printer, times(1)).printTotalProducts(any(HashMap.class));
		verify(receipt, times(1)).clearAll();
	}

	@Test
	public void testInvalid() {
		when(barCodeScanner.getType()).thenReturn(BarCodeType.INVALID);
		dev.scanAndCheck();
		verify(lcd, times(1)).print("ERROR: Invalid bar-code");
	}
	
	@Test
	public void testProductNotFound() {
		when(barCodeScanner.getType()).thenReturn(BarCodeType.VALID);
		when(db.getProduct(any(String.class))).thenReturn(null);
		dev.scanAndCheck();
		verify(lcd, times(1)).print("ERROR: Product not found");
	}
	
	@Test
	public void testNewProductAdded() {
		Product product = new Product("test", 1.02, "9999");
		when(barCodeScanner.getInput()).thenReturn("9999");
		when(barCodeScanner.getType()).thenReturn(BarCodeType.VALID);
		when(db.getProduct(any(String.class))).thenReturn(product);
		dev.scanAndCheck();
		verify(receipt, times(1)).add(any(Product.class));
	}
	
	@Test
	public void testTwoSameProductsAdded() {
		Product product = new Product("test", 1.02, "9999");
		when(barCodeScanner.getInput()).thenReturn("9999");
		when(barCodeScanner.getType()).thenReturn(BarCodeType.VALID);
		when(db.getProduct(any(String.class))).thenReturn(product);
		dev.scanAndCheck();
		dev.scanAndCheck();
		verify(receipt, times(2)).add(any(Product.class));
	}
}
