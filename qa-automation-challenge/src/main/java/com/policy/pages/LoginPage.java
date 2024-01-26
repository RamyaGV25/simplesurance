package com.policy.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BasePage {
	
	WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
        PageFactory.initElements(driver, this);
    }


	@FindBy(id="login_username")
	public static WebElement usernameInput;
	
	@FindBy(id="login_password")
	public static WebElement passwordInput;
	
	@FindBy(xpath="//button[@type='submit']")
	public static WebElement nextButton;
	
	@FindBy(xpath="//button[@aria-label='Menu']")
	public static WebElement languageDropdown;
	
	@FindBy(xpath="//ul[@role='menu']/li[@role='menuitem']/span[contains(text(),'Englisch') or contains(text(),'English')]")
	public static WebElement languageOption;
	
	
	public void selectLanguage() {
		languageDropdown.click();
		languageOption.click();
		
	}
    
    public void userLogin(String username,String password) {
    	usernameInput.sendKeys(username);
    	passwordInput.sendKeys(password);
    	nextButton.click();
    }


}
