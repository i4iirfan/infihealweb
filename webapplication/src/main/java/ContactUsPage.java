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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.Duration;

public class ContactUsPage extends map {
    WebDriver driver;
    ExtentReports extent;
    ExtentTest test;

    @FindBy(xpath = ".//a[contains(text(),'Contact Us ')]")
    WebElement contactUsButton;
    @FindBy(id = "name")
    WebElement nameField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "ph_num")
    WebElement numberField;
    @FindBy(xpath = ".//textarea[@formcontrolname='message']")
    WebElement messageField;
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
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("contactus-extent-report.html");
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

    public void contactUs() {
        contactUsButton.click();
        Reporter.log("Clicked on Contact Us Option");
    }

    public void userName() {
        nameField.sendKeys(getDataFromMap("name"));
        Reporter.log("Name Entered In Name Field");
    }

    public void emailField() {
        emailField.sendKeys(getDataFromMap("email"));
        Reporter.log("Email Entered in Email Field");
    }

    public void numberField() {
        numberField.sendKeys(getDataFromMap("number"));
        Reporter.log("Number Entered in Number Field");
    }

    public void messageField() {
        messageField.sendKeys(getDataFromMap("message"));
        Reporter.log("Message Entered in Message Field");
    }

    public void submitButton() {
        submitButton.submit();
        Reporter.log("Clicked on Submit Button");
    }
    public void fillOutContactForm() {
        contactUs();
        userName();
        emailField();
        numberField();
        messageField();
    }

    public void submitContactForm() {
        submitButton();
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
        extent.flush();

    }


}
