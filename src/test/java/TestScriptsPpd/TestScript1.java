package TestScriptsPpd;

import BasePpdClass.BaseTestPpd;
import generics.map;
import org.testng.annotations.Test;

public class TestScript1 extends BaseTestPpd {
    @Test
    public void chatBotInteraction() {
        map.addDataIntoMap("credentials");
        response("name");
        waitingFor(".//span[text()='Yes']");
        yesText();
        waitUntil("health practitioner");
        yeahWithText();
        waitingFor(".//button[@title=\"Depression\"]");
        others();
        System.out.println("Others Option Selected");
        waitUntil("Please specify");
        map.addDataIntoMap("ppdpathway");
        response("input1");
        waitUntil("physical health conditions you are");
        hypertension();
        waitUntil("loss of loved one");
        response("input2");
        waitUntil("your mistrust of others");
        response("input3");
        waitUntil("interpersonal relationships");
        response("input4");
        waitUntil("suspicion or anxiety");
        response("input5");
        waitUntil("challenging beliefs");
        response("input6");
        waitUntil("Was this helpful?");
        yes();
        waitUntil("When you thought the bot will make you feel relaxed but instead starts asking uncomfortable questions");
        response("input7");
        waitUntil("volunteering");
        response("input8");
        waitUntil("positive mindset");
        response("input9");
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
        System.out.println("PPD Pathway Starts");
        waitUntil("Is your experience similar?");
        response("input10");
        waitUntil("harming or deceiving");
        response("input11");
        waitUntil("Do you have a similar experience?");
        //TC===========================================================
        String expectedResult = "Yes";
        //String expectedResult = "No";
        if (expectedResult.equals("Yes")) {
            yes();
        } else if (expectedResult.equals("No")) {
            no();
        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("suspicion many things get difficult");
        //TC=========================================================
        String expectedResponse = "Not being able to make friends";
        //String expectedResponse = "Not being able to trust and confide in people";
        //String expectedResponse = "Not being able to forgive people after conflicts";
        //String expectedResponse = "None of these";
        if (expectedResponse.equals("Not being able to make friends")) {
            notbeingabletomakefriends();
            waitUntil("particular difficulty of yours");
            response("input12");
        } else if (expectedResponse.equals("Not being able to trust and confide in people")) {
            notbeingabletotrustandconfideinpeople();
            waitUntil("particular difficulty of yours");
            response("input13");

        } else if (expectedResponse.equals("Not being able to forgive people after conflicts")) {
            notbeingabletoforgivepeopleafterconflicts();
            waitUntil("particular difficulty of yours");
            response("input14");

        } else if (expectedResponse.equals("None of these")) {
            noneofthese();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("Lastly, all these experiences are distressing");
        response("input15");
        waitUntil("So, have you heard of “projection”");
        response("input16");
        waitUntil("Could this be a possibility?");
        response("input17");
        waitUntil("first time when you started projection?");
        response("input18");
        waitUntil("genetic and what do childhood");
        response("input19");
        waitUntil("I hope you are with me till now.");
        response("input20");
        waitUntil("only way to heal is to explore every possibility");
        response("input21");
        waitUntil("genetic or nature part of PPD");
        //TC====================================
        String expectedResponse2 = "Yes";
        //String expectedResponse2 = "No";
        if (expectedResponse2.equals("Yes")) {
            yes();

        } else if (expectedResponse2.equals("No")) {
            no();

        } else {
            System.out.println("Invalid Option");
        }
        //TC===================================================
        waitUntil("Would you like to know more details about it?");
        String expectedResponse3 = "Yes";
        //String expectedResponse3 ="No";
        if (expectedResponse3.equals("Yes")) {
            yes();

        } else if (expectedResponse3.equals("No")) {
            no();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("Also, did you know?");
        //TC
        String expectedResponse4 = "BPD";
        //String expectedResponse4 = "Narcissistic Personality Disorder";
        //String expectedResponse4 = "Antisocial Personality Disorder";
        //String expectedResponse4 = "Substance abuse problems";
        //String expectedResponse4 = "Panic disorder";
        //String expectedResponse4 = "OCD";
        //String expectedResponse4 = "Depression";
        //String expectedResponse4 = "Anxiety";
        //String expectedResponse4 = "None of these";
        if (expectedResponse4.equals("BPD")) {
            BPD();
        } else if (expectedResponse4.equals("Narcissistic Personality Disorder")) {
            narcissisticpersonalitydisorder();
        } else if (expectedResponse4.equals("Antisocial Personality Disorder")) {
            antisocialpersonalitydisorder();
        } else if (expectedResponse4.equals("Substance abuse problems")) {
            substanceabuseproblems();
        } else if (expectedResponse4.equals("Panic disorder")) {
            panicdisorder();
        } else if (expectedResponse4.equals("OCD")) {
            OCD();
        } else if (expectedResponse4.equals("Depression")) {
            Depression();
        } else if (expectedResponse4.equals("Anxiety")) {
            Anxiety();
        } else if (expectedResponse4.equals("None of these")) {
            noneofthese();
        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("Let me know which one you would");
        //TC
        String expectedResponse5 = "Keep a diary";
        //String expectedResponse5 = "None of these";
        if (expectedResponse5.equals("Keep a diary")) {
            keepadiary();
            waitUntil("Is there any other strategy you would like to explore ?");
            yes();
            waitingFor("(.//p[contains(text(),'Let me know which one you would')])[2]");
            questionandchallengeyourparanoidthoughts();
            waitingFor("(.//p[contains(text(),'Is there any other strategy ')])[2]");
            yes();
            waitingFor("(.//p[contains(text(),'So, as we wind up our session')])[3]");
            doasmallthoughtexperimenteveryday();
            feedbackPathway();
        } else if (expectedResponse5.equals("None of these")) {
            feedbackPathway();
        } else {
            System.out.println("Invalid Option");
        }
        System.out.println("Session one ends");
        //driver.navigate().refresh();
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input22");
        waitUntil("So, is your experience the same?");
        response("input23");
        waitUntil("Did you have any similar experience?");
        response("input24");
        waitUntil("So, moving on I have a few experiences that may contribute to trauma, let me know if you had any?");
        //TC
        String expectedResponse6 = "Over-protectiveness and low parental care or affectionless control";
        //String expectedResponse = "Parents preventing independent behaviour";
        //String expectedResponse = "Parents being emotionally cold, neglectful, and indifferent";
        //String expectedResponse = "Parents were paranoid themselves";
        //String expectedResponse = "Your parents were strict and intolerant about certain things and tried to shame you";
        //String expectedResponse = "Physical, emotional, and sexual abuse";
        //String expectedResponse = "Parents were dealing with their mental health issues";
        //String expectedResponse = "None of these";
        if (expectedResponse6.equals("Over-protectiveness and low parental care or affectionless control")) {
            overprotectivenessandlowparental();

        } else if (expectedResponse6.equals("Parents preventing independent behaviour")) {
            parentspreventingindependentbehaviour();

        } else if (expectedResponse6.equals("Parents being emotionally cold, neglectful, and indifferent")) {
            parentsbeingemotionallycold();

        } else if (expectedResponse6.equals("Parents were paranoid themselves")) {
            parentswereparanoidthemselves();

        } else if (expectedResponse6.equals("Your parents were strict and intolerant about certain things and tried to shame you")) {
            yourparentswerestrictandintolerant();

        } else if (expectedResponse6.equals("Physical, emotional, and sexual abuse")) {
            physicalemotionalandsexualabuse();

        } else if (expectedResponse6.equals("Parents were dealing with their mental health issues")) {
            parentsweredealingwiththeirmentalissues();

        } else if (expectedResponse6.equals("None of these")) {
            noneofthese();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("For this I have a list,");
        //TC
        String expectedResponse7 = "Arguments";
        //String expectedResponse7 = "Verbal Stress";
        //String expectedResponse7 = "Emotional Stress";
        //String expectedResponse7 = "Chaos in the home environment";
        //String expectedResponse7 = "Alcoholism";
        //String expectedResponse7 = "Drug Addiction";
        //String expectedResponse7 = "Guilt";
        //String expectedResponse7 = "Shame";
        //String expectedResponse7 = "Physical Abuse";
        //String expectedResponse7 = "Poor Health";
        //String expectedResponse7 = "Neglect";
        //String expectedResponse7 = "None of these";
        if (expectedResponse7.equals("Arguments")) {
            arguments();

        } else if (expectedResponse7.equals("Verbal Stress")) {
            verbalstress();

        } else if (expectedResponse7.equals("Emotional Stress")) {
            emotionalstress();

        } else if (expectedResponse7.equals("Chaos in the home environment")) {
            chaosinthehome();

        } else if (expectedResponse7.equals("Alcoholism")) {
            alcoholism();

        } else if (expectedResponse7.equals("Drug Addiction")) {
            drugaddiction();

        } else if (expectedResponse7.equals("Guilt")) {
            guilt();

        } else if (expectedResponse7.equals("Shame")) {
            shame();

        } else if (expectedResponse7.equals("Physical Abuse")) {
            physicalabuse();

        } else if (expectedResponse7.equals("Poor Health")) {
            poorhealth();

        } else if (expectedResponse7.equals("Neglect")) {
            neglect();

        } else if (expectedResponse7.equals("None of these")) {
            noneofthese();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("clicked or brought some insight?");
        //TC
        String expectedResponse8 = "Yes";
        //String expectedResponse8 = "No";

        if (expectedResponse8.equals("Yes")) {
            yes();
            waitUntil("Alright! Let me know, I am all ears !!");
            response("input25");

        } else if (expectedResponse8.equals("No")) {
            no();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("So, what do you think that your attachment style could be?");
        response("input26");
        waitUntil("Let me know if you can identify any?");
        //TC
        String expectedResponse9 = "Fear or being avoidant to commitments (social, personal, academic, occupational)";
        //String expectedResponse9 = "Feelings of insecurity, lacking in everyday interactions";
        //String expectedResponse9 = "Feelings that friends, family, colleagues or partners will leave you hanging or vulnerable at a crucial moment";
        //String expectedResponse9 = "Predisposition or discrimination against people that seem “untrustworthy.”";
        //String expectedResponse9 = "Fear of exploring new activities, friendships, business opportunities Positive feedback is always handled with scepticism";
        //String expectedResponse9 = "Afraid of taking risks, however big or small";
        //String expectedResponse9 = "Feeling guilty when a person trusts you and put a lot of effort to not let them down";
        //String expectedResponse9 = "None of these";
        if (expectedResponse9.equals("Fear or being avoidant to commitments (social, personal, academic, occupational)")) {
            fearorbeingavoidant();

        } else if (expectedResponse9.equals("Feelings of insecurity, lacking in everyday interactions")) {
            feelingsofinsecurity();

        } else if (expectedResponse9.equals("Feelings that friends, family, colleagues or partners will leave you hanging or vulnerable at a crucial moment")) {
            feelingsthatfriendsfamily();

        } else if (expectedResponse9.equals("Predisposition or discrimination against people that seem “untrustworthy.”")) {
            predispositionordiscrimination();

        } else if (expectedResponse9.equals("Fear of exploring new activities, friendships, business opportunities Positive feedback is always handled with scepticism")) {
            fearofexploringnewactivities();

        } else if (expectedResponse9.equals("Afraid of taking risks, however big or small")) {
            afraidoftakingrisks();

        } else if (expectedResponse9.equals("Feeling guilty when a person trusts you and put a lot of effort to not let them down")) {
            feelinguiltywhenapersontrust();

        } else if (expectedResponse9.equals("None of these")) {
            noneofthese();

        } else {
            System.out.println("Invalid Option");
        }

        waitUntil("Do you feel like that is the case with you");
        //TC
        String expectedResponse10 = "Yes, i cannot seem to remember but i have a feeling that something like this happened.";
        //String expectedResponse10 = "No, I remember and there was no betrayal like this in my life";
        if (expectedResponse10.equals("Yes, i cannot seem to remember but i have a feeling that something like this happened.")) {
            yesicannotseemtoremember();

        } else if (expectedResponse10.equals("No, I remember and there was no betrayal like this in my life")) {
            noirememberandtherewasnobetrayal();

        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("have a different viewpoint");
        response("input27");
        waitUntil("fear of yet another betrayal");
        response("input28");
        waitingFor("(.//p[contains(text(),'Let me know which one you would like to explore first?')])[4]");
        //TC
        String expectedResponse11 = "Acknowledge instead of avoiding";
        //String expectedResponse11 = "Practice accepting difficult emotions";
        //String expectedResponse11 = "Turn to others (those you trust) for support";
        //String expectedResponse11 = "Use your body to process fear and related emotions";

        //String expectedResponse11 = "None of these";
        if (expectedResponse11.equals("Acknowledge instead of avoiding")) {
            acknowledgeinsteadofavoiding();
            waitingFor("(.//p[contains(text(),'Is there any other strategy you would like to explore ?')])");
            yes();
            waitingFor("(.//p[contains(text(),'you would like to explore first?')])[5]");
            button("(.//button[@title='Practice accepting difficult emotions'])[2]");
            //practiceacceptingdifficultemotions();
            waitingFor("(.//p[contains(text(),'is any other strategy')])[2]");
            yes();
            waitingFor("(.//p[contains(text(),'Let me know which one you would like to explore first?')])[6]");
            //turntoothersforsupport();
            button("(.//button[@title='Turn to others (those you trust) for support'])[3]");
            waitingFor("(.//p[contains(text(),'any other strategy you would like to explore ?')])[5]");
            yes();
            waitingFor("(.//p[contains(text(),'Let me know which one you would like to explore first?')])[7]");
            //useyourbodytoprocess();
            button("(.//button[@title='Use your body to process fear and related emotions'])[4]");
            feedbackPathway();
        } else if (expectedResponse11.equals("None of these")) {
            feedbackPathway();
        } else {
            System.out.println("Invalid Option");
        }
        System.out.println("Session 2 ends");

        driver.navigate().refresh();
        System.out.println("Session 3 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input29");
        waitUntil("helpless child would choose or can choose");
        response("input30");

        //TC
        String expectedResponse12 = "Yes, exactly.";
        //String expectedResponse12 = "I know about this but i would like to learn more.";

        if (expectedResponse12.equals("Yes, exactly.")) {
            yesexactly();

        } else if (expectedResponse12.equals("I know about this but i would like to learn more.")) {
            iknowaboutthisbutiwouldliketolearnmore();
        } else {
            System.out.println("Invalid Option");
        }

        waitUntil("why risk trusting others");
        response("input31");
        waitUntil("conclusion/suspicion");
        response("input32");
        waitUntil("There are other ways as well");

        //TC
        String expectedResponse13 = "Practise positive visualisation";
        //String expectedResponse13 = "None of these";

        if (expectedResponse13.equals("Practise positive visualisation")) {
            practisepositivevisualisation();
            waitUntil("if there is any other strategy");
            yes();
            waitingFor("(.//p[contains(text(),'There are other')])[2]");
            button("(.//button[@title='Review habits and routines with potential triggers in mind'])[2]");
            feedbackPathway();
            System.out.println("Session 3 ends");

        } else if (expectedResponse13.equals("None of these")) {
            noneofthese();

        } else {
            System.out.println("Invalid Option");
        }

        driver.navigate().refresh();
        System.out.println("Session 4 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input33");
        waitUntil("could be another disorder as well?");

        //TC - main yes no --- YES
        String expectedResponse14 = "Yes";
        //String expectedResponse14 = "No";

        if (expectedResponse14.equals("Yes")) { //----------------> yes ask directly for options
            yes();
            waitUntil("particular experience of PPD below:");

            //TC - copy
            String expectedResponse15 = "Your worries or fantasies are more concerned about achievement, grace, and self- image.";
            //String expectedResponse15 = "Your worries or fantasies are more concerned about others hurting you or be at the receiving end of others hate and aggression.";
            //String expectedResponse15 = "Your worries or fantasies are more concerned about your freedom and control.";
            //String expectedResponse15 = "Your worries or fantasies are more concerned about others cheating on you or jealousy.";
            //String expectedResponse15 = "Your worries or fantasies are more concerned about rejecting you and you fear others judgement of you.";
            if (expectedResponse15.equals("Your worries or fantasies are more concerned about achievement, grace, and self- image.")) {
                moreconcernedaboutachievement();
                waitUntil("Would you like to explore that?");
                //TC -- inner
                String expectedYes = "Yes";
                //String expectedYes ="No";
                if (expectedYes.equals("Yes")) {
                    yes();

                } else if (expectedYes.equals("No")) {
                    no();
                }

            } else if (expectedResponse15.equals("Your worries or fantasies are more concerned about others hurting you or be at the receiving end of others hate and aggression.")) {
                moreconcernedaboutothershurtingyou();
                waitUntil("Would you like to explore that?");
                //TC -- inner
                String expectedYes1 = "Yes";
                //String expectedYes1 ="No";
                if (expectedYes1.equals("Yes")) {
                    yes();

                } else if (expectedYes1.equals("No")) {
                    no();
                }

            } else if (expectedResponse15.equals("Your worries or fantasies are more concerned about your freedom and control.")) {
                moreconcernedaboutotherscheating();
                waitUntil("Would you like to explore that?");
                //TC -- inner
                String expectedYes2 = "Yes";
                //String expectedYes2 ="No";
                if (expectedYes2.equals("Yes")) {
                    yes();

                } else if (expectedYes2.equals("No")) {
                    no();
                }

            } else if (expectedResponse15.equals("Your worries or fantasies are more concerned about others cheating on you or jealousy.")) {
                moreconcernedaboutotherscheating();

            } else if (expectedResponse15.equals("Your worries or fantasies are more concerned about rejecting you and you fear others judgement of you.")) {
                moreconcernedaboutrejectingyou();

            } else {
                System.out.println("Invalid Option");
            }

            //main yes no -- no=============
        } else if (expectedResponse14.equals("No")) { // ------> again ask for yes no
            no();
            waitUntil("features of other disorders as well");
            String expectedResponse16 = "Yes";
            //String expectedResponse16 = "No";
            if (expectedResponse16.equals("Yes")) { // ------> yes then ask for the options
                yes();
                waitUntil("particular experience of PPD below:");
                //when needed TC - copy

            } else if (expectedResponse16.equals("No")) { //------> completely no directly to feedback
                no();
                feedbackPathway();
            }
        } else {
            System.out.println("Invalid Option");
        }
        waitUntil("So, could you relate to what I shared just now in any way?");
        response("input34");
        waitUntil("On this note, how will you describe your parents/caretakers?");
        response("input35");
        waitUntil("theories in your real-life problem?");
        response("input36");
        waitUntil("about parts work?");

        //TC
        String expectedResponse17 = "Yes, sure.";
        //String expectedResponse17 = "No, maybe later.";

        if (expectedResponse17.equals("Yes, sure.")) {
            yessure();

        } else if (expectedResponse17.equals("No, maybe later.")) {
            nomaybelater();

        } else {
            System.out.println("Invalid Option");
        }
        feedbackPathway();
        System.out.println("Session 4 Ends");
        driver.navigate().refresh();
        System.out.println("Session 5 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input37");
        waitUntil("May be independent or powerful");
        response("input38");
        waitUntil("still be socially functional?");
        response("input39");

        //TC
        String expectedResponse18 = "Yes";
        //String expectedResponse18 = "No";
        if (expectedResponse18.equals("Yes")){
            yes();
            waitUntil("Would you like to share about them with me?");
            response("input40");

        } else if (expectedResponse18.equals("No")) {
            no();

        }

        waitUntil("And moving on, what about romantic relationships, do you have one?");

        //TC
        String expectedResponse19 = "Yes";
        //String expectedResponse19 = "No";
        if (expectedResponse19.equals("Yes")){
            yes();
            waitUntil("Great! Would you like to share it with me?");
            response("input41");

        } else if (expectedResponse19.equals("No")) {
            no();

        }

        waitUntil("Let me know if your partner has said things which describe you as:");

        //TC -----> Multiple Options but single way
        String expectedResponse20 = "Cold and rational";
        //String expectedResponse20 = "Reluctant to share emotions";
        //String expectedResponse20 = "Intolerant of intimacy";
        //String expectedResponse20 = "Secretive without good reason";
        //String expectedResponse20 = "Overcontrolling, insecure, mistrustful of family and close friends";
        //String expectedResponse20 = "Hypersensitive to criticism";
        //String expectedResponse20 = "Unwilling to negotiate conflict";
        //String expectedResponse20 = "Quick to make harsh judgments";
        //String expectedResponse20 = "Incredibly jealous";
        //String expectedResponse20 = "None of these";

        if (expectedResponse20.equals("Cold and rational")){
          coldandrational();

        } else if (expectedResponse20.equals("None of these")) {
            noneofthese();


        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("not a “real” insecurity? Any ideas?");
        response("input42");
        waitUntil("To further explain, let me know if you have any siblings?");

        //TC ---- > for every session different class
        String expectedResponse21 = "Yes";
        //String expectedResponse21 = "No";

        if (expectedResponse21.equals("Yes")){
            yes();

        } else if (expectedResponse21.equals("No")) {
            no();

        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("mentalisation. Do you have any idea what it is?");
        response("input43");
        feedbackPathway();
        System.out.println("Session 5 Ends");
        driver.navigate().refresh();
        System.out.println("Session 6 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input44");
        waitUntil("had the highest self-esteem?");
        response("input45");
        waitUntil("Maslow’s hierarchy of needs?");

        //TC
        String expectedResponse22 ="Yes, I have";

        //String expectedResponse22 = "No";

        if (expectedResponse22.equals("Yes, I have")){
            yesihave();
        } else if (expectedResponse22.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("remarkably like the chakra");

        //TC
        String expectedResponse23 = "Yes";
        //String expectedResponse23 = "No";

        if (expectedResponse23.equals("Yes")){
            yes();
        }else if (expectedResponse23.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("let me know what you understand by chakras");
        response("input46");
        waitUntil("pros and cons");
        response("input47");
        waitUntil("it cause more suffering?");
        response("input48");
        waitUntil("So, would you like to explore how to do that?");
        //TC
        String expectedResponse24 = "Yes";
        //String expectedResponse24 = "No";

        if (expectedResponse24.equals("Yes")){
            yes();
        }else if (expectedResponse24.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        feedbackPathway();
        System.out.println("Session 6 Ends");
        driver.navigate().refresh();
        System.out.println("Session 7 Starts");
        waitUntil("How was your experience with the exercise");
        ienjoyeddoingthem();
        waitUntil("Is there some other feedback");
        response("input49");
        waitUntil("Recently metacognitive");
        //TC
        String expectedResponse25 = "Yes";
        //String expectedResponse25 = "No";

        if (expectedResponse25.equals("Yes")){
            yes();
        }else if (expectedResponse25.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("behavioural therapy will help you with this?");

        //TC
        String expectedResponse26 = "Yes";
        //String expectedResponse26 = "No";

        if (expectedResponse26.equals("Yes")){
            yes();
        }else if (expectedResponse26.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("therapy can help you with that?");
        //TC
        String expectedResponse27 = "Yes";
        //String expectedResponse27 = "No";

        if (expectedResponse27.equals("Yes")){
            yes();
        }else if (expectedResponse27.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }
        waitUntil("what all options are there in somatic therapies?");
        //TC
        String expectedResponse28 = "Yes";
        //String expectedResponse28 = "No";

        if (expectedResponse28.equals("Yes")){
            yes();
        }else if (expectedResponse28.equals("No")) {
            no();
        }else {
            System.out.println("Invalid Option");
        }

        feedbackPathway();
        System.out.println("Session 7 Ends");







    }

}

