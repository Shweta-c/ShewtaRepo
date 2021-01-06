package Automation.Assignments;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class Base 
{
	private static WebDriver d;
	static String projectpath = System.getProperty("user.dir");
	
	public static WebDriver getDriver(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			d=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			d=new FirefoxDriver();
		}
		else
		{
			d=new InternetExplorerDriver();
		}
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return d;
	}
	
	  public static void getScreenShot(WebDriver d,String name)
	  {
		  try
		  {
			  File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE); 
			  String timestamp =new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date()); 
			  File dest =new File(projectpath+"\\ScreenShot\\"+name+timestamp+".jpg");
			  FileHandler.copy(src, dest);
		  }
		  catch(Exception e)
		  {
			  System.out.println("Exception while taking Screenshot"+e.getMessage());
		  }
	  }
	public static Properties loadPropFile(String filepath) 
	{	
		Properties pro=new Properties();
		FileInputStream fs;
		try 
		{
			fs=new FileInputStream(filepath);
			pro.load(fs);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	
		return pro;	
	}
	public static WebDriver closeDriver()
	{
		d.close();
		return d;
	}
}
