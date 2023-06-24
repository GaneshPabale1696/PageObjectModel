package Test_Scenarios;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.FacebookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMethods_GoogleSearch {
	
	WebDriver driver;
	
	GoogleSearchPage objrepo;
	
	@BeforeTest
	public void beforetest() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(ops); // launch chrome
		
		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
			
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@Test(priority = 0)
	public void searchOperation() throws InterruptedException 
	{
		GoogleSearchPage gsp=new GoogleSearchPage(driver);
		gsp.searchgoogle("Facebook");
	}

	@Test(priority = 1)
	public void VerifyandAccessFacebookAccount() throws InterruptedException
	{
		objrepo =new GoogleSearchPage(driver);
		objrepo.ClickFacebook();
	}
	
	@Test(priority = 2)
	public void VerifyLoginFunctionality() throws InterruptedException
	{
		FacebookPage page=new FacebookPage(driver);
		page.EnterUserName("ganeshpabale7@gmail.com");
		page.EnterUserPassword("Ganesh@1696");
		page.VerifyLogin();
	}
	
	@AfterTest
	public void aftertest()
	{
		driver.quit();
	}
	
}
