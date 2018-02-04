package com.zabi.db_test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zabi.stand_tests.pageobjects.ProfilePage;

public class ProfileTests {

	private static WebDriver driver;
	private static final String URL = "http://86.57.161.116:10008/";
	ProfilePage profilePage = PageFactory.initElements(driver, ProfilePage.class);
	Profile profile;

	@BeforeClass
	public void startSetup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(URL + "#/login");
		driver.manage().window().maximize();
		profilePage.getUserMenu();
		profile  = new HibernateUtil().getProfile();
}
	
	@Test
	public void nameCheck() {
		Assert.assertEquals(profilePage.getName(),profile.getFirst_name());
	}

	@Test
	public void emailCheck() {
		Assert.assertEquals(profilePage.getEmail(), profile.getEmail());
	}

	@Test
	public void phoneNumberCheck() {
		Assert.assertEquals(profilePage.getPhone(), profile.getPhone());
	}

	@Test
	public void skypeCheck() {
		Assert.assertEquals(profilePage.getSkype(),profile.getSkype());
	}

	@Test
	public void locationCheck() {
		Assert.assertEquals(profilePage.getLocation(), profile.getLocation_fk().getCountry());
	}

	@Test
	public void officeCheck() {
		Assert.assertEquals(profilePage.getOffice(),profile.getLocation_fk().getOffice());
	}

	@Test
	public void specializationCheck() {
		Assert.assertEquals(profilePage.getSpecialization(),profile.getSpecialization_fk().getName());
	}

	@Test
	public void workstationCheck() {
		Assert.assertEquals(profilePage.getWorkstation(), profile.getWorkstation());
	}

	@Test
	public void commentCheck() {
		Assert.assertEquals(profilePage.getComment(),profile.getRm_comment());
	}

	@AfterClass
	private static void stopTest() {
		driver.quit();
	}
}