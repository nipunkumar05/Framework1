package framework;

import java.io.IOException;

import org.testng.Assert;
import org.testng.SkipException;



public class Standard {
		// Test Cases Names are matched with methods
	public static void StandardM1(String Sheetname) throws IOException{
		
		//try{
		
			String[][] values=xls.readtestdata(Sheetname);
			String[][] values1= xls.readOR(values);
			
			GeneralMethods.action(values,values1);
		
	}

	

}
