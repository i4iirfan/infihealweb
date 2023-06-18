package TestScriptsBipolar;

import BaseBipolarClasses.BaseTestBipolar;
import generics.map;
import org.testng.annotations.Test;

public class TestScript1 extends BaseTestBipolar {
    @Test
    public void chatBotInteraction() {
        map.addDataIntoMap("credentials");
        response("name");
        waitingFor(".//span[text()='Yes']");
        yesText();
        waitUntil("health practitioner");
        yeahWithText();
        waitingFor(".//button[@title=\"Depression\"]");
        bipolardisorder();
        System.out.println("Bipolar Option Selected");
        waitUntil("physical health conditions you are");
        hypertension();
        waitUntil("loss of loved one");
        map.addDataIntoMap("bipolarpathway");
        response("input1");
        waitUntil("relationship with the people around you?");
        response("input2");
        waitUntil("interpersonal relationships");
        response("input3");
        waitUntil("stability and routine");
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
        System.out.println("Bipolar Disorder Pathway Starts");
        waitUntil("Do you feel grounded and centered enough to continue?");

        //TC
        String expectedResponse1 = "Yes";
        //String expectedResponse1= "No, Not really";
        if (expectedResponse1.equals("Yes")) {
            yes();
        } else if (expectedResponse1.equals("No, Not really")) {
            nonotreally();
            waitUntil("So how do you wish to continue?");
            //bookasession();
            helplinenumbers();
        }
        waitUntil("which type of Mania have you been diagnosed with:");
        String expectedResponse2 = "Hypomania";
        //String expectedResponse2 = "Mania with psychotic symptoms";
        //String expectedResponse2 = "Mania without psychotic symptoms";
        if (expectedResponse2.equals("Hypomania")) {
            hypomania();
        } else {
            System.out.println("Invalid Option");
        }

        waitUntil("Have you ever been diagnosed with any of the following, with or without a mood disorder?");
        String expectedResponse3 = "Borderline Disorder ";
        //Schizoaffective Disorder
        //Anxiety and Related Disorders
        //Personality Disorders
        //Substance Dependence
        //Eating Disorders
        //PMDD/ Menstural Issues
        //None of the above
        option("Borderline Disorder ");
        waitUntil("This is just so that we know we are on the right path.");
        //option("Yes, please");
        NoIthinkIdliketocontinue();
        waitUntil(" Do you feel you are wired differently than others?");
        response("input9");
        waitUntil("You can give this a read if you wish to");
        option("I will comeback to this later");
        waitUntil("mind, when you are in a mania phase?");
        response("input10");
        waitUntil("Just checking in once! I hope things are not getting too much for you?");
        //option("Not really, I am good right now ");
        yeahtheyareletspause();
        waitUntil("I am here for you!");
        videosoundscool();
        //catchuplater();
        waitUntil("overly positive.");
        waitwhat();
        waitUntil("abandoned you");
        yesabsolutely();
        waitUntil("Has this happened to you?");
        maybesometimes();
        waitUntil("Have you ever tried to harm yourself in any way and  Do you often feel suicidal?");
        //yes();
        no();
        waitUntil("Am I getting this right?");
        wowhealo();
        //yeahmaybesometimes();
        feedbackPathway();
        System.out.println("Session 1 Ends");
        driver.navigate().refresh();
        System.out.println("Session 2 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input11");
        waitUntil(", perhaps an interesting person. Isn’t that right?");
        yestotally();
        //maybedependsonmymood();
        waitUntil("How does that make you feel?");
        response("input12");
        waitUntil("restlessness and agitation as well?");
        yeah();
        //notreallysure();
        waitUntil("Does this resonate with you?");
        ummyeah();
        //maybeidk();
        waitUntil("explain the connection");
        introvert();
        //extrovert();

        waitUntil("Does it seem familiar?");
        YES();
        //UmmMaybe();
        waitUntil("sustain your enthusiasm over time?");
        thatdoessoundlikeme();
        //maybenotreallysure();
        waitUntil(" Does it ring any bell?");
        yesitsallclearnow();
        //ithinkiamconfused();
        waitUntil("Alright. Do you tend to do any of the following behaviours?");
        //devaluetheloss();
        //takeadefeatiststand();
        //refusetoadmittobeingsad();
        //calloncharminganddistracting();
        noneoftheabove();
        waitUntil("Are you with me so far?");
        yeahiseemtogetit();
        //ahitssoconfusing();
        feedbackPathway();
        System.out.println("Session 2 Ends");
        driver.navigate().refresh();
        System.out.println("Session 3 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input13");
        waitUntil("Have you heard about them before?");
        response("input14");
        waitUntil("If I were to ask you, who/what do you turn to in those times?");
        iindulgeinselfharm();
        //iresortofsubstanceconsumption();
        //isolatemyself();
        //icryandletitout();
        //ifeelfrustratedandgetaggressive();
        //iindulgeinriskybehaviors();
        //ibinge();
        //ireadorwatch();
        waitUntil("Would you like to know more about it?");
        //TC
        String expectedResult = "Yes";
        //String expectedResult ="No";
        if (expectedResult.equals("Yes")) {
            yesiwouldoveto();
            waitUntil("shrinking into yourself");
            yesalways();
            //sometimes();
            waitUntil("Do you also tend to feel guilty and frustrated at your self?");
            yesallthetime();
            //notsuremaybe();
            waitUntil("through a flight reaction?");
            response("input15");
            waitUntil("causes and consequences?");
            yesallthedamntime();
            //MaybeSometimes();
            waitUntil("Does this make sense to you?");
            yeahtotally();
            //maybeihavetothink();
            waitUntil("What do you have to say about this perspective?");
            thisisnewiamshock();
            //ineverthoughtthisway();
        } else if (expectedResult.equals("No")) {
            noiknowitalready();
        } else {
            System.out.println("Invalid Option");
        }

        waitUntil("romanticize it at all");
        String expectedResult2 = "Yeah";
        //String expectedResult2 = "i can fly";
        if (expectedResult2.equals("Yeah")) {
            yeah();
        } else if (expectedResult2.equals("i can fly")) {
            icanfly(); // ----> redirect to self harm
            waitUntil("Select a country to get the helpline numbers");

        } else {
            System.out.println("Invalid Option");
        }
        immediatedecision();
        //thingspersonally();
        //givereasons();
        //compareyourself();
       //viewthings();
        //trytoassume();
        //singlepositive();
        //highlyoverestimate();
        //positiveaspects();
        //thatyoudeserve();
        //noneoftheabove();
        waitUntil("irrational thinking patterns that");
        yestheyalwaysdo();
        //MaybeSometimes();
        feedbackPathway();
        System.out.println("Session 3 Ends");
        driver.navigate().refresh();
        System.out.println("Session 4 Ends");



    }


}





















