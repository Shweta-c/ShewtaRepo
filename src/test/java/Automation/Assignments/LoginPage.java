package Automation.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage 
{
	private WebDriver d;
	private By userId= By.xpath("//*[@id='user']");
	private By pwd= By.xpath("//*[@id='password']");
	private By submit= By.xpath("//*[@id='login']");
	
	public LoginPage(WebDriver d)
	{
		this.d=d;
	}
	
	public void login(String userid,String pass)
	{
		d.findElement(userId).sendKeys(userid);
		d.findElement(pwd).sendKeys(pass);
		d.findElement(submit).click();
	}

}
