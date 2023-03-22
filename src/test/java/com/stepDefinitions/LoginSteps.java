package com.stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.pages.LoginPage;
import com.pages.MainPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginSteps {
	private WebDriver driver;
	public String url = "https://www.saucedemo.com/";
	MainPage mainPage;
	LoginPage loginPag;

	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "src/test/resources/chromeDriver/chromedriver.exe");
//		driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}

	@After

	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			String testName = scenario.getName();
			// take a screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			// embed screenshot into cucumber report
			scenario.attach(screenshot, "image/png", testName);
		}

		if (driver != null) {
			driver.quit();
		}
	}

	@Given("I am on the Sauce Demo Login Page")
	public void i_am_on_the_sauce_demo_login_page() throws InterruptedException {
		System.out.println("-----------------");
		driver.get(url);
		Thread.sleep(5000);

	}

	@When("I fill the account information for account StandardUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_standard_user_into_the_username_field_and_the_password_field()
			throws InterruptedException {
		loginPag=new LoginPage(driver);
		System.out.println("login in progress ......");
		loginPag.enteruserName("standard_user");
		Thread.sleep(1000);
		loginPag.enterPassword("secret_sauce");
		Thread.sleep(1000);
	}

	@When("I click the Login Button")
	public void i_click_the_login_button() throws InterruptedException {
		WebElement loginButton = driver.findElement(By.id("login-button"));
		loginButton.click();
		Thread.sleep(1000);

	}

	@Then("I am redirected to the Sauce Demo Main Page")
	public void i_am_redirected_to_the_sauce_demo_main_page() throws InterruptedException {
		mainPage = new MainPage(driver);
		System.out.println(mainPage.isInventoryContainerDisplayed());
		Thread.sleep(1000);
	}

	@Then("I verify the App Logo exists")
	public void i_verify_the_app_logo_exists() throws InterruptedException {
		mainPage=new MainPage(driver);
		System.out.println("logo printed" + mainPage.isAppLogoDisplayed());
		Thread.sleep(1000);
	}

	@When("I fill the account information for account LockedOutUser into theUsername field and the Password field")
	public void i_fill_the_account_information_for_account_locked_out_user_into_the_username_field_and_the_password_field()
			throws InterruptedException {
		loginPag=new LoginPage(driver);
		loginPag.enteruserName("locked_out_user");
		Thread.sleep(1000);
		loginPag.enterPassword("secret_sauce");
		Thread.sleep(1000);
	}

	@Then("I verify the Error Message contains the text {string}")
	public void i_verify_the_error_message_contains_the_text(String string) throws InterruptedException {
		loginPag=new LoginPage(driver);
		loginPag.verifyErrorMessage("Sorry, this user has been banned.");
		
	}
	
	}
