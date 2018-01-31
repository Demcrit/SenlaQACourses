package com.zabi.stand_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTests {

	private static final String URL = "http://86.57.161.116:10008/";
	private static WebElement login;
	private static WebElement password;
	private static WebElement checkBox;
	private static WebElement buttonLogin;
	private static WebDriver driver;

	@BeforeClass
	public void startSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL + "#/login");
		driver.manage().window().maximize();

	}

	@Test
	private static void LoginValidTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#vacation");
	}

	@Test
	private static void LoginWithClearForm() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		WebElement x = driver.findElement(By.id("buttonReset"));
		x.click();
		Thread.sleep(5000);
	}

	@Test
	private static void LoginValidTestWithCheckBox() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		checkBox = driver.findElement(By.id("checkboxesRemember-0"));
		checkBox.click();
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#vacation");

	}

	@Test
	private static void LoginIncorrectTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("grommash");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private static void LoginIncorrectPasswordTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("1111");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private static void LoginIncorrectLoginWithSpacesTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("s er ge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private static void LoginIncorrectLoginWithSymbolsTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("s%er#g@e");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private static void EmptyPasswordTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys();
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#login");
	}

	@Test
	private static void SubmitButtonTest() throws InterruptedException {
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		buttonLogin.click();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getCurrentUrl(), URL + "#vacation");
	}

	@AfterClass
	private static void stopTest() {
		driver.quit();
	}

}
