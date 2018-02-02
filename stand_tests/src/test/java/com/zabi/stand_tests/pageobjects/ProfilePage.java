package com.zabi.stand_tests.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.zabi.stand_tests.user.User;

public class ProfilePage {

	private static WebDriver driver;
	User user = new User();

	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	private static WebElement name;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	private static WebElement profile;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	private static WebElement email;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[1]/td[2]")
	private static WebElement phone;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[1]/tbody/tr[3]/td[2]")
	private static WebElement skype;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[7]/td[2]")
	private static WebElement comment;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[6]/td[2]")
	private static WebElement workstation;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[3]/tbody/tr[2]/td[2]")
	private static WebElement specialization;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[1]/td[2]")
	private static WebElement location;
	@FindBy(xpath = "//*[@id='main']/section/div[2]/div/div[2]/div/div[2]/table[2]/tbody/tr[5]/td[2]")
	private static WebElement office;

	public ProfilePage(WebDriver driver) {
		this.driver = driver;
	}

	public void getUserMenu() {
		LoginPage lg = PageFactory.initElements(driver, LoginPage.class);
		lg.login(user.getLogin(), user.getPassword());
		WebElement user = driver.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a"));
		user.click();
		WebElement profile = driver
				.findElement(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/ul/li[1]"));
		profile.click();
	}

	public String getName() {
		return name.getText();
	}

	public String getProfile() {
		return profile.getText();
	}

	public String getEmail() {
		return email.getText();
	}

	public String getPhone() {
		return phone.getText();
	}

	public String getSkype() {
		return skype.getText();
	}

	public String getComment() {
		return comment.getText();
	}

	public String getWorkstation() {
		return workstation.getText();
	}

	public String getSpecialization() {
		return specialization.getText();
	}

	public String getLocation() {
		return location.getText();
	}

	public String getOffice() {
		return office.getText();
	}

}
