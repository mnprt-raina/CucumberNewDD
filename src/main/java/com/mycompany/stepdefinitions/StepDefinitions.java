package com.mycompany.stepdefinitions;

import java.io.FileInputStream;
import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import cucumber.api.java.en.Given; 
import cucumber.api.java.en.When;

public class StepDefinitions 
{
	WebElement ele;
	WebDriver driver;
	static Document document;

	static 
	{
		try 
		{
			InputStream is = new FileInputStream(System.getProperty("user.dir"+ "//src//main//resources//object_repository//OR.xml"));
			SAXReader saxReader = new SAXReader();					
			document = saxReader.read(is);	

		} catch (Exception e) 
		{
			System.out.println("Exception occurred: "+e.getMessage());
		}
	}

	@Given("^The Homepage page displays$")
	public void loginPage()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mnprt\\Downloads\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.demoblaze.com/index.html");
/*
		String actualTitle = driver.getTitle();
		String expectedTitle = "STORE";
		Assert.assertTrue(actualTitle.contains(expectedTitle));

		driver.manage().timeouts().implicitlyWait(20, null);

		waitForJStoLoad(driver);
	}


	public boolean waitForJStoLoad(WebDriver driver) 
	{

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for Javascript to load
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
		{

			public Boolean apply(WebDriver driver) 
			{
				JavascriptExecutor jDriver = (JavascriptExecutor) driver;
				return jDriver.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return wait.until(expectation); */
	}

	@When("^User clicks on \"(.*)\" button$")
	public void click(String locator)
	{
		//go to xml
		//fetch the string locator
		//then do getWebElement
	}



	WebElement getWebElement(String locator)
	{
		String locatorName = document.selectSingleNode(locator).getText();	
		ele = driver.findElement(By.xpath(locatorName));
		return ele;
	}

	void getWebElementAndSendKeys(String locator,String value, WebElement ele)
	{
		getWebElement(locator).sendKeys(value);
		ele.sendKeys(Keys.ENTER);
	}
}
