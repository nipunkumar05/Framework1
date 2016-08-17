package framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xls {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
   // readxml("L5_Webinar");
		
	}

	public static String[][] readtestdata (String sheet)throws IOException{
		FileInputStream FIS=new FileInputStream("src\\XLS\\TestData.xlsx"); 
		XSSFWorkbook XSWB= new XSSFWorkbook(FIS);
		XSSFSheet XSST= XSWB.getSheet(sheet);
		int x= XSST.getLastRowNum();
		
		XSSFRow XSRW= XSST.getRow(1);
		
		int y= XSRW.getLastCellNum();
		String [] []values=new String[x][y];
		//System.out.println(x);
			for(int a=1;a<=x;a++){
				 XSRW= XSST.getRow(a+1);
				 if (XSRW!=null){
				y= XSRW.getLastCellNum();
				//System.out.println(y);
				  for (int b=0;b<=y-1;b++){
					  XSSFCell XSCL=XSRW.getCell(b);
					  if(XSCL!=null){
						  
					  int c=XSCL.getCellType();
					  
					  if (c==0){
						  
						  if (HSSFDateUtil.isCellDateFormatted(XSCL)){
							  Date D=XSCL.getDateCellValue();
							  values[a][b]= D.toString();
							  
							  //System.out.println("Hulla bol"+XSCL.get);
						  }
						  
						  else{
						  double dou= XSCL.getNumericCellValue();
						   int d=Double.valueOf(dou).intValue();
						   values[a][b]=Integer.toString(d);
						  
						  }
						 						  
					  }
					  if (c==1){
						  
						 		  
						  values[a][b]=XSCL.getStringCellValue();
						  if(values[a][b].startsWith("DM")){
							  values[a][b]=  values[a][b].replace("DM", "");
					  }
					  }
					  
					  if (c==2){
						  int fg=XSCL.getCachedFormulaResultType();
						  switch( XSCL.getCachedFormulaResultType()){
						  case Cell.CELL_TYPE_NUMERIC:
							  double dou= XSCL.getNumericCellValue();
							  
							  int d=Double.valueOf(dou).intValue();
							  
							  values[a][b]=Integer.toString(d);
							 // System.out.println("Last evaluated as Numeric \"" + values[a][b] + "\"");   
				                break;
				            case Cell.CELL_TYPE_STRING:
				            	values[a][b]=XSCL.getStringCellValue();
				            	//System.out.println("Last evaluated as String\"" + values[a][b] + "\"");
				               // System.out.println("Last evaluated as String \"" + XSCL.getRichStringCellValue() + "\"");
				                break;
						  }
					  }
						  
					  }
					  
						  
					  
										// System.out.println(a +""+ b +" "+ values[a][b]);
				  }
				  }
				
	
			}
		return values;	
	}

	
	public static String[][] readOR (String[][] Values)throws IOException{
		int z=Values.length;
		//System.out.println(z);
		FileInputStream FIS=new FileInputStream("src\\XLS\\TestData.xlsx"); 
		XSSFWorkbook XSWB= new XSSFWorkbook(FIS);
		XSSFSheet XSST= XSWB.getSheet("OR");
		int x= XSST.getLastRowNum();
		//System.out.println("Last row in OR  "+x);
		XSSFRow XSRW= XSST.getRow(1);
		
		int y= XSRW.getLastCellNum();
		String [] []values=new String[x][y];
		//System.out.println(x);
		
		for(int d=1;d<=z-1;d++){
			
			for(int a=1;a<=x;a++){
				 XSRW= XSST.getRow(a+1);
				 
				 
				 if (XSRW!=null){
					 
				y= XSRW.getLastCellNum();
				 String XSCL=XSRW.getCell(0).getStringCellValue();
				 if(XSCL.trim().equalsIgnoreCase(Values[d][1])){
					 for (int b=0;b<=y-1;b++){
						  XSSFCell XSCL1=XSRW.getCell(b);
						  if(XSCL1!=null){
						  int c=XSCL1.getCellType();
						  
						  if (c==0){
							  
							  if (HSSFDateUtil.isCellDateFormatted(XSCL1)){
								  Date D=XSCL1.getDateCellValue();
								  values[d][b]= D.toString();
								  
								
							  }
							  
							  else{
							  double dou= XSCL1.getNumericCellValue();
							  int d1=Double.valueOf(dou).intValue();
							  values[d][b]=Integer.toString(d1);
							  }
							 						  
						  }
						  if (c==1){
							  
							  values[d][b]=XSCL1.getStringCellValue();
						  }
						  if (c==2){
							  switch( XSCL1.getCachedFormulaResultType()){
							  case Cell.CELL_TYPE_NUMERIC:
								  double dou= XSCL1.getNumericCellValue();
								  int d1=Double.valueOf(dou).intValue();
								  values[d][b]=Integer.toString(d1);
					               
					                break;
					            case Cell.CELL_TYPE_STRING:
					            	values[d][b]=XSCL1.getStringCellValue();
					                System.out.println("Last evaluated as \"" + XSCL1.getRichStringCellValue() + "\"");
					                break;
							  }
						  }
							  
						  }
											//System.out.println(a +""+ b +" "+ values[a][b]);
					  }
				 }
		}
			
				
				 
				  }
				
	
			}
		return values;	
	}
	
	public static String runmode (String Value)throws IOException{
		
		
		FileInputStream FIS=new FileInputStream("src\\XLS\\TestData.xlsx"); 
		XSSFWorkbook XSWB= new XSSFWorkbook(FIS);
		XSSFSheet XSST= XSWB.getSheet("TestCases");
		int x= XSST.getLastRowNum();
		//System.out.println("Last row in OR  "+x);
		XSSFRow XSRW= XSST.getRow(1);
		
		int y= XSRW.getLastCellNum();
		String value1="K";
		//System.out.println(x);
		
				
			for(int a=1;a<=x;a++){
				 XSRW= XSST.getRow(a+1);
				 
				 
				 if (XSRW!=null){
					 
				y= XSRW.getLastCellNum();
				 String XSCL=XSRW.getCell(0).getStringCellValue();
				 if(XSCL.trim().equalsIgnoreCase(Value)){
					 for (int b=0;b<=y-1;b++){
						  XSSFCell XSCL1=XSRW.getCell(b);
						  if(XSCL1!=null){				  
							  
							  value1=XSCL1.getStringCellValue();
						  }
					  }
				 }
		}
			
				
				 
	}
			return value1;	
}
}
