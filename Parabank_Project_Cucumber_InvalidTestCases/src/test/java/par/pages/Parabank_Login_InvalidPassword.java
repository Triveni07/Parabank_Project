package par.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Parabank_Login_InvalidPassword 
{
	//To create driver object
	public static WebDriver driver;

	//To create objects for webelements
	By username=By.name("username");
	By password=By.name("password");
	By login=By.xpath("//*[@id='loginPanel']/form/div[3]/input");
	By logout=By.partialLinkText("Log Out");

	//To collect the driver object
	public Parabank_Login_InvalidPassword(WebDriver driver)
	{
		this.driver=driver;
	}

	//To pass the username to browser and enter in the username field
	public void enterUsername()
	{
		driver.findElement(username).sendKeys("triv");
	}

	//To pass the password to browser and enter in the password field
	public void enterPassword()
	{
		driver.findElement(password).sendKeys("jsgjsa5698");
	}

	//To login into the application
	public void logInButton() throws InterruptedException
	{
		driver.findElement(login).click();
		Thread.sleep(3000);
		String exp="ParaBank | Error";
		String act=driver.getTitle();
		assertEquals(exp,act);
	}

	//To close the browser
	public void closeBrowser()
	{
		driver.close();
	}

}
