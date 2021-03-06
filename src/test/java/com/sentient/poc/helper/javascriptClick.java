package com.sentient.poc.helper;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptClick {

	private WebDriver driver;
	private JavascriptExecutor javascriptExecutor;

	public javascriptClick(WebDriver driver) {
		this.driver = driver;

	}

	public void click(WebElement element) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].click()", element);
	}
	
	
	public void sendKeys(WebElement element,String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].value='"+value+"';", element);
	}
	
	public void enterRichText(WebElement element,String value) {
		javascriptExecutor = (JavascriptExecutor) driver;
		javascriptExecutor.executeScript("arguments[0].innerHTML='"+value+"';", element);
	}
	
// border: 2px solid;
	public void highLighterMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow;');", element);
	}
}
