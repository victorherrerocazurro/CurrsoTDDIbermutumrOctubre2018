package com.curso.tdd.aceptacion;

import java.util.concurrent.TimeUnit;

import org.concordion.api.BeforeSpecification;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(ConcordionRunner.class)
public class SepararNombresFrontATFixture {

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeSpecification
	public void init() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Madtocurso01\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://localhost:8080";
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public ResultadoTestSepararNombres partir(String nombreCompleto) {
		
		driver.get(baseUrl + "/index.html");
		
		driver.findElement(By.id("nombreCompleto")).sendKeys(nombreCompleto);
		driver.findElement(By.id("partir")).click();

		//A partir de aqui estamos viendo la tabla con el nombrecompleto partido
		
		String nombre = driver.findElement(By.id("nombre")).getText();
		String apellido = driver.findElement(By.id("apellido")).getText();
		
		return new ResultadoTestSepararNombres(nombre, apellido);
	}

	class ResultadoTestSepararNombres {
		public String nombre;
		public String apellido;
		public ResultadoTestSepararNombres(String nombre, String apellido) {
			super();
			this.nombre = nombre;
			this.apellido = apellido;
		}
	}
	
}
