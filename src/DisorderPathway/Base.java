package DisorderPathway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base{
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        // Open the web page
        driver.get("https://sites.google.com/view/infi-test-bot/home");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement frameText = driver.findElement(By.id("6c23c12a517f0af4_0"));
        driver.switchTo().frame(frameText);
        driver.switchTo().frame("innerFrame");
        WebElement frame2 = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(frame2);
        WebElement frame3 = driver.findElement(By.xpath(".//iframe[@src='https://webchat.botframework.com/embed/infi-dev?s=sVkwofWdQH4.ZxRnnBGYPObJdG_yaIV5jORe89agU-HfhbP-3lErEbg']"));
        driver.switchTo().frame(frame3);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'nice to')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("Irfan");
    }
}
