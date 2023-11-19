package pages;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	WebDriverWait wait;
	Random rnd = new Random();

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public int generateRandomnum(int boundryNum) {
		return rnd.nextInt(boundryNum);
	}

	// Element

	@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
	public WebElement UserName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
	public WebElement Password;

	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
	public WebElement SignInButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/a/span[1]")
	public WebElement BankCashButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[10]/ul/li[1]/a")
	public WebElement NewAccountButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[1]/h5")
	public WebElement AddNewAccountButton;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]")
	public WebElement accountTitleField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"description\"]")
	public WebElement descriptionField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"balance\"]")
	public WebElement initialBalanceField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"account_number\"]")
	public WebElement accountNumberField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_person\"]")
	public WebElement contactPersonField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"contact_phone\"]")
	public WebElement phoneField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"ib_url\"]")
	public WebElement internetBankingURLField;

	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div[2]/form/button")
	public WebElement submitButton;

	@FindBy(how = How.XPATH, using = "/html/body/section/div/div[1]/div[3]/div[1]")
	public WebElement accountCreatedSuccessfully;

	// Intractable Methods
	public void enterUserName(String username) {
		UserName.sendKeys(username);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSignInButton() {
		SignInButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getPageTitle() {
		return driver.getTitle();

	}

	public void clickBankCash() {
		BankCashButton.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickNewAccount() throws InterruptedException {
		NewAccountButton.click();
		Thread.sleep(60);
	}

	public void AddNewAccount() {
		AddNewAccountButton.click();
	}

	public void enterAccountTitle(String accountTitle) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(accountTitleField)).sendKeys(accountTitle + generateRandomnum(9999));
	}

	public void enterDescription(String description)  {
		
		descriptionField.sendKeys(description + generateRandomnum(9999));
	}

	public void enterInitialBalance(String initialBalance) {
		initialBalanceField.sendKeys(initialBalance + generateRandomnum(9999));
	}

	public void enterAccountNumber(String accountNumber) {
		accountNumberField.sendKeys(accountNumber + generateRandomnum(9999));
	}

	public void enterContactPerson(String contactPerson) {
		contactPersonField.sendKeys(contactPerson + generateRandomnum(9999));
	}

	public void enterPhone(String phone) {
	//wait.until(ExpectedConditions.visibilityOf(phoneField)).sendKeys(phone + generateRandomnum(9999));
		phoneField.sendKeys(phone + generateRandomnum(9999));
	}

	public void enterInternetBankingURL(String internetBankingURL)  {
		

		internetBankingURLField.sendKeys(internetBankingURL + generateRandomnum(9999));
	}

	public void clickSubmit() throws InterruptedException {
		Thread.sleep(10000);
		submitButton.click();
	}

	public boolean isAccountCreatedSuccessfully() throws TimeoutException {
		wait.until(ExpectedConditions.visibilityOf(accountCreatedSuccessfully));
		return true;

	}

}
