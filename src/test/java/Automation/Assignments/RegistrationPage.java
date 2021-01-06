package Automation.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage 
{
	private WebDriver d;
	private By Fname= By.xpath("//*[@name='first_name']");
	private By Lname= By.xpath("//*[@name='last_name']");
	private By email= By.xpath("//*[@name='email']");
	private By pass= By.xpath("//*[@name='password']");
	private By Cpass= By.xpath("//*[@name='confirm_password']");
	private By Term= By.xpath("//*[@name='terms']");
	private By submit= By.xpath("//*[@name='submit_button']");
	
	public RegistrationPage(WebDriver d)
	{
		this.d=d;
	}
	
	public void register(String firstname,String lastname,String emailid,String pwd,String Cpwd)
	{
		d.findElement(Fname).sendKeys(firstname);
		d.findElement(Lname).sendKeys(lastname);
		d.findElement(email).sendKeys(emailid);
		d.findElement(pass).sendKeys(pwd);
		d.findElement(Cpass).sendKeys(Cpwd);
		d.findElement(Term).click();
		d.findElement(submit).click();
	}
}
