import Const.Const;
import Pages.BasePage;
import Pages.HomePage;
import Utils.UseCaseBase;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import static Const.Const.HOME_PAGE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest extends UseCaseBase {
    private static HomePage homePage;

    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();

    }

    @Test
    public void isHomePageLoaded() {
        assertEquals(HOME_PAGE, homePage.isPageLoaded());
    }

    @Test
    public void isLogoVisible() {
        boolean isVisible = homePage.isLogoVisible();
        assertTrue(isVisible);

    }

    @Test
    public void isImgOnTheScreen() throws IOException {
        boolean isOnScreen = homePage.isImageOnTheScreen();
        assertTrue(isOnScreen);

    }

    @Test
    public void isImgRightSize() {
        int h = homePage.getImage().getRect().getDimension().getHeight();
        int w = homePage.getImage().getRect().getDimension().getWidth();
        System.out.println(h + "x" + w);
        assertEquals(356, h);
        assertEquals(336, w);
    }

    @Test
    public void logsTest() {
        List<LogEntry> logs = homePage.logs();

        for (LogEntry e : logs) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }

    }
}