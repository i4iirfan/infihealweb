package IssuePathway;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FamilyPathway extends BaseClassIssuePathway {
    @Test
    public void pathway() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@title=\"Family\"]")));
        driver.findElement(By.xpath(".//button[@title=\"Family\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'your relationship')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("We always quarrel over topics daily");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'affecting you')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("It has been affecting me a lot");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'letting others')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("ya others let me down");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'done differently')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("ya i would have live separately");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'generally have')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("i am living alone making terrible in cooking and other stuffs");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'perceive of')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("that i am a good human being");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'describe yourself')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("i am well educated and loyal human being");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'relationship are')]")));
        driver.findElement(By.xpath(".//input[@placeholder='Type your message']")).sendKeys("i am looking for a loyal relationship");
        driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'Do you find it')]")));
        driver.findElement(By.xpath(".//div[contains(text(),'Yeah, how did you know that')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'indicate which')]")));
        driver.findElement(By.xpath(".//button[@title='male']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'would you like to')]")));
        driver.findElement(By.xpath(".//div[contains(text(),'Healo Bot')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'talk more')]")));
        driver.findElement(By.xpath(".//div[contains(text(),'might be bothering')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//p[contains(text(),'so tell me')]")));
        driver.findElement(By.xpath(".//div[contains(text(),'The issue itself')]")).click();
    }

}
