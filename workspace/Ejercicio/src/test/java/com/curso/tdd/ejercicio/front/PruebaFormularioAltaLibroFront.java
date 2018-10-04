package com.curso.tdd.ejercicio.front;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//- Los datos llegaran a la aplicacion por medio de un formulario Web. (Front)

public class PruebaFormularioAltaLibroFront {

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
		
		//Posible uso de DBUnit para inicilizar es estado
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		//datos de Prueba
		String caberaEsperada = "Selenium";
		String titulo = "titulo";
		String autor = "autor";
		
		driver.get(baseUrl);//Escribir en el espacio para las URLs del navegador
		//Espera es motivada porque los enlaces de los distintos idiomas, se cargan con javascript, 
		//y el timeout que  tenemos definido solo afecta a la navegacion, a la carga del primer HTML
		driver.findElement(By.id("campoTitulo")).sendKeys(titulo);
		driver.findElement(By.id("campoAutor")).sendKeys(autor);
		driver.findElement(By.id("botonAlta")).click();

		String cabecera = driver.findElement(By.id("feedback")).getText();
		
		//verificacion
		assertEquals(caberaEsperada, cabecera);
		
		//Aqui dado que el alta del sistema incluye la insercion en BD, 
		//se deberia comprobar que se esta realizando de forma  correcta 
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

}
