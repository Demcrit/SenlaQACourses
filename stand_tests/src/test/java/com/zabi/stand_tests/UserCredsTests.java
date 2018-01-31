package com.zabi.stand_tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserCredsTests {
	public static final String EMAIL = "\"^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$\"";
	public static final String PHONE = "\"^[0-9]+-[0-9]+-[0-9]\"";
	private static final String URL = "http://86.57.161.116:10008/";
	private static WebDriver driver;
	private static WebElement login;
	private static WebElement password;
	private static WebElement user;
	private static WebElement profile;
	private static WebElement email;
	private static WebElement phone;
	private static WebElement skype;
	private static WebElement comment;
	private static WebElement workstation;
	private static WebElement specialization;
	private static WebElement location;
	private static WebElement office;

	@BeforeClass
	public static void startSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL + "#/login");
		driver.manage().window().maximize();
		login = driver.findElement(By.id("logininput"));
		login.sendKeys("serge");
		password = driver.findElement(By.id("passwordinput"));
		password.sendKeys("empl");
		new Actions(driver).sendKeys(Keys.ENTER).perform();
		user = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a"));
		user.click();
		profile = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/ul/li[1]"));
		profile.click();

	}

	@Test
	public static void emailCheck() {
		email = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]"));
		if (email.getText().matches(EMAIL)) {
		} else
			Assert.fail();
	}

	@Test
	public static void phoneNumberCheck() {
		phone = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[2]/td[2]"));
		if (phone.getText().matches(PHONE)) {
		} else {
			Assert.fail();
		}

	}

	@Test
	public void skypeCheck() {
		skype = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[2]"));
		if (skype.getText().equalsIgnoreCase("s_tan")) {
		} else {
			Assert.fail();
			;
		}
	}

	@Test
	public void locationCheck() {
		location = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[1]/td[2]"));
		if (location.getText().equalsIgnoreCase("BLR_GRO")) {
		} else {
			Assert.fail();
		}
	}

	@Test
	public void officceCheck() {
		office = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[5]/td[2]"));
		if (office.getText().equals("1")) {
		} else {
			Assert.fail();
		}
	}

	@Test
	public void specializationCheck() {
		specialization = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[2]/td[2]"));
		if (specialization.getText().equalsIgnoreCase("Developer")) {
		} else {
			Assert.fail();
		}
	}

	@Test
	public void workstationCheck() {
		workstation = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[6]/td[2]"));
		if (workstation.getText().equalsIgnoreCase("dancogrod0067")) {
		} else {
			Assert.fail();
		}
	}

	@Test
	public void commentCheck() {
		comment = driver.findElement(
				By.xpath("//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[7]/td[2]"));
		if (comment.getText().equalsIgnoreCase("comment6")) {
		} else {
			Assert.fail();
		}
	}

	@AfterClass
	private static void stopTest() {
		driver.quit();
	}
}
