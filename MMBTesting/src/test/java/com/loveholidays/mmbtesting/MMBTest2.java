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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 *
 * @author Arjun
 */
public class MMBTest2 {
    
    
 public WebDriver driver;
       String MMBUrl="https://www.loveholidays.com/manage/login.html";
       
    @BeforeTest
    public void chromeExtension()
    {
     System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
  
     driver=new ChromeDriver();
    }
   
  @Test
  public void Scenario2()
 {
     driver.get(MMBUrl);
     driver.findElement(By.xpath("//INPUT[@id='js-reference-field-with-letters']")).sendKeys("LVE1702LCCCQV9H");
     driver.findElement(By.xpath("(//INPUT[@class='mmb-login__form__field__input'])[2]")).sendKeys("Test");
     driver.findElement(By.xpath("//BUTTON[@type='submit'][text()='Sign in']")).click();
     
     WebElement errorMessage=driver.findElement(By.xpath("//P[@class='error'][text()='Sorry this is not a valid booking reference. If you have booked within the last 24 hours please wait until you receive your LOV or LVE reference number by email before logging in.']"));
     String errorText2=errorMessage.getText();
    
     Assert.assertEquals(errorText2.contains("Sorry this is not a valid booking reference. If you have booked within the last 24 hours please wait until you receive your LOV or LVE reference number by email before logging in."),true);
  
 }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }
}
