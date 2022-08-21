import Pages.AboutUsPage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;
import java.util.logging.Level;

import static Const.Const.ABOUT_US_PAGE;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AboutUsPageTest extends UseCaseBase {

    private static HomePage homePage;
    private static AboutUsPage aboutUsPage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
      //  aboutUsPage = new AboutUsPage();

    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();

    }
@Test
    public void isAboutPageIsOpened(){
     //   aboutUsPage.openAboutUsPage();
    aboutUsPage = AboutUsPage.openAboutUsPage();
    Assertions.assertEquals(ABOUT_US_PAGE, aboutUsPage.checkIfAboutUsOpened());
}
@Test
public void isLogoVisible() {
    boolean isVisible = aboutUsPage.openAboutUsPage().isLogoVisible();
    assertTrue(isVisible);
}
    @Test
    public void logsTest() {
        List<LogEntry> logs = aboutUsPage.logs();

        for (LogEntry e : logs) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }

}}