package Automation.Assignments;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.*;

public class Login
{
	public WebDriver d;
	LoginPage lp;
	String projectpath = System.getProperty("user.dir");
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeM(String browser) throws IOException
	{
		d=Base.getDriver(browser);
		lp=new LoginPage(d);
		d.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Properties pro=new Properties();
		FileInputStream fs=new FileInputStream(projectpath+"\\src\\test\\java\\Automation\\Assignments\\Links.properties");	
		pro.load(fs);
		d.get(pro.getProperty("LoginUrl"));
	}
	
	 @DataProvider
	 public Object[][] getTestdata()
	 {
	 return new Object[][] {{"Shweta","chougale"},{"admin","admin"}};
	 }
	
	 @Test (dataProvider = "getTestdata")
	public void display(String Uid,String Upass) throws IOException
	{
		 lp.login(Uid,Upass);
		 Base.getScreenShot(d, "Login");
		 AssertJUnit.assertEquals("Confirmation!",d.getTitle());
		 Base.getScreenShot(d, "Login");
	}

	@AfterMethod
	public void after()
	{
		d=Base.closeDriver();
	}
}