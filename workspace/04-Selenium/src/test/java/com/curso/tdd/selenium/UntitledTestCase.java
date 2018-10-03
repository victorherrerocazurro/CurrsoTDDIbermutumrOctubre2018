package com.curso.tdd.selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UntitledTestCase {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madtocurso01\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.wikipedia.org/";
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		driver.get(baseUrl);//Escribir en el espacio para las URLs del navegador
		//Espera es motivada porque los enlaces de los distintos idiomas, se cargan con javascript, 
		//y el timeout que  tenemos definido solo afecta a la navegacion, a la carga del primer HTML
		
		By cssSelectorLinkSpain = By.cssSelector("#js-link-box-es > strong");
		
		//Esperaria a que el eleemnto este presente, fallando si pasan 30 segundos
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(cssSelectorLinkSpain));
		
		//Espera siempe 1sg aunque el elemento este presente antes. 
		/*synchronized (driver)
		{
			driver.wait(1000); //1 sg
		}*/
		
		driver.findElement(cssSelectorLinkSpain).click();
		driver.findElement(By.id("searchInput")).click();
		driver.findElement(By.id("searchInput")).clear();
		driver.findElement(By.id("searchInput")).sendKeys("selenium");
		driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
		String cabecera = driver.findElement(By.id("firstHeading")).getText();
		
		assertEquals("Selenium", cabecera);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
