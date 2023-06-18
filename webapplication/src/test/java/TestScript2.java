import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;


public class TestScript2 extends ContactUsPage {

    @Test
    public void contactUsTest(){
        test = extent.createTest("Contact Us Test");
        fillOutContactForm();
        submitContactForm();
        test.log(Status.PASS, "Contact Us Test executed successfully");
        String screenshotPath = captureScreenshot();
        logScreenshot(screenshotPath, "Contact Us Test");
    }
}
