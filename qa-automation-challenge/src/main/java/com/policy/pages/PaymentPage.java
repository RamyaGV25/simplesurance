package com.policy.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends BasePage {

	WebDriver driver;
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@type='radio'][@value='STRIPE.CARD']")
	public static WebElement creditCardRadioButton;
	
	@FindBy(xpath="//h2[text()='Bestellübersicht']/parent::div/div/div/p")
	public static WebElement productName;
	
	@FindBy(xpath="[@data-testid='total-component']")
	public static WebElement totalText;
	
	@FindBy(xpath="//span[text()='Weiter zur Bezahlung']/parent::button")
	public static WebElement continueToPaymentButton;
	
	@FindBy(name="cardnumber")
	public static WebElement cardNumberInput;
	
	@FindBy(name="exp-date")
	public static WebElement expiryDateInput;
	
	@FindBy(name="cvc")
	public static WebElement cvcInput;
	
	@FindBy(xpath="//span[text()='Kostenpflichtig bestellen']/parent::button")
	public static WebElement orderForCostButton;
	
	@FindBy(xpath="//p[contains(text(),'SEPA Lastschrift')]/ancestor::span/preceding-sibling::span")
	public static WebElement debitCardRadioButton;
	
	@FindBy(xpath="//input[@type='checkbox']/parent::span")
	public static WebElement selectCheckbox;
	
	@FindBy(xpath="//span[text()='Andere Zahlungsmethode wählen']/parent::button")
	public static WebElement chooseAnotherPaymentButton;
	
	@FindBy(name="iban")
	public static WebElement enterIban;
	
	@FindBy(xpath="//iframe[contains(@title,'IBAN')]")
	public static WebElement ibanFrame;
	
	@FindBy(xpath="//h1[text()='Die Zahlung wurde abgelehnt']")
	public static WebElement paymentRefusedText;
	
	public void selectDebitCardPaymentOption() {
		waitForWebElementToAppear(debitCardRadioButton);
		debitCardRadioButton.click();
	}
	
	public void ClickContinueToPaymentButton() {
		waitForWebElementToAppear(continueToPaymentButton);
		continueToPaymentButton.click();
	}
	
	public void enterIban() {
		driver.switchTo().frame(0);
		waitForWebElementToAppear(enterIban);
		enterIban.sendKeys("DE89370400440532013000");
		driver.switchTo().defaultContent();
	}
	
	public void selectCheckbox() {
		waitForWebElementToAppear(selectCheckbox);
		selectCheckbox.click();
	}
	
	public void clickOrderForCostButton() {
		waitForWebElementToAppear(orderForCostButton);
		orderForCostButton.click();
	}
	
	public void clickChooseAnotherPaymentMethodButton() {
		waitForWebElementToAppear(chooseAnotherPaymentButton);
		chooseAnotherPaymentButton.click();
	}
	
	public void enterCreditCardNumber() {
		driver.switchTo().frame(0);
		waitForWebElementToAppear(cardNumberInput);
		cardNumberInput.sendKeys("4242424242424242");
		driver.switchTo().defaultContent();
	}
	
	public void enterExpiryDate() {
		driver.switchTo().frame(0);
		waitForWebElementToAppear(expiryDateInput);
		expiryDateInput.sendKeys("0527");
		driver.switchTo().defaultContent();
	}
	
	public void enterCvc() {
		driver.switchTo().frame(0);
		waitForWebElementToAppear(cvcInput);
		cvcInput.sendKeys("123");
		driver.switchTo().defaultContent();
	}
}
