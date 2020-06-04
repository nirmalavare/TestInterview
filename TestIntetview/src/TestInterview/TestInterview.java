package TestInterview;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class TestInterview {
	public WebDriver driver;
    
  
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C://Selenium//chromedriver_win32//chromedriver.exe"); 
	  driver = new ChromeDriver();
	  driver.get("http://automationpractice.com/index.php");
	  driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
	  driver.manage().window().maximize();
	  System.out.println("Browser is launched sucessfully");
  }

    @Test
  public void AccountCreation() {
	  driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("nirmala10vare@gmail.com");
	  driver.findElement(By.xpath("//button[@name=\"SubmitCreate\"]")).click();
	  System.out.println("Account is created");
	  
	//Select Title
	  driver.findElement(By.xpath("//input[@id=\"id_gender2\"]")).click();
	  driver.findElement(By.name("customer_firstname")).sendKeys("nirmala");
	  driver.findElement(By.name("customer_lastname")).sendKeys("Vare");
	  driver.findElement(By.name("email")).sendKeys("nirmala10.vare@gmail.com");
	  driver.findElement(By.id("passwd")).sendKeys("test@0801");
	  
	  // Enter your address
	  driver.findElement(By.id("firstname")).sendKeys("nirmala");
	  driver.findElement(By.id("lastname")).sendKeys("Vare");
	  driver.findElement(By.id("company")).sendKeys("test");
	  driver.findElement(By.id("address1")).sendKeys("T.g.b. 81/1,2nd cross");
	  driver.findElement(By.id("city")).sendKeys("mumbai");
	  
	  // Select State
	  WebElement statedropdown=driver.findElement(By.name("id_state"));
	  Select oSelect=new Select(statedropdown);
	  oSelect.selectByValue("4");
      driver.findElement(By.name("postcode")).sendKeys("40082");
	  
	  // Select Country
	  WebElement countrydropDown=driver.findElement(By.name("id_country"));
	  Select oSelectC=new Select(countrydropDown);
	  oSelectC.selectByVisibleText("United states");
	  
	  //Enter Mobile Number
	  driver.findElement(By.id("phone_mobile")).sendKeys("8879998982");
	  driver.findElement(By.xpath("//input[@name=\"alias\"]")).clear();
	  driver.findElement(By.xpath("//input[@name=\"alias\"]")).sendKeys("Office");
	  driver.findElement(By.name("submitAccount")).click();
	  String userText=driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText();

	  // Validate that user has created
	  if(userText.contains("Vsoft")) {
	   System.out.println("User Verified,Test case Passed");
	  }
	  else {
	   System.out.println("User Verification Failed,Test case Failed");
	  }
	 }
  
  
  @Test
  public void SignIn() 
  {
	  driver.findElement(By.cssSelector("[name='email_create']")).sendKeys("nirmala10vare@gmail.com");
	  driver.findElement(By.name("[name='passwd']")).sendKeys("test@0801");
	  driver.findElement(By.linkText("Sign in")).click();
	  System.out.println("Newly created user sucessfully logged in");
	  
	}
  
  
  
  @Test
  public void AddToCart() 
  {
	  
	  WebElement SecondImg=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img"));
	  WebElement MoreBtn=driver.findElement(By.xpath("/html/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul/li[2]/div[1]/div[2]/div[2]/a[2]"));
	  Actions actions=new Actions(driver);
	  actions.moveToElement(SecondImg).moveToElement(MoreBtn).click().perform();

	  //Change quantity by 2
	  driver.findElement(By.id("quantity_wanted")).clear();
	  driver.findElement(By.id("quantity_wanted")).sendKeys("2");
	  
	//Click on add to cart
	  driver.findElement(By.xpath("//p[@id='add_to_cart']//span[.='Add to cart']")).click();
	  
	  
	    }
  
  @Test
  public void PaymentProcess() 
  {
	//Click on proceed
	  driver.findElement(By.xpath("/html//div[@id='layer_cart']//a[@title='Proceed to checkout']/span")).click();
	  //Checkout page Proceed
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/p[2]/a[1]/span")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
	  //Agree terms&Conditions
	  driver.findElement(By.xpath("//*[@id=\"cgv\"]")).click();
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/form/p/button/span")).click();
      //Click on Payby Check
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")).click();
	  //Confirm the order
	  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")).click();
      //Get Text
	  String ConfirmationText=driver.findElement(By.xpath("//div[@id='center_column']/p[@class='alert alert-success']")).getText();
	 // Verify that Product is ordered
	  if(ConfirmationText.contains("complete")) {
	   System.out.println("Order Completed: Test Case Passed");
	  }
	  else {
	   System.out.println("Order Not Successfull: Test Case Failed");
	  }
}
  
  @Test
  public void OrderHistory () 
  {
	  //pending
	  
	 }
  
  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
