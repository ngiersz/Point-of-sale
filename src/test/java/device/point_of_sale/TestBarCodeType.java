package device.point_of_sale;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

import junit.framework.TestCase;

public class TestBarCodeType extends TestCase {
	BarCodeScanner barCodeScanner = new BarCodeScanner();
	
	private void setInputStream(String input) {
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
	}
	
	@Test
	public void testTypeIsExit() {
	    setInputStream("exit");
	    barCodeScanner.readInput();
		barCodeScanner.checkInput();
		assertEquals(BarCodeType.EXIT, barCodeScanner.getType());
	}
	
	@Test
	public void testTypeIsInvalid() {
		setInputStream("\n");
	    barCodeScanner.readInput();
		barCodeScanner.checkInput();
		assertEquals(BarCodeType.INVALID, barCodeScanner.getType());
	}
	
	@Test
	public void testTypeIsValid() {
	    setInputStream("9999");
	    barCodeScanner.readInput();
		barCodeScanner.checkInput();
		assertEquals(BarCodeType.VALID, barCodeScanner.getType());
	}
}
