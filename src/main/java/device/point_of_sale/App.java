package device.point_of_sale;

public class App 
{
    public static void main( String[] args )
    {
		BarCodeScanner barCodeScanner = new BarCodeScanner();
		Printer printer = new Printer();
		LCD lcd = new LCD();
		ProductsDatabase db = new ProductsDatabase();
		Receipt receipt = new Receipt();
		Device d = new Device(lcd, printer, barCodeScanner, db, receipt);
		while(true)
			d.scanAndCheck();
    }
}
