package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Collections;
import java.util.List;

public class LoginTest extends BaseTest {
    String baseUrl = "https://www.saucedemo.com/";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValid(){
        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password in password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //click on 'LOGIN' button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        //verify the text 'PRODUCT'
        String expectedTextDisplay = "Products";
        WebElement actualTextElement = driver.findElement(By.xpath("//*[@class='title']"));
        String actualTextDisplay = actualTextElement.getText();
        Assert.assertEquals("Text is Display", expectedTextDisplay, actualTextDisplay);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        //Enter username in username field
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        //Enter password in password field
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        //click on 'LOGIN' button
        WebElement loginBtn = driver.findElement(By.id("login-button"));
        loginBtn.click();
        //Verify that six products are displayed
        List<WebElement> links = Collections.singletonList(driver.findElement(By.tagName("a")));
        System.out.println("Number of product= "+ links.size());

    }
//    @After
//    public void tearDown(){
//        closeBrowser();
//    }
}
