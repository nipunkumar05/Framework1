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
import org.testng.Assert;
//import org.testng.annotations.Test;

public class TestNGreportlearning {

	

	    @Test
	    public void testMethodOne(){
	        Assert.assertTrue(true);
	    }
		  
	    @Test
	    public void testMethodTwo(){
		Assert.assertTrue(false);
	    }
		  
	    @Test(dependsOnMethods={"testMethodTwo"})
	        public void testMethodThree(){
	        Assert.assertTrue(true);
	    
	}
 }

