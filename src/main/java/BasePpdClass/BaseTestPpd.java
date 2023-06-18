package BasePpdClass;

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

public class BaseTestPpd extends map {
    public WebDriver driver;
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
    @FindBy(xpath = ".//button[@title='Trauma / Post-traumatic stress disorder (PTSD)']")
    public WebElement traumabutton;
    @FindBy(xpath = ".//button[@title='Yes']")
    public WebElement yesbutton;
    @FindBy(xpath = ".//button[@title='Strongly Agree']")
    public WebElement stronglyagreebutton;
    @FindBy(xpath = ".//button[@title='New perspective']")
    public WebElement newperpectivebutton;
    @FindBy(xpath = ".//button[@title='COME BACK LATER']")
    public WebElement comebacklaterbutton;


    @BeforeClass
    public void setUp() {
        // Launch Firefox browser
        driver = new FirefoxDriver();
        //maximize the browser
        driver.manage().window().maximize();
        //chatbot URL
        //driver.get("https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs");
        //driver.get(propertyFile.getData("appurl"));
        driver.get(propertyFile.getData("directurl"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //switchToChatFrame();
        //comment this if using the above method
        waitingFor(".//p[contains(text(),'nice to')]");
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
    protected void send() {
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
        //driver.findElement(By.xpath(".//button[@title='Yes']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement yesbuttonMain = wait.until(ExpectedConditions.elementToBeClickable(yesbutton));
        yesbuttonMain.click();

        //yesbutton.click();
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
        //driver.get("https://sites.google.com/view/infiheal-bot/home?pli=1");
        driver.get(propertyFile.getData("directurl"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        // Code for switching to chat frame
            /*WebElement frameText = driver.findElement(By.id("4125111757051f9_0"));
            driver.switchTo().frame(frameText);
            driver.switchTo().frame(0);
            WebElement frame2 = driver.findElement(By.id("userHtmlFrame"));
            driver.switchTo().frame(frame2);
            WebElement frame3 = driver.findElement(By.xpath(".//iframe[@src='https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs']"));
            driver.switchTo().frame(frame3);*/
        waitingFor(".//p[contains(text(),'exercise we did')]");
    }

    protected void feedbackPathway() {
        waitUntil("session was helpful");
        stronglyagree();
        waitUntil("worked for you");
        newperspective();
        waitUntil("tackle these");
        comebacklater();
        waitUntil("overwhelming but you");
    }

    protected void stronglyagree() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement stronglyagreeelement = wait.until(ExpectedConditions.elementToBeClickable(stronglyagreebutton));
        stronglyagreeelement.click();
    }

    protected void newperspective() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement newperspectiveelement = wait.until(ExpectedConditions.elementToBeClickable(newperpectivebutton));
        newperspectiveelement.click();

    }

    protected void comebacklater() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement comebacklaterelement = wait.until(ExpectedConditions.elementToBeClickable(comebacklaterbutton));
        comebacklaterelement.click();
    }

    protected void yesText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement yesTextElement = wait.until(ExpectedConditions.elementToBeClickable(yesWithText));
        yesTextElement.click();
    }

    protected void notbeingabletotrustandconfideinpeople() {
        //s1
        button(".//button[@title='Not being able to trust and confide in people']");
    }

    protected void notbeingabletomakefriends() {
        //s1
        button(".//button[@title='Not being able to make friends']");
    }

    protected void notbeingabletoforgivepeopleafterconflicts() {
        //s1
        button(".//button[@title='Not being able to forgive people after conflicts']");
    }

    protected void noneofthese() {
        //s1
        button(".//button[@title='None of these']");
    }

    protected void BPD() {
        //s1
        button(".//button[@title='BPD']");
    }

    protected void narcissisticpersonalitydisorder() {
        //s1
        button(".//button[@title='Narcissistic Personality Disorder']");
    }

    protected void antisocialpersonalitydisorder() {
        //s1
        button(".//button[@title='Antisocial Personality Disorder']");
    }

    protected void substanceabuseproblems() {
        //s1
        button(".//button[@title='Substance abuse problems']");
    }

    protected void panicdisorder() {
        //s1
        button(".//button[@title='Panic disorder']");
    }

    protected void OCD() {
        //s1
        button(".//button[@title='OCD']");
    }

    protected void Anxiety() {
        //s1
        button(".//button[@title='Anxiety']");
    }


    protected void keepadiary() {
        //s1
        button(".//button[@title='Keep a diary']");
    }

    protected void questionandchallengeyourparanoidthoughts() {
        //s1
        button(".//button[@title='Question and challenge your paranoid thoughts']");
    }

    protected void doasmallthoughtexperimenteveryday() {
        //s1
        button(".//button[@title='Do a small thought experiment every day']");
    }

    protected void overprotectivenessandlowparental() {
        button(".//button[@title='Over-protectiveness and low parental care or affectionless control']");
    }

    protected void parentspreventingindependentbehaviour() {
        button(".//button[@title='Parents preventing independent behaviour']");
    }

    protected void parentsbeingemotionallycold() {
        button(".//button[@title='Parents being emotionally cold, neglectful, and indifferent']");
    }

    protected void parentswereparanoidthemselves() {
        button(".//button[@title='Parents were paranoid themselves']");
    }

    protected void yourparentswerestrictandintolerant() {
        button(".//button[@title='Your parents were strict and intolerant about certain things and tried to shame you']");
    }

    protected void physicalemotionalandsexualabuse() {
        button(".//button[@title='Physical, emotional, and sexual abuse']");
    }

    protected void parentsweredealingwiththeirmentalissues() {
        button(".//button[@title='Parents were dealing with their mental health issues']");
    }

    protected void arguments() {
        button(".//button[@title='Arguments']");
    }

    protected void verbalstress() {
        button(".//button[@title='Verbal Stress']");
    }

    protected void emotionalstress() {
        button(".//button[@title='Emotional Stress']");
    }

    protected void chaosinthehome() {
        button(".//button[@title='Chaos in the home environment']");
    }

    protected void alcoholism() {
        button(".//button[@title='Alcoholism']");
    }

    protected void drugaddiction() {
        button(".//button[@title='Drug Addiction']");
    }

    protected void guilt() {
        button(".//button[@title='Guilt']");
    }

    protected void shame() {
        button(".//button[@title='Shame']");
    }

    protected void physicalabuse() {
        button(".//button[@title='Physical Abuse']");
    }

    protected void poorhealth() {
        button(".//button[@title='Poor Health']");
    }

    protected void neglect() {
        button(".//button[@title='Neglect']");
    }

    protected void fearorbeingavoidant() {
        button(".//button[@title='Fear or being avoidant to commitments (social, personal, academic, occupational)']");
    }

    protected void feelingsofinsecurity() {
        button(".//button[@title='Feelings of insecurity, lacking in everyday interactions']");
    }

    protected void feelingsthatfriendsfamily() {
        button(".//button[@title='Feelings that friends, family, colleagues or partners will leave you hanging or vulnerable at a crucial moment']");
    }

    protected void predispositionordiscrimination() {
        button(".//button[@title='Predisposition or discrimination against people that seem “untrustworthy.”']");
    }

    protected void fearofexploringnewactivities() {
        button(".//button[@title='Fear of exploring new activities, friendships, business opportunities Positive feedback is always handled with scepticism']");
    }

    protected void afraidoftakingrisks() {
        button(".//button[@title='Afraid of taking risks, however big or small']");
    }

    protected void feelinguiltywhenapersontrust() {
        button(".//button[@title='Feeling guilty when a person trusts you and put a lot of effort to not let them down']");
    }

    protected void yesicannotseemtoremember() {
        button(".//button[@title='Yes, i cannot seem to remember but i have a feeling that something like this happened.']");

    }

    protected void noirememberandtherewasnobetrayal() {
        button(".//button[@title='No, I remember and there was no betrayal like this in my life']");
    }

    protected void acknowledgeinsteadofavoiding() {
        button(".//button[@title='Acknowledge instead of avoiding']");
    }


    protected void yesexactly() {
        button(".//button[@title='Yes, exactly.']");
    }

    protected void iknowaboutthisbutiwouldliketolearnmore() {
        button(".//button[@title='I know about this but i would like to learn more.']");
    }

    protected void practisepositivevisualisation() {
        button(".//button[@title='Practise positive visualisation']");
    }


    protected void moreconcernedaboutachievement() {
        button(".//button[@title='Your worries or fantasies are more concerned about achievement, grace, and self- image.']");
    }

    protected void moreconcernedaboutothershurtingyou() {
        button(".//button[@title='Your worries or fantasies are more concerned about others hurting you or be at the receiving end of others hate and aggression.']");
    }

    protected void moreconcernedaboutyourfreedom() {
        button(".//button[@title='Your worries or fantasies are more concerned about your freedom and control.']");
    }

    protected void moreconcernedaboutotherscheating() {
        button(".//button[@title='Your worries or fantasies are more concerned about others cheating on you or jealousy.']");
    }

    protected void moreconcernedaboutrejectingyou() {
        button(".//button[@title='Your worries or fantasies are more concerned about rejecting you and you fear others judgement of you.']");
    }

    protected void yessure() {
        button(".//button[@title='Yes, sure.']");
    }

    protected void nomaybelater() {
        button(".//button[@title='No, maybe later.']");
    }

    protected void coldandrational() {
        button(".//button[@title='Cold and rational']");
    }

    protected void yesihave() {
        button(".//button[@title='Yes, I have']");
    }


    protected void others() {
        //s1
        button(".//button[@title='Others']");
    }


    protected void yeahiamin() {
        //s1
        button(".//button[@title='Yeah, I’m in!']");
    }

    protected void wellnocantbeaoption() {
        //s1
        button(".//button[@title='Well, no can’t be an option here I guess..']");
    }


    protected void Depression() {
        //s1
        button(".//button[@title='Depression ']");
    }

    protected void NO() {
        //s1
        button(".//button[@title='NO']");
    }

    protected void ienjoyeddoingthem() {
        //s2
        button(".//button[@title='I enjoyed doing them.']");
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

    protected void continueWithHealoBot() {
        //main flow
        button("(.//button[@title='Continue with the Healo Bot'])");
    }

    protected void goInDepth() {
        //main flow
        button(".//button[@title='Go in depth and explore what might be bothering and get insights, recommendations on getting better.']");
    }

    protected void theIssueItself() {
        //main flow
        button(".//button[@title='The issue itself']");
    }

    public void waitUntil(String expectedText) {
        //use this method only if waiting with P tag
        By textLocator = By.xpath(".//p[contains(text(), '" + expectedText + "')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
    }


}










