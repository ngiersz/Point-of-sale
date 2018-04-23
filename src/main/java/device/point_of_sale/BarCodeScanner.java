package device.point_of_sale;

import java.util.Scanner;

public class BarCodeScanner {
	String input;
	BarCodeType type;
	
	public String getInput() {
		return input;
	}

	public BarCodeType getType() {
		return type;
	}
	
	public void readInput() {
		Scanner reader = new Scanner(System.in);
		input = reader.nextLine();
//		reader.close();
	}
	
	public void checkInput() {
		if(isExit())
			type = BarCodeType.EXIT;
		else if(!isValid())
			type = BarCodeType.INVALID;
		else
			type = BarCodeType.VALID;
	}
	
	private Boolean isExit() {
		return input.matches("exit");
	}
	
	private Boolean isValid() {
		return (!input.isEmpty() && !isExit());
	}
}
