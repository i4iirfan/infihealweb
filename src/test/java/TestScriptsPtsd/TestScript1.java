package TestScriptsPtsd;

import BasePtsdClasses.BaseTestPtsd;
import generics.map;
import org.testng.annotations.Test;

public class TestScript1 extends BaseTestPtsd {
    @Test
    public void chatBotInteraction() {
        map.addDataIntoMap("credentials");
        response("name");
        waitingFor(".//span[text()='Yes']");
        yesText();
        waitUntil("health practitioner");
        yeahWithText();
        waitingFor(".//button[@title=\"Depression\"]");
        trauma();
        System.out.println("PTSD Option Selected");
        waitUntil("physical health conditions you are");
        hypertension();
        waitUntil("loss of loved one");
        map.addDataIntoMap("ptsdpathway");
        response("input1");
        waitUntil("values, priorities");
        response("input2");
        waitUntil("interpersonal relationships");
        response("input3");
        waitUntil("your social support");
        response("input4");
        waitUntil("challenging beliefs");
        response("input5");
        waitUntil("Was this helpful?");
        yes();
        waitUntil("When you thought the bot will make you feel relaxed but instead starts asking uncomfortable questions");
        response("input6");
        waitUntil("volunteering");
        response("input7");
        waitUntil("positive mindset");
        response("input8");
        waitUntil("wrong pronouns");
        //female //others //transgenders
        male();
        waitUntil("So moving on, can you tell me would you like to:");
        continueWithHealoBot();
        waitUntil("like to do next?");
        goInDepth();
        waitUntil("Okay so tell me, do you want to work on:");
        theIssueItself();
        System.out.println("Main Flow ends and the issue opens");
        //session 1 starts
        System.out.println("Session 1 Starts");
        System.out.println("PTSD Pathway Starts");
        waitUntil("Who or what do you blame for your traumatic experiences the most?");
        response("input9");
        waitUntil("cannot be considered individually");
        response("input10");
        waitUntil("or some event(s)");
        //choose options from base ==========================================================================TC
        thinktraumacomesfrom();//method in base change options
        waitUntil("I hear you. Would you like to talk more about it?");
        //TC
        String expectedResult = "Yes";
        //String expectedResult = "No";
        if (expectedResult.equals("Yes")) {
            yes();
            waitUntil("Would you share more about it?");
            response("input18");
        } else if (expectedResult.equals("No")) {
            no();
        } else {
            System.out.println("Invalid");
        }

        waitUntil("hasty decision making");
        //TC - change options from the base
        hastydecisions();
        waitUntil("have helped you in your life");
        response("input19");
        waitUntil("detrimental to you in your present life");
        response("input20");
        waitUntil("not-so-normal");
        //TC - change options from the base and run
        notsonormal();
        waitUntil("how it has affected you mentally and physically");
        response("input21");
        waitUntil("See anything similar in these stories?");
        response("input22");
        waitUntil("how are you really dealing with it now");
        response("input23");

        //work pending
        /*String expectedResponse = "input24";
        if (expectedResponse.equals("input24")){
            response("input24");
        }*/



















    }
}

