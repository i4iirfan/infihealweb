package DisorderPathway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
public class BaseClassDisorder {
    protected WebDriver driver;
    protected WebElement buttonToBeClicked;
    @BeforeClass
    public void setUp() {
        // Launch Firefox browser
        driver = new FirefoxDriver();
        //maximize the screen
        driver.manage().window().maximize();
        //chatbot URL
        driver.get("https://sites.google.com/view/infiheal-bot/home?pli=1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        switchToChatFrame();
    }
    @AfterClass
    public void closeBrowser() {
        // Close the browser
        driver.quit();
    }
    protected void switchToChatFrame() {
        // Code for switching to chat frame
        WebElement frameText = driver.findElement(By.id("4125111757051f9_0"));
        driver.switchTo().frame(frameText);
        driver.switchTo().frame(0);
        WebElement frame2 = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(frame2);
        WebElement frame3 = driver.findElement(By.xpath(".//iframe[@src='https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs']"));
        driver.switchTo().frame(frame3);
        waitForVisibility(By.xpath(".//p[contains(text(),'nice to')]"));
    }
    protected void waitForVisibility(By locator) {
        //wait for the element visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    protected void send() {
        //send button
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
    }
      protected void button(By locator){
        //options to be clicked
           buttonToBeClicked = driver.findElement(locator);
           buttonToBeClicked.click();
      }
      protected void yes(){
          //Yes Button
          driver.findElement(By.xpath(".//button[@title='Yes']")).click();
      }
      protected  void no(){
        //no button
          driver.findElement(By.xpath(".//button[@title='No']")).click();
      }
      protected void input(String message){
          //enter text field and type message
          WebElement text = driver.findElement(By.xpath(".//input[@placeholder='Type your message']"));
          text.sendKeys(message);
      }
      protected  void male(){
        //Male button
          driver.findElement(By.xpath(".//button[@title='male']")).click();
      }
}

