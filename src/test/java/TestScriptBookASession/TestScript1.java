package TestScriptBookASession;
import bookASession.bookASession;
import org.testng.annotations.Test;

public class TestScript1 extends bookASession {
    @Test
    public void clickOnBookSession() {
        bookSession();
        fillName();
    }

}
