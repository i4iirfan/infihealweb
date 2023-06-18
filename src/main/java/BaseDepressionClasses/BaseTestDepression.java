package BaseDepressionClasses;

import generics.map;
import generics.propertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTestDepression extends map {
        WebDriver driver;
        WebElement input;
        WebElement buttonToBeClicked;
        @FindBy(xpath = "(.//button[@type='button'])[5]")
        public WebElement buttonElement;
        @FindBy(xpath = ".//span[contains(text(),'Yes')]")
        public WebElement yesWithText;
        @FindBy(xpath = ".//span[contains(text(),'Umm, yeah')]")
        public WebElement ummyeah;
        @FindBy(xpath = "(.//button[@type='button'])[2]")
        public WebElement firstoption;

        @BeforeClass
        public void setUp() {
            // Launch Firefox browser
            driver = new FirefoxDriver();
            //maximize the browser
            driver.manage().window().maximize();
            //chatbot URL
            //driver.get("https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs");
            driver.get(propertyFile.getData("appurl"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            switchToChatFrame();
            // Locating the chat input field
            input = driver.findElement(By.xpath(".//input[@placeholder='Type your message']"));
            // Initialize elements using PageFactory
            PageFactory.initElements(driver, this);
        }
        /* @AfterClass
         public void closeBrowser() {
             // Close the browser
             driver.quit();
         }*/
        protected void send(){
            driver.findElement(By.xpath(".//button[@title='Send')]")).click();
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
            waitingFor(".//p[contains(text(),'nice to')]");
        }
        protected void waitingFor(String xpathExpression) {
            By locator = By.xpath(xpathExpression);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        protected void button(String xpathExpression) {
            buttonToBeClicked = driver.findElement(By.xpath(xpathExpression));
            buttonToBeClicked.click();
        }
        protected void response(String message) {
            //enter text field and type message
            WebElement text = driver.findElement(By.xpath(".//input[@placeholder='Type your message']"));
            text.sendKeys(map.getDataFromMap(message));
            //click on send button
            driver.findElement(By.xpath(".//button[@Title='Send']")).click();
        }
        protected void yes() {
            //Yes Button
            driver.findElement(By.xpath(".//button[@title='Yes']")).click();
        }

        protected void no() {
            //no button
            driver.findElement(By.xpath(".//button[@title='No']")).click();
        }
        protected void male() {
            //Male button
            driver.findElement(By.xpath(".//button[@title='male']")).click();
        }
        protected void firstOption() {
            //whenever there are two options to select with this method can select first option
            //driver.findElement(By.xpath("(.//button[@type='button'])[2]")).click();
            //if method doesn't work use this xpath with button method
            //button("(.//button[@type='button'])[2]");
            firstoption.click();
        }
        protected void switchSession() {
            //whenever need to switch session use this method
            driver.get("https://sites.google.com/view/infiheal-bot/home?pli=1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Code for switching to chat frame
            WebElement frameText = driver.findElement(By.id("4125111757051f9_0"));
            driver.switchTo().frame(frameText);
            driver.switchTo().frame(0);
            WebElement frame2 = driver.findElement(By.id("userHtmlFrame"));
            driver.switchTo().frame(frame2);
            WebElement frame3 = driver.findElement(By.xpath(".//iframe[@src='https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs']"));
            driver.switchTo().frame(frame3);
            waitingFor(".//p[contains(text(),'exercise we did')]");
        }
        protected void feedbackPathway() {
            waitUntil("session was helpful");
            button(".//button[@title='Strongly Agree']");
            waitUntil("worked for you");
            button(".//button[@title='New perspective']");
            waitUntil("tackle these");
            button(".//button[@title='COME BACK LATER']");
            waitUntil("overwhelming but you");
        }
        protected void yesText() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement yesTextElement = wait.until(ExpectedConditions.elementToBeClickable(yesWithText));
            yesTextElement.click();
        }
        protected void yesmaybeWithText() {
            //yes may be button
            button(".//span[contains(text(),'Yes, Maybe')]");
        }
        protected void yeahWithText() {
            //Yeah button with text
            button(".//span[contains(text(),'Yeah')]");
        }
        protected void depression() {
            //depression option
            button(".//button[@title=\"Depression\"]");
        }
        protected void hypertension() {
            //hypertension option button
            button(".//button[@title=\"Hypertension\"]");
        }
        protected void continueWithHealoBot(){
            //main flow
            button("(.//button[@title='Continue with the Healo Bot'])");
        }
        protected void goInDepth(){
            //main flow
            button(".//button[@title='Go in depth and explore what might be bothering and get insights, recommendations on getting better.']");
        }
        protected void theIssueItself(){
            //main flow
            button(".//button[@title='The issue itself']");
        }
        public void waitUntil(String expectedText) {
            //use this method only if waiting with P tag
            By textLocator = By.xpath(".//p[contains(text(), '" + expectedText + "')]");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
        }
        protected void yeahTotally() {
            button(".//span[contains(text(),'Yeah totally!')]");
        }
        protected void ummYeah() {
            ummyeah.click();
        }
        protected void highAnxiety() {
            //s1
            button(".//button[@title='High levels of anxiety (can be experienced as an internalised ‘anxious worrying’ style or as a more externalised ‘irritability’) ']");
        }
        protected void majorDepression() {
            //s1
            button(".//button[@title='Major Depression (characterized by persistently depressed mood or loss of interest in activities, causing significant impairment in daily life)']");
        }
        protected void noDiagnosis() {
            //s1
            button(".//button[@title='No Diagnosis but I have doubts']");
        }
        protected void borderlineDisorder() {
            //s1
            button(".//button[@title='Borderline Disorder ']");
        }
        protected void yeahAllTheTime() {
            //s1
            button(".//button[@title='Yeah! ALL THE TIME!']");
        }
        protected void yeahThatSoundsLikeMe() {
            //s1
            button(".//button[@title='Yeah, that sounds like me ']");
        }
        protected void yesAbsolutely(){
            //s1
            button(".//button[@title='Yes! Absolutely']");
        }
        protected void yesMostOfTheTime(){
            //s1
            button(".//button[@title='Yes! Most of the time']");
        }
        protected void yesItsBabyBlues(){
            //s3
            button(".//span[contains(text(),'Yes, its baby blues')]");
        }
        protected void iIsolateMyself(){
            //s4
            button(".//button[@title='I isolate myself']");
        }
        protected void yeahNotSure(){
            //s4
            button(".//span[contains(text(),'Yeah, Not sure')]");
        }
        protected void mayBeSomeTimes(){
            //s4
            button(".//span[contains(text(),'Maybe Sometimes')]");
        }
        protected void youAreLikelyToTakeThingsPersonally(){
            //s4
            button(".//span[contains(text(),'You are likely to take things')]");
        }
        protected void noNotReally(){
            //s5
            button(".//span[contains(text(),'No, not really.')]");
        }
        protected void mayBeIDK(){
            //s5
            button(".//span[contains(text(),'Maybe, IDK')]");
        }
        protected void myself(){
            //s5
            button(".//span[contains(text(),'Myself')]");

        }
        protected void noItsNotMyCupOfTea(){
            //s6
            button(".//span[contains(text(),'It’s not my cup of tea')]");
        }
        protected void ireallyenjoydoingthem(){
            //for all
            //button(".//button[@title='I really enjoyed doing them']");
            button(".//span[contains(text(),'I really enjoyed doing them')]");
        }
        protected void yesallthetime(){
            //s2
            button(".//span[contains(text(),'Yes! All the time ')]");
        }
        protected void yesOfCourse(){
            //s2
            button(".//span[contains(text(),'Yes ofcourse')]");
        }
        protected void yesmostoftheTimes(){
            //s2
            button(".//span[contains(text(),'Yes, most of the times!')]");
        }
        protected void idkenlightenme(){
            //s2
            button(".//span[contains(text(),'IDK, enlighten me!')]");
        }
        protected void yaiseemtogetit(){
            //s2
            button(".//span[contains(text(),'Yeah, I seem to get it')]");
        }
        protected void yesyougotitright(){
            //s7
            button(".//span[contains(text(),'Yes, you got it right')]");
        }
        protected void accessresourcestohelpyoufurther(){
            //s8
            button(".//span[contains(text(),'Access resources to help you further')]");
        }

    }








