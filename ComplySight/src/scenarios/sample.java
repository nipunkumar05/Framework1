package scenarios;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import framework.Browser;
import framework.Standard;

public class sample extends Browser{
	
	@AfterMethod
	public void catchscreenshot(ITestResult result) throws IOException, HeadlessException, AWTException{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		   String current=dateFormat.format(date);
		String name=result.getMethod().getMethodName();
		if(result.getStatus()==2){
			 BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    ImageIO.write(image, "png", new File("Screenshots\\"+name.concat(current)+".png"));
			 //File scrFile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
			 //FileUtils.copyFile(scrFile, new File("Screenshots\\"+name.concat(current)+".png"));
		}
	}
	
	
	
	
	@Test (alwaysRun=true)
	public static void samples() throws IOException{
		
		Standard.StandardM1("sample");
	}
	
		
	

}
