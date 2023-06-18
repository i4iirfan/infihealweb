package bookASession;

import generics.map;
import generics.propertyFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class bookASession extends map {
    WebDriver driver;
    @FindBy(xpath = ".//button[contains(text(),' Book A Session ')]")
    WebElement bookASessionButton;
    @FindBy(xpath = ".//input[@data-placeholder='Enter Your Name']")
    WebElement enterNameField;


    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(propertyFile.getData("weburl"));

        PageFactory.initElements(driver, this);

    }
    public void bookSession(){
        bookASessionButton.click();
        System.out.println("Clicked on Book A Session");
    }
    public void fillName(){
        map.addDataIntoMap("credentials");
        enterNameField.sendKeys(map.getDataFromMap("name"));
        System.out.println("Name Entered");
    }

  /*  @AfterClass
    public void closeBrowser(){
        driver.close();
    }
*/

}


