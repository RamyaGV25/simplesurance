package com.policy.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ImportPage extends BasePage {
	
WebDriver driver;
	
	public ImportPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
        PageFactory.initElements(driver, this);
    }

	@FindBy(id="input-csv")
	public static WebElement importButton ;
	
	@FindBy(xpath="//span[text()='Create insurance']/parent::button")
	public static WebElement createInsuranceButton;
	
	@FindBy(xpath="//li[contains(text(),'Error')]")
	public static WebElement errorMessageText;
	
	
	public void importFile() {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "./src/test/resources/testdata.csv";
        System.out.println("File path: " + filePath);
        //waitForWebElementToAppear(importButton);
        importButton.sendKeys(filePath);

	}
	
	public void clickCreateInsurance() {
		waitForWebElementToAppear(createInsuranceButton);
		createInsuranceButton.click();
	}
	
	public void printErrorMessage() {
		waitForWebElementToAppear(errorMessageText);
    Assert.assertTrue(errorMessageText.isDisplayed());
    System.out.println("File Import error: "+errorMessageText.getText());
		
	}
	
	

}
