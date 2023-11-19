package steps;

import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
	LoginPage loginPage;

	@Given("User is on the techfios login page")
	public void user_is_on_the_techfios_login_page() {
		initDriver();
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		driver.get("https://techfios.com/billing/?ng=admin/");
	}

	@When("User enters the {string} in the {string} field")
	public void whenUserEntersValueInTheField(String value, String fieldName) {

		switch (fieldName) {
		case "username":
			loginPage.enterUserName(value);
			break;
		case "password":
			loginPage.enterPassword(value);
			break;

		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);
		}
	}

	@When("User clicks on  {string}")
	public void user_clicks_on(String signin) {
		loginPage.clickSignInButton();
	}

	@Then("User should land on Dashboard page")
	public void user_should_land_on_Dashboard_page() {
		String expectedTitle = "Dashboard- iBilling";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals("Page Title is not matchig", expectedTitle, actualTitle);
	}

	@Then("User clicks on {string}")
	public void user_clicks_on_specific_button(String buttonName) throws InterruptedException {
		switch (buttonName.toLowerCase()) {
		case "bank/cash":
			loginPage.clickBankCash();
			break;
		case "new account":
			loginPage.clickNewAccount();
			break;
		case "submit":
			loginPage.clickSubmit();
			break;

		default:
			throw new IllegalArgumentException("Invalid button name: " + buttonName);
		}
	}

	@And("User enters accountTitle as {string} in the  account Titlefield in accounts page")
	public void user_enters_accountTitle_as_in_the_account_Titlefield_in_accounts_page(String string) {
		String expectedTitle = "Add New Account";
		String actualTitle = loginPage.getPageTitle();
		Assert.assertEquals("Page Title is not matchig", expectedTitle, actualTitle);
	}

	@Then("User enters {string} in the {string} field in accounts page")
	public void user_enters_in_the_field_in_accounts_page(String value, String fieldName) throws InterruptedException {
		switch (fieldName) {
		case "accountTitle":
			loginPage.enterAccountTitle(value);
			break;
		case "description":
			loginPage.enterDescription(value);
			break;
		case "initialBalance":
			loginPage.enterInitialBalance(value);
			break;
		case "accountNumber":
			loginPage.enterAccountNumber(value);
			break;
		case "contactPerson":
			loginPage.enterContactPerson(value);
			break;
		case "Phone":
			loginPage.enterPhone(value);
			break;
		case "internetBankingURL":
			loginPage.enterInternetBankingURL(value);
			break;
		default:
			throw new IllegalArgumentException("Invalid field name: " + fieldName);

		}

	}

	@Then("User should be able to validate account created successfully")
	public void user_should_be_able_to_validate_account_created_successfully() throws TimeoutException {

		if (loginPage.isAccountCreatedSuccessfully()) {
			System.out.println("Account created successfully!");

		} else {
			System.out.println("Account creation validation failed!");

		}

	}

}
