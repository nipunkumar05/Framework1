package framework;


	
	import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
	

	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

	public class Browser {
		public static WebDriver Driver;
		public static WebDriver browser(String Br)
		{
			       Driver = null;
System.out.println("NipunK");
System.out.println("Kumar");
		          if (Br.equalsIgnoreCase("FF"))

		               {
		        	  String PROXY = "192.168.9.254:8080";

		        	  org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();
		        	 
		        	  proxy.setHttpProxy(PROXY)
		        	       .setFtpProxy(PROXY)
		        	       .setSslProxy(PROXY).setSocksProxy(PROXY).setNoProxy("complysight.osscube-qa.com");
		        
		        	  DesiredCapabilities cap = new DesiredCapabilities();
		        	  cap.setCapability(CapabilityType.PROXY, proxy);
		        	   Driver = new FirefoxDriver(cap);
		              //    Driver= new FirefoxDriver(profile);
		                  
		                // DriverObj.get("http://google.com");

		               }

		          else if  (Br.equalsIgnoreCase("IE"))

		                      {

		                               System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");

		                               Driver=new InternetExplorerDriver();
		                               //DriverObj.get(link);

		                               

		                      }

		          else if (Br.equalsIgnoreCase("CH"))

		                             {

		                                      System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

		                                       Driver=new ChromeDriver();
		                                       //DriverObj.get(link);
		                             }

		          
		          		Driver.manage().window().maximize();

		              return Driver;

		}
		public static WebDriver openapp(String URL){
			Driver.get(URL);
			Driver.manage().deleteAllCookies();
			//Driver.navigate().refresh();
			return Driver;
		}
		
		/*public static void stop(WebElement value){
			WebDriverWait wait = new WebDriverWait(Driver, 15);
			
			Boolean element = wait.until(ExpectedConditions.elementToBeClickable(locator)));
			System.out.println("print"+element);

			
		}*/
		


}
