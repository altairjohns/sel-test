package com.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import io.selendroid.standalone.android.AndroidApp;
public class Doremi {
	
	public WebDriver driver;
	private Object verificationErrors;
	   
    @Before
      public void setup() throws Exception {
        driver = new SelendroidDriver(new SelendroidCapabilities("com.satellite.safesatbold:2.0.0.5"));
    	driver.findElement(By.xpath("//LoginButton[@id='login_facebook']")).click();

	  	Thread.sleep(25000);
	  	
	  	driver.findElement(By.className("android.webkit.WebView")).sendKeys("altairjohnfbacc2@gmail.com");
	  	driver.switchTo().window("WEBVIEW");
	  	driver.findElement(By.id("u_0_2")).sendKeys("4dm1n123456");
	  	driver.findElement(By.id("u_0_6")).click();
	  	Thread.sleep(9000);
	  	driver.findElement(By.id("u_0_9")).click();
      }

    @Test
  public void assertUserAccountCanRegistred() throws Exception {
      //SelendroidCapabilities capa = new SelendroidCapabilities("com.satellite.safesatbold:2.0.0.5");
     // WebDriver driver = new SelendroidDriver(capa);
     // driver.findElement(By.id("com.satellite.safesatbold"));
//      Thread.sleep(5000);
//      driver.findElement(By.id("inputUsername")).sendKeys("Selendroid");
//      driver.findElement(By.id("inputEmail")).sendKeys("tester@selendroid.io");
//      driver.findElement(By.id("inputPassword")).sendKeys("12345");
//      driver.findElement(By.id("inputName")).clear();
//      driver.findElement(By.id("inputName")).sendKeys("KDA");
//      driver.findElement(By.id("input_preferedProgrammingLanguage")).click();
//      Thread.sleep(2000);
//      driver.findElement(By.linkText("Java")).click();
//      driver.findElement(By.id("btnRegisterUser")).click();
//      Thread.sleep(2000);
//      Assert.assertEquals(driver.findElement(By.id("label_name_data")).getText(), "KDA");
//      Assert.assertEquals(driver.findElement(By.id("label_username_data")).getText(), "Selendroid");
//      Assert.assertEquals(driver.findElement(By.id("label_password_data")).getText(), "12345");
//      Assert.assertEquals(driver.findElement(By.id("label_email_data")).getText(), "tester@selendroid.io");
//      Assert.assertEquals(driver.findElement(By.id("label_preferedProgrammingLanguage_data")).getText(), "Java");
//      Assert.assertEquals(driver.findElement(By.id("label_acceptAdds_data")).getText(), "false");
//      driver.findElement(By.id("buttonRegisterUser")).click();
//      Thread.sleep(5000);
      //driver.quit();
     
  }
    
   
}