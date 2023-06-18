
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;


public class TestScript1 extends BookASessionPage {
    @Test
    public void clickOnBookSession() {
        test = extent.createTest("Click on Book Session Test");
        fillOutBookSessionTest();
        test.log(Status.PASS, "Clicked on Book A Session");
        String screenshotPath = captureScreenshot();
        logScreenshot(screenshotPath, "Clicked on Book A Session");
    }
}
