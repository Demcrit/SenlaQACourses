package com.zabi.stand_tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
    private final String URL = "http://86.57.161.116:10008/#/login";
    @SuppressWarnings("unused")
	private WebDriver driver;

	@FindBy(id = "logininput")
	private WebElement login;

	@FindBy(id = "passwordinput")
	private WebElement password;

	@FindBy(id = "buttonLogin")
	private WebElement buttonLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if (!driver.getCurrentUrl().equals(URL))
		{
			throw new IllegalStateException("This is not login page!");
		}
		
	}
	
	public void login(String login,String password){
		this.login.sendKeys(login);
		this.password.sendKeys(password);
		buttonLogin.click();
	}
	
	
	
	

}
