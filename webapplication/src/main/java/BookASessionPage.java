import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import generics.map;

import generics.propertyFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class BookASessionPage extends map {

    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;
    @FindBy(xpath = ".//button[contains(text(),' Book A Session ')]")
    WebElement bookASessionButton;
    @FindBy(xpath = ".//input[@data-placeholder='Enter Your Name']")
    WebElement enterNameField;
    @FindBy(id = "mat-input-1")
    WebElement enterEmailField;
    @FindBy(xpath = ".//div[@class='mat-select-arrow-wrapper ng-tns-c53-36']")
    WebElement dropDownButton;
    @FindBy(xpath = ".//span[contains(text(),'India (+91)')]")
    WebElement selectOptionButton;
    @FindBy(xpath = ".//input[@data-placeholder='Enter Your Phone Number']")
    WebElement phoneNumberField;
    @FindBy(xpath = ".//button[@type='submit']")
    WebElement submitButton;


    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(propertyFile.getData("weburl"));

        PageFactory.initElements(driver, this);
        map.addDataIntoMap("bookasession");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("bookasession-extent-report.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

    }
    public String captureScreenshot() {
        String screenshotDirectory = "F:\\chatbotframework\\webapplication\\src\\screenshots\\";

        try {
            File directory = new File(screenshotDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
            String screenshotPath = screenshotDirectory + System.currentTimeMillis() + ".png";
            File destinationFile = new File(screenshotPath);
            Files.move(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            return screenshotPath;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    // Method to log a screenshot in the report
    public void logScreenshot(String screenshotPath, String stepName) {
        try {
            test.log(Status.INFO, stepName, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bookSession() {
        bookASessionButton.click();
        Reporter.log("Clicked on Book A Session");

    }
    public void fillName() {
        enterNameField.sendKeys(map.getDataFromMap("name"));
        Reporter.log("Name Entered");

    }
    public void enterEmail() {
        enterEmailField.sendKeys(map.getDataFromMap("email"));
        Reporter.log("Email Entered");

    }
    public void selectDropdown() {
        Actions a = new Actions(driver);
        a.moveToElement(dropDownButton).click().build().perform();
        selectOptionButton.click();
        Reporter.log("Country Selected");

    }
    public void enterNumber(){
        phoneNumberField.sendKeys(getDataFromMap("number"));
        Reporter.log("Phone Number Entered");

    }
    public void submit(){
        submitButton.submit();
        Reporter.log("Clicked On Submit Button");
    }

    public void fillOutBookSessionTest(){
        bookSession();
        fillName();
        enterEmail();
        enterNumber();
        submit();
    }
    @AfterClass
    public void closeBrowser() {
        driver.quit();
        extent.flush();

    }
}




