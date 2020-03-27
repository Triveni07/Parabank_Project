package par.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParaBank_BaseClass
{
	public static WebDriver driver;
	
    //To launch the browser
	public void launchBrowser(String browserName) throws IOException{
		
		if(browserName.equals("chrome")){

			//To launch chrome browser
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Drivers\\chromedriver_v80.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equals("firefox")){
			
            //To launch firefox browser
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		//To maximize the browser window
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	//To open the application
	public void getUrl(){
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
	}
	
	//To take screenshot
	public void screenShot(String path) throws IOException{
		
		File Sshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(Sshot, new File(path));
	}

}
