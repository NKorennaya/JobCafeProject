package Pages;

import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class AboutUsPage extends BasePage {

    private static final String ABOUT_US = "//*[@name = 'About']";
    private static final String LOGO_ABOUT_US = "//*[@class = 'd-flex justify-content-between align-items-center']";

    public static AboutUsPage openAboutUsPage() {
        clickElementByXpath(ABOUT_US);
        return new AboutUsPage();
    }

    public String checkIfAboutUsOpened() {
        String actualURL = webDriver.getCurrentUrl();

        return actualURL;
    }

    public boolean isLogoVisible() {
        boolean isVisible = elementExists(LOGO_ABOUT_US);
        return isVisible;
    }

    public static List logs() {
        List<LogEntry> logs = BasePage.getLogs().getAll();
        return logs;
    }
}