/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.loveholidays.mmbtesting;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Arjun
 */
public class MMBTest1 {
       public WebDriver driver;
       String MMBUrl="https://www.loveholidays.com/manage/login.html";
       
    @BeforeTest
    public void chromeExtension()
    {
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
  
     driver=new ChromeDriver();
    }
   @Test
    public void Scenario1() throws InterruptedException 
    {   
    
      driver.get(MMBUrl);
      String expectedMessage="Your booking reference number starts with LVE or LOV and can be found on your booking summary";
      WebElement referenceField= driver.findElement(By.xpath("//INPUT[@id='js-reference-field-with-letters']"));
      WebElement submitButton=driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='Sign in']"));
      WebElement surnameField=driver.findElement(By.xpath("(//INPUT[@class='mmb-login__form__field__input'])[2]"));
 
      referenceField.click();
      referenceField.sendKeys("1702LCCCQV9H");
      submitButton.click();
   
      String errorText=referenceField.getAttribute("oninvalid");
      
    //The below assert statement returns false as the expected message contains the word "number" which the actual message doesn't
      Assert.assertEquals(errorText.contains(expectedMessage),true);
     
    }
    @AfterTest
    public void tearDown(){
        driver.close();
    }

  
}
