package IssuePathway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClassIssuePathway {
    WebDriver driver;
    @BeforeClass
    public void commonMethods(){
        driver = new FirefoxDriver();
        driver.get("https://sites.google.com/view/infiheal-bot/home?pli=1");
        driver.manage().window().maximize();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement frameText = driver.findElement(By.id("4125111757051f9_0"));
        driver.switchTo().frame(frameText);
        driver.switchTo().frame(0);
        WebElement frame2 = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(frame2);
        WebElement frame3 = driver.findElement(By.xpath(".//iframe[@src='https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs']"));
        driver.switchTo().frame(frame3);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'nice to')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("IRFAN");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[text()='No']")));
        driver.findElement(By.xpath("(.//button[@aria-keyshortcuts='Alt + Shift + A'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//span[text()='No']")));
        driver.findElement(By.xpath("(.//button[@aria-keyshortcuts='Alt + Shift + A'])[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@title='Social']")));
    }

}
