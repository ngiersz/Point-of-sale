package device.point_of_sale;

public class Device {
	ProductsDatabase db;
	private BarCodeScanner barCodeScanner;
	private Printer printer;
	private LCD lcd;
	private Receipt currentReceipt;
	private Product scanned;
	
	public Device(LCD lcd, Printer printer, BarCodeScanner barCodeScanner, ProductsDatabase db, Receipt receipt) {
		this.lcd = lcd;
		this.printer = printer;
		this.barCodeScanner = barCodeScanner;
		this.db = db;
		this.currentReceipt = receipt;
	}
	
	public void scanAndCheck() {
		lcd.print("Scan the product or press 'exit':");		
		barCodeScanner.readInput();
		barCodeScanner.checkInput();
		BarCodeType inputType = barCodeScanner.getType();
		
		switch(inputType) {
			case EXIT: 
				endTheReceipt();
				break;
			case INVALID:
				lcd.print("ERROR: Invalid bar-code");
				break;
			case VALID:
				checkProductAndAddToTotal();
				break;
		}
	}
	
	private void endTheReceipt() {
		printer.printTotalProducts(currentReceipt.getProducts());
		printer.print("total: " + String.valueOf(currentReceipt.getSum()));
		currentReceipt.clearAll();
	}
	
	private void checkProductAndAddToTotal() {
		String codeScanned = barCodeScanner.getInput();
		scanned = db.getProduct(codeScanned);
		if(scanned == null)
			lcd.print("ERROR: Product not found");
		else {
			lcd.printProduct(scanned);
			currentReceipt.add(scanned);
		}
	}
}
