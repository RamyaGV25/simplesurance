package com.policy.pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateInsurancePage extends BasePage {

	WebDriver driver;
	
	public CreateInsurancePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "country-select")
	public static WebElement countryDropdown;
	
	@FindBy(xpath = "//ul[@aria-labelledby='country-select-label']/li[@role='option']/span[contains(text(),'German')]")
    public static WebElement countryOption;
	
	@FindBy(id = "product-name-select")
	public static WebElement productNameInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='product-name-select-label']/li")
	public static WebElement productNameOption;
	
	@FindBy(id = "tariff-name-select")
	public static WebElement tariffNameInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='tariff-name-select-label']/li")
	public static WebElement tariffNameOption;
	
	@FindBy(id = "category-name-select")
	public static WebElement insuranceCategoryInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='category-name-select-label']/li")
	public static WebElement insuranceCategoryOption;
	
	@FindBy(id = "duration-select")
	public static WebElement periodInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='duration-select-label']/li")
	public static List<WebElement> periodOption;
	
	@FindBy(id = "frequency-select")
	public static WebElement paymentTypeInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='frequency-select-label']/li")
	public static WebElement paymentTypeOption;
	
	@FindBy(id = "class-name-select")
	public static WebElement classInput;
	
	@FindBy(xpath = "//ul[@aria-labelledby='class-name-select-label']/li")
	public static List<WebElement> classOption;
	
	@FindBy(id = "input-createCertificate_serialNumber")
	public static WebElement serialNumberInput;
	
	@FindBy(name = "deviceName")
	public static WebElement DeviceNameInput;
	
	@FindBy(name = "invoiceNumber")
	public static WebElement InvoiceInput;
	
	@FindBy(xpath="//span[text()='Next']/parent::button")
	public static WebElement nextButton;
	
	@FindBy(id = "input-createCertificate_firstName")
	public static WebElement firstNameInput;
	
	@FindBy(id = "input-createCertificate_lastName")
	public static WebElement lastNameInput;

	@FindBy(id = "input-createCertificate_email")
	public static WebElement emailInput;
	
	@FindBy(id = "input-createCertificate_streetName")
	public static WebElement streetNameInput;
	
	@FindBy(id = "input-createCertificate_streetNumber")
	public static WebElement streetNumberInput;
	
	@FindBy(id = "input-createCertificate_zip")
	public static WebElement postalCodeInput;
	
	@FindBy(id = "input-createCertificate_city")
	public static WebElement cityInput;
	
	@FindBy(id = "input-createCertificate_country")
	public static WebElement countryInput;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> selectCheckbox;
	
	@FindBy(xpath="//span[text()='Create insurance']/parent::button")
	public static WebElement createInsuranceButton;
	
	@FindBy(xpath="//*[name()='svg'][@data-testid='ExitToAppIcon']")
	public static WebElement logOutButton;
	
	
	
	public void selectCountry() {
		waitForWebElementToAppear(countryDropdown);
		countryDropdown.click();
		waitForWebElementToAppear(countryOption);
		countryOption.click();
	}
	
	public void selectProductName(){
		waitForWebElementToAppear(productNameInput);
		productNameInput.click();
		waitForWebElementToAppear(productNameOption);
		productNameOption.click();
	}
	
	public void selectTariffName() {
		waitForWebElementToAppear(tariffNameInput);
		tariffNameInput.click();
		waitForWebElementToAppear(tariffNameOption);
		tariffNameOption.click();
	}
	
	public void selectInsuranceCategory() {
		waitForWebElementToAppear(insuranceCategoryInput);
		insuranceCategoryInput.click();
		waitForWebElementToAppear(insuranceCategoryOption);
		insuranceCategoryOption.click();
	}
	
	public void selectPeriod(){
		waitForWebElementToAppear(periodInput);
		periodInput.click();
		waitForWebElementToAppear(periodOption.get(0));
		periodOption.get(0).click();
	}
	
	public void selectPaymentType(){
		waitForWebElementToAppear(paymentTypeInput);
		paymentTypeInput.click();
		waitForWebElementToAppear(paymentTypeOption);
		paymentTypeOption.click();
	}
	
	public void selectClass() {
		waitForWebElementToAppear(classInput);
		classInput.click();
		waitForWebElementToAppear(classOption.get(0));
		classOption.get(0).click();
	}
	
	public void enterSerialNumber() {
		waitForWebElementToAppear(serialNumberInput);
		serialNumberInput.sendKeys("AB1ABC1234567890");
	}
	
	public void clickNext() {
		waitForWebElementToAppear(nextButton);
		nextButton.click();
	}
	
	public void enterFirstName() {
		waitForWebElementToAppear(firstNameInput);
		firstNameInput.sendKeys("Ramya");
	}
	public void enterLastName() {
		waitForWebElementToAppear(lastNameInput);
		lastNameInput.sendKeys("GV");
	}
	
	public void enterEmail() {
		waitForWebElementToAppear(emailInput);
		emailInput.sendKeys("Ramya@gmail.com");
	}
	
	public void enterStreetName() {
		waitForWebElementToAppear(streetNameInput);
		streetNameInput.sendKeys("Reisstraße");
	}
	
	public void enterStreetNumber() {
		waitForWebElementToAppear(streetNumberInput);
		streetNumberInput.sendKeys("22");
	}
	
	public void enterPostalCode() {
		waitForWebElementToAppear(postalCodeInput);
		postalCodeInput.sendKeys("13629");
	}
	
	public void enterCity() {
		waitForWebElementToAppear(cityInput);
		cityInput.sendKeys("Berlin");
	}
	
	public void enterCountry() {
		waitForWebElementToAppear(countryInput);
		countryInput.sendKeys("DE");
	}
	
	public void selectAllCheckboxes() {
		for(int i=0;i<selectCheckbox.size();i++) {
			selectCheckbox.get(i).click();
		}
	}
	
	
	public void clickCreateInsurance() {
		waitForWebElementToAppear(createInsuranceButton);
		createInsuranceButton.click();
	}
	
	public void clickLogout() {
		waitForWebElementToAppear(logOutButton);
		logOutButton.click();
	}
	
}
