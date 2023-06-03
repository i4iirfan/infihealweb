package DisorderPathway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DepressionPathway extends BaseClassDisorder {
    @Test
    public void chatbotInteraction() {
        input("Irfan");
        send();
        waitForVisibility(By.xpath(".//span[text()='Yes']"));
        button(By.xpath("(.//button[@aria-keyshortcuts='Alt + Shift + A'])[1]"));
        waitForVisibility(By.xpath(".//p[contains(text(),'health practitioner')]"));
        button(By.xpath("(.//button[@aria-keyshortcuts='Alt + Shift + A'])[1]"));
        waitForVisibility(By.xpath(".//button[@title=\"Depression\"]"));
        button(By.xpath(".//button[@title=\"Depression\"]"));
        waitForVisibility(By.xpath(".//p[contains(text(),'physical health conditions you are')]"));
        button(By.xpath(".//button[@title=\"Hypertension\"]"));
        waitForVisibility(By.xpath(".//p[contains(text(),'loss of loved one')]"));
        //Wait for the response
        WebElement chatResponse =driver.findElement(By.xpath("(.//div[@class='webchat__bubble__content'])[17]"));
        //Assert the expected response from the chatbot
        String expectedResponse = "So, before we move forward, I would like to know, when did you first see the symptoms? What were the symptoms like? And what was going in your life around that time? Were you going through any significant changes (Eg: Job change, loss of loved one, illness, new diet, shifting places etc.)";
        String actualResponse = chatResponse.getText();
        Assert.assertEquals(actualResponse, expectedResponse);
        input("Ya i felt symptoms during my job change and i felt ill");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'numb and disconnected')]"));
        input("ya it has fared me a lot and feel exhausted and not living the life the way I want");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'interpersonal relationships')]"));
        input("ya they have been impacting a bit as I am unable to concentrate");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'coping with everything')]"));
        input("yes i am able to do it");        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'challenging beliefs')]"));
        input("i am looking to know about myself");
        send();
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[4]"));
        yes();
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[5]"));
        input("i don't know much about it");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'volunteering')]"));
        input("i like to play cricket");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'positive mindset')]"));
        input("no i dont struggle infact i love myself");
        send();
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[6]"));
        male();
        //button(By.xpath(".//button[@title='male']"));
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[7]"));
        button(By.xpath("(.//button[@title='Continue with the Healo Bot'])"));
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[8]"));
        button(By.xpath("(.//button[@class='ac-pushButton style-default ac-selectable'])[33]"));
        waitForVisibility(By.xpath("(.//div[@class='ac-container'])[9]"));
        button(By.xpath(".//button[@title='The issue itself']"));
        waitForVisibility(By.xpath(".//p[contains(text(),'considered individually')]"));
        input("i don't know much about it");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'those people')]"));
        input("yes somewhat like");
        send();
        waitForVisibility(By.xpath(".//p[contains(text(),'grounded and centered')]"));
        button(By.xpath(".//button[@title='Yes']"));
        waitForVisibility(By.xpath(".//p[contains(text(),'begin by')]"));
        button(By.xpath(".//button[@title='No Diagnosis but I have doubts']"));
        waitForVisibility(By.xpath(".//p[contains(text(),'Dysthymia')]"));
        button(By.xpath(".//button[@title='Major Depression (characterized by persistently depressed mood or loss of interest in activities, causing significant impairment in daily life)']"));


    }
}