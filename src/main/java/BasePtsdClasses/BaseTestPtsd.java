package BasePtsdClasses;

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

public class BaseTestPtsd extends map {
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
    @FindBy(xpath = ".//button[@title='Trauma / Post-traumatic stress disorder (PTSD)']")
    public WebElement traumabutton;

    @BeforeClass
    public void setUp() {
        // Launch Firefox browser
        driver = new FirefoxDriver();
        //maximize the browser
        driver.manage().window().maximize();
        //chatbot URL
        driver.get("https://webchat.botframework.com/embed/infiheal-bot?s=QSZpX6nE3ZM.DQL1TyfS2yvmkszgoL2grYHZzVrGCMKb0DFGCQbtTPs");
        //driver.get(propertyFile.getData("appurl"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //switchToChatFrame();
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

    protected void trauma() {
        //main flow button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement traumabuttonelement = wait.until(ExpectedConditions.elementToBeClickable(traumabutton));
        traumabuttonelement.click();
    }

    protected void ithinkithasbeenfrompeoplearoundme() {
        //s1
        button(".//button[@title='I think it has been from people around me…']");
    }

    protected void ithinkthiswasfromthiseventthatoccurred() {
        //s1
        button(".//button[@title='I think it was from this event/events that occurred in the past']");
    }

    protected void ithasbeenfrommultiplethingsinlife() {
        //s1
        button(".//button[@title='It has just been from multiple things in life, both people and events']");
    }

    protected void idontknowtheorigin() {
        //s1
        button(".//button[@title='I don’t know the origin/ I don’t really know what happened to me can be called trauma..']");
    }

    protected void thinktraumacomesfrom() {
        //change string value and the button will be clicked and perform testing with it
        String expectedButton = "I think it has been from people around me…";
        //String expectedButton ="I think it was from this event/events that occurred in the past";
        //String expectedButton = "It has just been from multiple things in life, both people and events";
        //String expectedButton = "I don’t know the origin/ I don’t really know what happened to me can be called trauma..";
        if (expectedButton.equals("I think it has been from people around me…")) {
            ithinkithasbeenfrompeoplearoundme();
            waitUntil("most in life? it can be multiple");
            response("input11");
            waitUntil("Right now, what do you feel towards this person or people?");
            response("input12");

        } else if (expectedButton.equals("I think it was from this event/events that occurred in the past")) {
            ithinkthiswasfromthiseventthatoccurred();
            waitUntil("I see. Can I ask what event(s) you think impacted you the most in your life?");
            response("input13");
            waitUntil("Right now, what emotions do you feel when you remember such event(s)? It can also be something that you are going through.");
            response("input14");

        } else if (expectedButton.equals("It has just been from multiple things in life, both people and events")) {
            ithasbeenfrommultiplethingsinlife();
            waitUntil("I see. Do you feel like you can tell me  about these situations you went through in your life, or are going through?");
            response("input15");
            waitUntil("Right now, what emotions do you feel when you think about the things that happened in your life?");
            response("input16");

        } else if (expectedButton.equals("I don’t know the origin/ I don’t really know what happened to me can be called trauma..")) {
            idontknowtheorigin();
            waitUntil("just share your feelings with me!");
            response("input17");

        } else {
            System.out.println("Invalid Option");
        }
    }

    //=====================s1
    protected void Feelingadisconnectbetweenyourselfandtheworldaroundyou() {
        //s1
        button(".//button[@title='Feeling a disconnect between yourself and the world around you ( excessive daydreaming, that feeling of looking at you life as if you are a third person)']");
    }

    protected void actingonimpulse() {
        //s1
        button(".//button[@title='acting on impulse ( risk-taking behaviour, hasty decision making)']");
    }

    protected void Difficultyconcentratingontasks() {
        //s1
        button(".//button[@title='Difficulty concentrating on tasks ( trying to manage work or studies but getting distracted or time keeps slipping from hands)']");
    }

    protected void Difficultyregulatingemotions() {
        //s1
        button(".//button[@title='Difficulty regulating emotions ( feeling either numb or feeling too much)']");
    }

    protected void selfsabotagingbehaviours() {
        //s1
        button(".//button[@title='self sabotaging behaviours ( punishing yourself when it is not your fault, ending things even before it has happened because you might think it wont end well anyway)']");
    }

    protected void peoplepleasingbehaviours() {
        //s1
        button(".//button[@title='people pleasing behaviours ( putting others needs first even if it drains you, agreeing with people because you want them to not dislike you)']");
    }

    protected void Hypervigilantofotherpeopleandsituations() {
        //s1
        button(".//button[@title='Hypervigilant of other people and situations (ever think obsessively about the things that someone has said, or the tone they used?)']");
    }

    protected void substanceabuse() {
        //s1
        button(".//button[@title='substance abuse ( using alcohol or drugs to numb intense feelings or distress)']");
    }

    protected void Overexplainingthingsevenifyouwerenotatfault() {
        //s1
        button(".//button[@title='Overexplaining things even if you were not at fault, or made the slightest of mistakes.']");
    }

    protected void Youfeellikeyouhavetotakecareofallthepeoplethatneedyourhelp() {
        //s1
        button(".//button[@title='You feel like you have to take care of all the people that need your help']");
    }

    protected void Youneglectyourself() {
        //s1
        button(".//button[@title='You neglect yourself - (be it physically or mentally)']");
    }

    protected void Extremeindependence() {
        //s1
        button(".//button[@title='Extreme independence (You can’t trust and rely on other people easily, so you feel you have to solve all your problems alone.)']");
    }

    protected void Victimizingyourself() {
        //s1
        button(".//button[@title='Victimizing yourself ( no matter what I do I will never be able to progress)']");
    }

    protected void Avoidinganykindofconflict() {
        //s1
        button(".//button[@title='Avoiding any kind of conflict, or the reverse- getting in conflicts purposefully']");
    }

    protected void others() {
        //s1
        button(".//button[@title='Others']");
    }

    protected void hastydecisions() {
        String expectedButton = "Feeling a disconnect between yourself and the world around you";
        //String expectedButton = "acting on impulse";
        //String expectedButton = "Difficulty regulating emotions";
        //String expectedButton = "Difficulty concentrating on tasks";
        //String expectedButton = "self sabotaging behaviours";
        //String expectedButton = "people pleasing behaviours";
        //String expectedButton = "Hypervigilant of other people and situations";
        //String expectedButton = "substance abuse";
        //String expectedButton = "Overexplaining things even if you were not at fault, or made the slightest of mistakes.";
        //String expectedButton = "You feel like you have to take care of all the people that need your help";
        //String expectedButton = "You neglect yourself";
        //String expectedButton = "Extreme independence";
        //String expectedButton = "Victimizing yourself";
        //String expectedButton = "Avoiding any kind of conflict";
        //String expectedButton = "Others";
        if (expectedButton.equals("Feeling a disconnect between yourself and the world around you")) {
            Feelingadisconnectbetweenyourselfandtheworldaroundyou();

        } else if (expectedButton.equals("acting on impulse")) {
            actingonimpulse();

        } else if (expectedButton.equals("Difficulty concentrating on tasks")) {
            Difficultyconcentratingontasks();

        } else if (expectedButton.equals("Difficulty regulating emotions")) {
            Difficultyregulatingemotions();

        } else if (expectedButton.equals("self sabotaging behaviours")) {
            selfsabotagingbehaviours();

        } else if (expectedButton.equals("people pleasing behaviours")) {
            peoplepleasingbehaviours();

        } else if (expectedButton.equals("Hypervigilant of other people and situations")) {
            Hypervigilantofotherpeopleandsituations();

        } else if (expectedButton.equals("substance abuse")) {
            substanceabuse();

        } else if (expectedButton.equals("Overexplaining things even if you were not at fault, or made the slightest of mistakes.")) {
            Overexplainingthingsevenifyouwerenotatfault();

        } else if (expectedButton.equals("You feel like you have to take care of all the people that need your help")) {
            Youfeellikeyouhavetotakecareofallthepeoplethatneedyourhelp();

        } else if (expectedButton.equals("You neglect yourself")) {
            Youneglectyourself();

        } else if (expectedButton.equals("Extreme independence")) {
            Extremeindependence();

        } else if (expectedButton.equals("Victimizing yourself")) {
            Victimizingyourself();

        } else if (expectedButton.equals("Avoiding any kind of conflict")) {
            Avoidinganykindofconflict();

        } else if (expectedButton.equals("Others")) {
            others();

        } else {
            System.out.println("Invalid Option");
        }
    }

    protected void yeahiamin() {
        //s1
        button(".//button[@title='Yeah, I’m in!']");
    }

    protected void wellnocantbeaoption() {
        //s1
        button(".//button[@title='Well, no can’t be an option here I guess..']");
    }

    protected void notsonormal() {
        //s1
        String expectedButton = "Yeah, I’m in!";
        //String expectedButton = "Well, no can’t be an option here I guess..";
        if (expectedButton.equals("Yeah, I’m in!")) {
            yeahiamin();
        } else if (expectedButton.equals("Well, no can’t be an option here I guess..")) {
            wellnocantbeaoption();
        } else {
            System.out.println("Invalid option");
        }
    }

























































    protected void unabletostayfocused() {
        //s1
        button(".//button[@title='Unable to stay alert/focused']");
    }

    protected void feelingnervousorrestless() {
        //s1
        button(".//button[@title='Feeling nervous, restless or tense']");
    }

    protected void yesihavediagnosis() {
        //s1
        button(".//button[@title='Yes, I have a diagnosis']");
    }

    protected void generalisedanxietydisorder() {
        //s1
        button(".//button[@title='Generalised anxiety disorder (GAD)']");
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

    protected void fearofbeingalone() {
        //s2
        button(".//button[@title='Fear of being alone or Isolated']");
    }

    protected void onlythatparticularride() {
        //s5
        button(".//button[@title='Only that particular ride or park ']");
    }

    protected void iamscaredofanysituationplace() {
        //s5
        button(".//button[@title='I am scared of any situation/place from which I can’t escape in case anything bad happens like closed spaces, places with many people, standing in lines, public transport, open spaces or outside of home alone']");
    }

    protected void Continue() {
        //s5
        button(".//button[@title='Continue']");
    }

    protected void youfeelemotionlikeguiltshame() {
        //s6
        button(".//button[@title='You feel like your family members or partner are tolerating you and as a result tend to have conflicts.']");
    }

    protected void yesiwouldliketoexplorethat() {
        //s7
        button(".//button[@title='Yes, I would like to explore that. ']");
    }

    protected void openness() {
        //s7
        button(".//button[@title='Openness: I fear change and new experiences. ']");
    }

    protected void noletscontinue() {
        //s7
        button(".//button[@title='NO, let's continue']");
    }

    protected void Myself() {
        //s7
        button(".//button[@title='Myself ']");
    }

    protected void caffeine() {
        //s7
        button(".//button[@title='Caffeine']");
    }

    protected void accessresourcestohelpyoufurther() {
        //s7
        button(".//button[@title='Access resources to help you further')]");
    }

    protected void yescountmein() {
        //s9
        button(".//button[@title='Yes, count me in.']");
    }

    protected void irritablebowelsyndrome() {
        //medical perspective
        button(".//button[@title='Irritable Bowel Syndrome ']");
    }

    protected void recurrentabdominalpain() {
        //medical perspective
        button(".//button[@title='Recurrent abdominal pain / discomfort']");
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
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textLocator));
    }

    protected void noNotReally() {
        //s5
        button(".//span[contains(text(),'No, not really.')]");
    }

    protected void mayBeIDK() {
        //s5
        button(".//span[contains(text(),'Maybe, IDK')]");
    }

    protected void myself() {
        //s5
        button(".//span[contains(text(),'Myself')]");
    }

    protected void noItsNotMyCupOfTea() {
        //s6
        button(".//span[contains(text(),'It’s not my cup of tea')]");
    }

    protected void ireallyenjoydoingthem() {
        //for all
        //button(".//button[@title='I really enjoyed doing them']");
        button(".//span[contains(text(),'I really enjoyed doing them')]");
    }

    protected void yesallthetime() {
        //s2
        button(".//span[contains(text(),'Yes! All the time ')]");
    }

    protected void yesOfCourse() {
        //s2
        button(".//span[contains(text(),'Yes ofcourse')]");
    }

    protected void yaiseemtogetit() {
        //s2
        button(".//span[contains(text(),'Yeah, I seem to get it')]");
    }

    protected void yesyougotitright() {
        //s7
        button(".//span[contains(text(),'Yes, you got it right')]");
    }
}








