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

import javax.imageio.ImageIO;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import framework.Standard;

public class LM_Update_Dates {

	@AfterMethod
	public void catchscreenshot(ITestResult result) throws IOException, HeadlessException, AWTException{
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Date date = new Date();
		   String current=dateFormat.format(date);
		String name=result.getMethod().getMethodName();
		if(result.getStatus()==2){
			 BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			    ImageIO.write(image, "png", new File("Screenshots\\"+name.concat(current)+".png"));
		}
	}
	@Test
	public static void L5_Login() throws IOException{
		
		
		Standard.StandardM1("L5_Login");
		
	}
	
	
	@Test(alwaysRun=true,dependsOnMethods="L5_Login")
	public static void LM_Update_Dates() throws IOException{
		
		Standard.StandardM1("LM_Update_Dates");
	}
	
}
