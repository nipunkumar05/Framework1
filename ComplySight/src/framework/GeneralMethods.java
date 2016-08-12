package framework;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class GeneralMethods extends Browser {

	
	// ------------------To identify ItemType
	public static void action(String[][] values,String[][] values1){
		
		
			
		
						int x= values.length;
						
						for(int a=1;a<=x-1;a++){
							
							try{
							if(values[a][0]!=null){
							
							if(values[a][0].trim().equalsIgnoreCase("Browser")){
								browser(values[a][3]);
							}
							
							if(values[a][0].trim().equalsIgnoreCase("URL")){
								Driver.get(values[a][3]);
								Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							}
							if(values[a][0].trim().equalsIgnoreCase("textfield")){
								textfield(values1[a][1], values1[a][2], values[a][3],values[a][1]);
							}
							
							if(values[a][0].trim().equalsIgnoreCase("browse")){
								browse(values1[a][1], values1[a][2], values[a][3],values[a][1]);
							}
							if(values[a][0].trim().equalsIgnoreCase("button")){
								button(values1[a][1], values1[a][2],values[a][1]);
							}
							
							
							
							if(values[a][0].trim().equalsIgnoreCase("listbox")){
								listbox(values1[a][1], values1[a][2], values[a][3],values[a][2]);
							}
							
							
				
							if(values[a][0].trim().equalsIgnoreCase("Textvalidation")){
								Textvalidation(values1[a][1], values1[a][2],values[a][3],values[a][2]);
							}
							if(values[a][0].trim().equalsIgnoreCase("Textvalidation1")){
								Textvalidation1(values1[a][1], values1[a][2],values[a][3],values[a][2]);
							}
							if(values[a][0].trim().equalsIgnoreCase("TextvalidationAlert")){
								try{
								Assert.assertEquals(Driver.switchTo().alert().getText(),values[a][3],values[a][2]);
								}
								catch (Exception e){
									Assert.assertTrue(false,e.getMessage());
								}
							}							

							
							if(values[a][0].trim().equalsIgnoreCase("link")){
								link(values1[a][1], values1[a][2],values[a][1]);
							}
							
							if(values[a][0].trim().equalsIgnoreCase("CompareText")){
								CompareText(values1[a][1], values1[a][2],values[a][3],values[a][2]);
							}
							
							
							
							if(values[a][0].trim().equalsIgnoreCase("Alert")){
								try{
								if(values[a][3].trim().equalsIgnoreCase("OK")){
									//System.out.println(Driver.switchTo().alert().getText());
									Driver.switchTo().alert().accept();
								}
								else{
									Driver.switchTo().alert().dismiss();
								}
								}
								catch (Exception e){
									Assert.assertTrue(false,e.getMessage());
								}
							}
							
							
							if(values[a][0].trim().equalsIgnoreCase("ItemAvailabilitytext")){
								ItemAvailabilityText(values1[a][1], values1[a][2],values[a-1][1],values[a][2]);
							}
							
							
							
							if(values[a][0].trim().equalsIgnoreCase("SelectDD")){
								SelectDD(values1[a][1], values1[a][2],values[a][3],values[a][1]);
								
							}
							
							if(values[a][0].trim().equalsIgnoreCase("ValidateTableLoads")){
								List<WebElement> itemidentifieds=webelements(values1[a][1], values1[a][2]);
								if(itemidentifieds.size()==0){
									//System.out.println(itemidentifieds.size());
									Assert.assertTrue(false,values[a][2]);
								}
								
							}
							
							
							if(values[a][0].trim().equalsIgnoreCase("close")){
								
								//Driver.quit();
								Driver.close();
							}
							if(values[a][0].trim().equalsIgnoreCase("wait")){
								int aq=Integer.parseInt(values[a][3]);
								Thread.sleep(aq*1000);
								//System.out.println("waiting time "+aq*1000);
							}
							
							
							
							
							if(values[a][0].trim().equalsIgnoreCase("URLValidation")){
								geturl(values[a][2]);
							}
							if(values[a][0].trim().equalsIgnoreCase("checkbox")){
								checkbox(values1[a][1], values1[a][2],values[a][1]);
							}
							
							
							
							if(values[a][0].trim().equalsIgnoreCase("switchtonew")){
								Set<String> windows= Driver.getWindowHandles();
								int g=Driver.getWindowHandles().size();
								//System.out.println(g+ "   "+windows);
								String present=null;
								Iterator<String> it =windows.iterator();
										for(int A=1;A<=g;A++){
											present=it.next();
										}
										
								Driver.switchTo().window(present);
							}
							
							
							if(values[a][0].trim().equalsIgnoreCase("ReadOnlyValidation")){
								ReadOnlyValidation(values1[a][1], values1[a][2],values[a][2],values[a][1]);
								
								}
							if(values[a][0].trim().equalsIgnoreCase("clear")){
								clear(values1[a][1], values1[a][2],values[a][1]);
								
								webelement(values1[a][1], values1[a][2]).clear();
							}
							
							}
							}
							catch (Exception e){
								
							}
							
							
			
		}
		
		
						
	}
	
//--------------------Various methods to Call Find Web element methods and to perform relevant action---//
	public static void textfield(String locatorT, String locatorV, String testdata,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
		try{
		itemidentified.click();
		itemidentified.sendKeys(testdata);
		}
		catch(Exception e){
			Assert.assertTrue(false,FieldName+" : item Not Found" );
		}
	}
	
	public static void browse(String locatorT, String locatorV, String testdata,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
		try{
		itemidentified.sendKeys(testdata);
		}
		catch(Exception e){
			Assert.assertTrue(false,FieldName+" : item Not Found" );
		}
	}
	
	public static void CompareText(String locatorT, String locatorV, String testdata,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
		try{
			Assert.assertTrue(itemidentified.getText().contains(testdata),"Threshold Not updated in Permission Level Button");
		}
		catch(Exception e){
			Assert.assertTrue(false,FieldName+" : item Not Found" );
		}
	}
	
	
	
	
	
		public static void Textvalidation(String locatorT, String locatorV, String testdata,String testStep){
			WebElement itemidentified=webelement(locatorT, locatorV);
			
			if(itemidentified==null){
				Assert.assertTrue(false,testStep);
			}
			else{
				Assert.assertEquals(itemidentified.getText(),testdata, testStep);
			}
		}
		
		public static void Textvalidation1(String locatorT, String locatorV, String testdata,String testStep){
			WebElement itemidentified=webelement(locatorT, locatorV);
			if(itemidentified==null){
				Assert.assertTrue(false,testStep);
			}
			else{
				int a=itemidentified.getText().split("[0-9]").length;
				String[] b=itemidentified.getText().split("[0-9]");
				
				//System.out.println(itemidentified.getText());
				//System.out.println(a);
				//System.out.println(b[a-1]);
				Assert.assertEquals(b[a-1].trim(),testdata, testStep);
			}
		}
	
	public static void listbox(String locatorT, String locatorV, String testdata,String testStep){
		WebElement itemidentified=webelement(locatorT, locatorV);
			try{
				Select Lbox=new Select(itemidentified);
				
				Lbox.selectByVisibleText(testdata);
			}
			catch(Exception e){
				Assert.assertTrue(false,testStep );
			}
	}
	
	
	
	public static void button(String locatorT, String locatorV,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
			try{
			itemidentified.click();
			}
			catch(Exception e){
				Assert.assertTrue(false,FieldName+" : item Not Found" );
			}
	}
	
		
	
	
	
	
	
	
	public static void link(String locatorT, String locatorV,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
		
			try{
			itemidentified.click();
			}
			catch(Exception e){
				Assert.assertTrue(false,FieldName+" : item Not Found" );
			}
	}
	
	

	
	public static void checkbox(String locatorT, String locatorV,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
			try{
			itemidentified.click();
			}
			catch(Exception e){
				Assert.assertTrue(false,FieldName+" : item Not Found" );
			}
	}
	
			public static void ReadOnlyValidation(String locatorT, String locatorV,String TestStep,String FieldName){
			WebElement itemidentified=webelement(locatorT, locatorV);
			Boolean flag=false;
			if(itemidentified!=null){
			
			if("true".equalsIgnoreCase(itemidentified.getAttribute("readonly"))){
				flag=true;
			}
			Assert.assertTrue(flag,TestStep);
			}
			else{
				Assert.assertTrue(false,FieldName+" Item not found");
			}
			}
			
	
public static void ItemAvailabilityText(String locatorT, String locatorV,String testdata,String testStep){
		
		List<WebElement> itemidentifieds=webelements(locatorT, locatorV);
		int count=itemidentifieds.size();
		
		itemavailabilitytext2(itemidentifieds,count, testdata, testStep);
		
		}
	



	
 public static void SelectDD(String locatorT, String locatorV,String testdata,String FieldName){
		try{
		List<WebElement> itemidentifieds=webelements(locatorT, locatorV);
		int count=itemidentifieds.size();
				
		for(int i=0;i<count;i++){
			if(itemidentifieds.get(i).getText().equalsIgnoreCase(testdata)){
				itemidentifieds.get(i).click();
				break;
		}
		}
		}
		catch(Exception e){
			Assert.assertTrue(false,FieldName+" : item Not Found" );
		}
	}


	

	
	
	
	
	public static void clear(String locatorT, String locatorV,String FieldName){
		WebElement itemidentified=webelement(locatorT, locatorV);
			try{
			itemidentified.clear();
			}
			catch(Exception e){
			Assert.assertTrue(false,FieldName+" : item Not Found" );
			}
	}
	
	
//-----------------------To search a web element----//
	
	public static  WebElement webelement(String locatorT, String locatorV){
		
					WebElement itemidentified=null;
					try{
					if (locatorT.trim().equalsIgnoreCase("xpath")){
						itemidentified= Driver.findElement(By.xpath(locatorV));
						
					}
					
					if (locatorT.trim().equalsIgnoreCase("id")){
						itemidentified= Driver.findElement(By.id(locatorV));
					}
					
					if (locatorT.trim().equalsIgnoreCase("linktext")){
						itemidentified= Driver.findElement(By.linkText(locatorV));
					}
					if (locatorT.trim().equalsIgnoreCase("cssselector")){
						itemidentified= Driver.findElement(By.cssSelector(locatorV));
					}
					if (locatorT.trim().equalsIgnoreCase("classname")){
						itemidentified= Driver.findElement(By.className(locatorV));
					}
					
					}
					catch(Exception e){
						
					}
					return itemidentified;
				}
	

	
	//---------------Search list of elements------------------------//
	public static  List<WebElement> webelements(String locatorT, String locatorV){
		
				List<WebElement> itemidentifieds=null;
				if (locatorT.trim().equalsIgnoreCase("xpath")){
					itemidentifieds= Driver.findElements(By.xpath(locatorV));
				}
				
				if (locatorT.trim().equalsIgnoreCase("id")){
					itemidentifieds= Driver.findElements(By.id(locatorV));
				}
				
				if (locatorT.trim().equalsIgnoreCase("linktext")){
					itemidentifieds= Driver.findElements(By.linkText(locatorV));
				}
				if (locatorT.trim().equalsIgnoreCase("classname")){
					itemidentifieds= Driver.findElements(By.className(locatorV));
				}
				return itemidentifieds;
			}

	  public static void itemavailabilitytext2(List<WebElement> itemidentifieds, int count, String testdata,String testStep){
			boolean flag=false;
			for(int x=0;x<=count-1;x++){
				WebElement element=itemidentifieds.get(x);
				String text=element.getText();
				//System.out.println(text);
				
				if ((text.trim().contains(Datasaving.getMap().get(testdata)))){
				//System.out.println("Hello "+Datasaving.getMap().get(testdata));
				flag=true;
				
					break;
				}
				
			}
			Assert.assertTrue(flag, testStep);
		}
	  
	  
	  
	  
	  

     



		

//-------------------------GET URL--------------------//

		public static void geturl(String Teststep){
			
			Assert.assertEquals(Driver.getCurrentUrl(),"http://complysight.osscube-qa.com/login",Teststep);
			
		}
}