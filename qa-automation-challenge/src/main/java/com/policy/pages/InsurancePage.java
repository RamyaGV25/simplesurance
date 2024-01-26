package com.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class InsurancePage extends BasePage{
	WebDriver driver;
	
	public InsurancePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Certificate number']/ancestor::td//following-sibling::td/div")
	public static WebElement certificateNumberText;
	
	@FindBy(xpath="//span[text()='Product Group']/ancestor::td//following-sibling::td/div")
	public static WebElement productGroupText;
	
	@FindBy(xpath="//span[text()='E-Mail']/ancestor::td//following-sibling::td/div")
	public static WebElement emailText;

	
	public void verifyPolicyNumber() {
		waitForWebElementToAppear(certificateNumberText);
		Assert.assertTrue(certificateNumberText.isDisplayed());
		System.out.println("Insurance is created successfully with the policy number: "+certificateNumberText.getText());
	}
	
}
