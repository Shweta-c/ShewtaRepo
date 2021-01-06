package Automation.Assignments;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class Registraion
{
	public WebDriver d;
	RegistrationPage rp;
	Properties prop;
	String projectpath = System.getProperty("user.dir");
	
	@BeforeMethod
	@Parameters("browser")
	public void beforeM(String browser) throws IOException
	{
		d=Base.getDriver(browser);
		rp=new RegistrationPage(d);
		prop=Base.loadPropFile(projectpath+"\\src\\test\\java\\Automation\\Assignments\\Links.properties");
		d.get(prop.getProperty("RegisterUrl"));
	}
	
	 @DataProvider
	 public Object[][] getTestdata()
	 {
	 return new Object[][] {{"Shweta","chougale","shwetachougale@gmail.com","shweta","shweta"},
		 {"Pallavi","chougale","","pallavi","pallavi"},
		 {"Asha","","AshaPasle@gmail","Asha","Asha"},
		 {"Snehal","Dhavale","Snehal","Snehal",""}};
	 }
	
	 //Method for reading data from excel
	/*@DataProvider 
	public Iterator<Object[]> getTestdata() throws IOException
	{
		ArrayList<Object[]> testdata = XLReader.getDataFromExcel();
		return testdata.iterator();
	}*/
	 
	 @Test (dataProvider = "getTestdata")
	public void display(String name,String lname,String email,String pass,String cpass) throws IOException
	{
		 rp.register(name, lname, email, pass, cpass);
		 Base.getScreenShot(d, "Register");
		 AssertJUnit.assertEquals("Confirmation!",d.getTitle());
		 Base.getScreenShot(d, "Register");
	}

	@AfterMethod
	public void after()
	{
		d=Base.closeDriver();
	}
}