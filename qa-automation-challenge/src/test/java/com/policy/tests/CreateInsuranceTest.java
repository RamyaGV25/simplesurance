package com.policy.tests;

import org.testng.annotations.Test;

import com.policy.pages.CreateInsurancePage;
import com.policy.pages.HomePage;
import com.policy.pages.InsurancePage;
import com.policy.pages.LoginPage;
import com.policy.pages.PaymentPage;

public class CreateInsuranceTest extends BaseTest{

	@Test(invocationCount = 3)
	public void createInsurance()  {
		LoginPage loginPage = new LoginPage(driver);
		HomePage homePage = new HomePage(driver);
		CreateInsurancePage createInsurancePage = new CreateInsurancePage(driver);
		PaymentPage paymentPage = new PaymentPage(driver);
		InsurancePage insurancePage = new InsurancePage(driver);
		driver.get("https://insurance-manager.sb-qa-candidatetask-2.sisu.sh/login");
		loginPage.selectLanguage();
		loginPage.userLogin("testsellingpartner2@simplesurance.de", "TestSellingPartner2Pass");
		homePage.clickNewButton();
		
		//input mandatory fields
		createInsurancePage.selectCountry();
		createInsurancePage.selectProductName();
		createInsurancePage.selectTariffName();
		createInsurancePage.selectInsuranceCategory();
		createInsurancePage.selectPeriod();
		createInsurancePage.selectPaymentType();
		createInsurancePage.selectClass();
		createInsurancePage.enterSerialNumber();
		createInsurancePage.clickNext();
		createInsurancePage.enterFirstName();
		createInsurancePage.enterLastName();
		createInsurancePage.enterEmail();
		createInsurancePage.enterStreetName();
		createInsurancePage.enterStreetNumber();
		createInsurancePage.enterPostalCode();
		createInsurancePage.enterCity();
		createInsurancePage.enterCountry();
		createInsurancePage.clickNext();
		createInsurancePage.selectAllCheckboxes();
		createInsurancePage.clickCreateInsurance();
		
		//select payment option
		paymentPage.selectDebitCardPaymentOption();
		paymentPage.ClickContinueToPaymentButton();
		paymentPage.enterIban();
		paymentPage.selectCheckbox();
		paymentPage.clickOrderForCostButton();
		paymentPage.clickChooseAnotherPaymentMethodButton();
		
		paymentPage.ClickContinueToPaymentButton();
		paymentPage.enterCreditCardNumber();
		paymentPage.enterExpiryDate();
		paymentPage.enterCvc();
		paymentPage.clickOrderForCostButton();
		
		
	
		//verify policy number
		
		insurancePage.verifyPolicyNumber();
		createInsurancePage.clickLogout();
		
	}
}
