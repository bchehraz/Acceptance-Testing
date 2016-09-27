package edu.csumb.cst438fa16hello.webclient;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
* User story:
*
* As a user I want to make guesses and keep track of my guesses so that I am aware of my previous guesses.
*
*/

public class HangmanIT {
	
	WebDriver driver = new ChromeDriver();

	@Before
	public void setUp() {
		driver.get("http://localhost:8080/hangman.html");
	}

	@After
	public void tearDown() {
		driver.quit();
	}

	/**
	 *
	 * Acceptance test:
	 * 
	 * Given I am on the hangman page
	 * When I enter a letter 'b'
	 * Then I see the letter 'b' appear
	 */

	 @Test
	 public void testNewGuess() {
	 	driver.findElement(By.id("newGuesses")).sendKeys("b");
		driver.findElement(By.id("submit")).click();

		(new WebDriverWait(driver, 1)).until(ExpectedConditions.textToBe(By.id("oldGuesses"), "b"));
	 }
}
