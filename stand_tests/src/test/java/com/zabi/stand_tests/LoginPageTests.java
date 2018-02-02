package com.zabi.stand_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import com.zabi.stand_tests.pageobjects.LoginPage;
import com.zabi.stand_tests.user.User;

public class LoginPageTests {

	private static final String URL = "http://86.57.161.116:10008/";
	private static WebDriver driver;
	User user = new User();
	
	@BeforeClass
	public void startSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL + "#/login");
		driver.manage().window().maximize();

	}

	@Test
	private void LoginValidTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),user.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#/vacation");
		}

	@Test
	private void LoginWithClearForm() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),user.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
		}

	@Test
	private void LoginValidTestWithCheckBox() throws InterruptedException {
		WebElement checkBox = driver.findElement(By.id("checkboxesRemember-0"));
		checkBox.click();
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),user.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#/vacation");

	}

	@Test
	private void LoginIncorrectTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin() + " blabla",user.getPassword());
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private void LoginIncorrectPasswordTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),user.getPassword() + "fail");
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private void IncorrectLoginWithSpacesTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(" " + user.getLogin()+ " ",user.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private void IncorrectLoginWithSymbolsTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin() + " #$@",user.getPassword());
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private void EmptyPasswordTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),"");
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}
	
	@Test
	private void ButtonResetTest() throws InterruptedException {
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.login(user.getLogin(),user.getPassword());
		WebElement x = driver.findElement(By.id("buttonReset"));
		x.click();
		}

	@AfterClass
	private static void stopTest() {
		driver.quit();
	}

}
