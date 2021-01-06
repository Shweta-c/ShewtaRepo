package Automation.Assignments;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1
{
	public WebDriver d;
	Properties prop;
	String projectpath = System.getProperty("user.dir");
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeM(String browser) throws IOException
	{
		d=Base.getDriver(browser);
		prop=Base.loadPropFile(projectpath+"\\src\\test\\java\\Automation\\Assignments\\Links.properties");
		d.get(prop.getProperty("WindowUrl2"));
	}

	@Test
	public void display() throws IOException
	{
		//Default frame
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@class='row']/div/button")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@class='row']/div/button")).getText());
		
		//1st child Frame
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@id='button']")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@id='button']")).getText());	
		
		d.switchTo().parentFrame();
		
		//2nd child Frame
		d.switchTo().frame(1);
		
		//child Frame Inside Frame 1
		d.switchTo().frame(0);
		d.findElement(By.xpath("//*[@id='button']")).click();
		Assert.assertEquals("CLICKED", d.findElement(By.xpath("//*[@id='button']")).getText());
	}
	
	@AfterMethod
	public void after()
	{
		d=Base.closeDriver();
	}
}
