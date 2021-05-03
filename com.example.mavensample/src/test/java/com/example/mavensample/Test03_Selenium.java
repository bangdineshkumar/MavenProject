package com.example.mavensample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import newproject.FunctionLib;

public class Test03_Selenium {
	static WebDriver driver;
	@Test
	public void test_01() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "C:\\Dinesh Work\\chromedriver_win32\\chromedriver.exe");
    // System Property for Chrome Driver   
	driver=new ChromeDriver();
 driver.navigate().to("http://www.javatpoint.com/");  
  //Maximize the browser  
   driver.manage().window().maximize();  
   
   //Scroll down the webpage by 5000 pixels  
 FunctionLib.screenshotCapture(driver.findElement(By.linkText("Core Java")),driver);
 Thread.sleep(10000);	
 driver.navigate().back();
 Thread.sleep(10000);
 FunctionLib.screenshotCapture(driver.findElement(By.linkText("Servlet")),driver);
 Thread.sleep(10000);
 
	}
	
}
