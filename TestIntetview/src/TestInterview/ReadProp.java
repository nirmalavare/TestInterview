package TestInterview;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReadProp 
{
	
	 public static void main(String[] args) throws IOException {
		
		 WebDriver driver;
		
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C://Users//nirmala.vare//workspace//TestIntetview//src//TestInterview//config.properties");
		
		prop.load(ip);
		
		System.out.println(prop.getProperty("browser"));
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32//chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Users//nirmala.vare//workspace//TestIntetview//Drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//nirmala.vare//workspace//TestIntetview//Drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		else
		{
			System.out.println("No browser value is given");
		}
	
	//driver.get(prop.getProperty("url"));
	//driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
	//driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
	
	
	 }
}



		
		
		
		
		
