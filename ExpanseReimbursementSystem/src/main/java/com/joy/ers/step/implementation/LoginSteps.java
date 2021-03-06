package com.joy.ers.step.implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	public static WebDriver driver;

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		System.setProperty("webdriver.gecko.driver", "C:\\WebDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/");
		driver.manage().window().fullscreen();
		WebElement loginPage = driver.findElement(By.cssSelector("#loginbutton"));
		loginPage.click();
	}

	@When("User Navigate to LogIn Page")
	public void user_navigate_to_log_in_page() {
		System.out.println("Title of the page is " + driver.getTitle());
	}

	@When("User enters {string} and {string}")
	public void user_enters_and(String username, String passwd) {
		WebElement uname = driver.findElement(By.cssSelector("#user"));
		WebElement password = driver.findElement(By.cssSelector("#password"));
		WebElement loginBtn = driver.findElement(By.cssSelector("#loginbtn"));
		uname.sendKeys(username);
		password.sendKeys(passwd);
		loginBtn.click();
	}

	@Then("Message displayed Login Successfully")
	public void message_displayed_login_successfully() {
		Boolean display = driver.findElement(By.cssSelector("#logout")).isDisplayed();

		driver.close();

		if (display == true) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Incorrect Login");
		}
		driver.quit();
	}
}