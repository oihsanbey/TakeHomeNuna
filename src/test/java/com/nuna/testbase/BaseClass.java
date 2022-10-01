package com.nuna.testbase;

import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.nuna.utils.JsonReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public static WebDriver driver;

public static void setUp() throws FileNotFoundException {
		
		JsonReader.readProperties(System.getProperty("user.dir") + "/src/test/resources/configs/configuration.json");
		
		if (JsonReader.getJsonProperty("browser").equalsIgnoreCase("chrome")) {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		}
		
		else if (JsonReader.getJsonProperty("browser").equalsIgnoreCase("firefox")) {
		
		WebDriverManager.firefoxdriver().setup();
		
		driver = new FirefoxDriver();
		
		}
		
		else {
			throw new RuntimeException("Browser is not supported");
		}
		
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get(JsonReader.getJsonProperty("url"));
		PageInitializer.initialize();
		
		}


public static void tearDown() {
	if (driver != null) {
		driver.quit();
	}
}

}
