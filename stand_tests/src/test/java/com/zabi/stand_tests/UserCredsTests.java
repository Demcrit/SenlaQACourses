package com.zabi.stand_tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zabi.stand_tests.pageobjects.ProfilePage;

import junit.framework.Assert;

public class UserCredsTests {
	private static WebDriver driver;
	private static final String URL = "http://86.57.161.116:10008/";
	ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);

	@BeforeClass
	public void startSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL + "#/login");
		driver.manage().window().maximize();
		profilePage.getUserMenu();

	}

	@Test
	public void nameCheck() {
		Assert.assertEquals(profilePage.getName(), "Serge Tankjan");
	}

	@Test
	public void emailCheck() {
		Assert.assertEquals(profilePage.getEmail(), "serge@tankjan.com");
	}

	@Test
	public void phoneNumberCheck() {
		Assert.assertEquals(profilePage.getPhone(), "8-029-4739564");
	}

	@Test
	public void skypeCheck() {
		Assert.assertEquals(profilePage.getSkype(), "s_tan");
	}

	@Test
	public void locationCheck() {
		Assert.assertEquals(profilePage.getLocation(), "BLR_GRO");
	}

	@Test
	public void officceCheck() {
		Assert.assertEquals(profilePage.getOffice(), "1");
	}

	@Test
	public void specializationCheck() {
		Assert.assertEquals(profilePage.getSpecialization(), "Developer");
	}

	@Test
	public void workstationCheck() {
		Assert.assertEquals(profilePage.getWorkstation(), "dancogrod0067");
	}

	@Test
	public void commentCheck() {
		Assert.assertEquals(profilePage.getComment(), "comment6");
	}

	@AfterClass
	private static void stopTest() {
		driver.quit();
	}
}
