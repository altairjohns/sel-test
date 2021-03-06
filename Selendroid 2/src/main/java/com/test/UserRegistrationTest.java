package com.test;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;

/**
 * Base Test to demonstrate how to test native android apps with Selendroid. App under test is:
 * src/main/resources/selendroid-test-app-0.17.0.apk
 * 
 * @author ddary
 */
public class UserRegistrationTest {
  private WebDriver driver = null;

  @Before
  public void setup() throws Exception {
    driver = new SelendroidDriver(new SelendroidCapabilities("io.selendroid.testapp:0.17.0"));
  }

  @Test
  public void assertUserAccountCanRegistered() throws Exception {
    // Initialize test data
    UserDO user = new UserDO("u$erNAme", "me@myserver.com", "mySecret", "John Doe", "Python");

    registerUser(user);
    verifyUser(user);
  }

  private void registerUser(UserDO user) throws Exception {
    driver.get("and-activity://io.selendroid.testapp.RegisterUserActivity");

    WebElement username = driver.findElement(By.id("inputUsername"));
    username.sendKeys(user.username);

    driver.findElement(By.name("email of the customer")).sendKeys(user.email);
    driver.findElement(By.id("inputPassword")).sendKeys(user.password);

    WebElement nameInput = driver.findElement(By.xpath("//EditText[@id='inputName']"));
    Assert.assertEquals(nameInput.getText(), "Mr. Burns");
    nameInput.clear();
    nameInput.sendKeys(user.name);

    driver.findElement(By.tagName("Spinner")).click();
    driver.findElement(By.linkText(user.programmingLanguage)).click();

    driver.findElement(By.className("android.widget.CheckBox")).click();

    driver.findElement(By.linkText("Register User (verify)")).click();
    Assert.assertEquals(driver.getCurrentUrl(), "and-activity://VerifyUserActivity");
  }

  private void verifyUser(UserDO user) throws Exception {
    Assert.assertEquals(driver.findElement(By.id("label_username_data")).getText(), user.username);
    Assert.assertEquals(driver.findElement(By.id("label_email_data")).getText(), user.email);
    Assert.assertEquals(driver.findElement(By.id("label_password_data")).getText(), user.password);
    Assert.assertEquals(driver.findElement(By.id("label_name_data")).getText(), user.name);
    Assert.assertEquals(driver.findElement(By.id("label_preferedProgrammingLanguage_data"))
        .getText(), user.programmingLanguage);
    Assert.assertEquals(driver.findElement(By.id("label_acceptAdds_data")).getText(), "true");
  }

  @After
  public void teardown() {
    driver.quit();
  }
}