package Pages;

import Const.Const;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.logging.LogEntry;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JobsPage extends BasePage {

    private static final String SEARCH_FILTER = "//*[@class = 'sidebar']";
    private static final String JOBS = "//*[@href='/job-page']";
    private static final String LOCATION_FIELD = "//input[@name='location']";
    private static final String POSITION_FIELD = "//input[@class='serch-input']";
    private static final String COMPANY_FIELD = "//input[@name='company']";
    private static final String SEARCH_BUTTON = "//button[@class='search-butom']";
    private static final String JOBS_PAGE = "//*[@class='jobs']";
    private static final String TORONTO = "//*[text()='Toronto, ON, Canada']";
    private static final String TEL_AVIV = "//*[text()='Tel Aviv-Yafo, Israel']";
    private static final String CHICAGO = "//*[text()='Chicago, IL, USA']";
    private static final String NewYork = "//*[text()='New York, NY, USA']";
    private static final String ErrorMess = "//*[text()='No results found!']";
    private static final String RESET_BUTTON = "//*[text()='reset']";


    public void navigateToJobsPage() {
        webDriver.get(Const.JOBS_PAGE);

    }

    public JobsPage openJobsPage() {
        clickElementByXpath(JOBS);
        return new JobsPage();
    }

    public String isPageLoaded() {
        String actualURL = getCurrentPageUrl();

        return actualURL;
    }


    public boolean isFilterOnTheScreen() throws IOException {
        File file = captureImage(SEARCH_FILTER).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("filter.png"));
        boolean isOnScreen = elementExists(SEARCH_FILTER);
        return isOnScreen;

    }


    public static List logs() {
        List<LogEntry> logs = BasePage.getLogs().getAll();
        return logs;

    }

    public JobsPage sendLocation(String text) {
        sendTextToElementByXpath(LOCATION_FIELD, text);
        return new JobsPage();
    }
    public JobsPage sendPosition(String text) {
        sendTextToElementByXpath(POSITION_FIELD, text);
        return new JobsPage();
    }
    public JobsPage sendCompany(String text) {
        sendTextToElementByXpath(COMPANY_FIELD, text);
        return new JobsPage();}

    public JobsPage clickSearchButton() {
        clickElementByXpath(SEARCH_BUTTON);
        return new JobsPage();
    }
    public JobsPage clickResetButton() {
        clickElementByXpath(RESET_BUTTON);
        return new JobsPage();
    }
    public boolean isTorontoOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("toronto.png"));
        boolean isOnScreen = elementExists(TORONTO);
        return isOnScreen;

    }

    public boolean isTelAvivOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("tel_aviv.png"));
        boolean isOnScreen = elementExists(TEL_AVIV);
        return isOnScreen;
    }

    public boolean isChicagoOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("chicago.png"));
        boolean isOnScreen = elementExists(CHICAGO);
        return isOnScreen;
    }

    public boolean isNewYorkOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("new_york.png"));
        boolean isOnScreen = elementExists(NewYork);
        return isOnScreen;
    }
    public boolean isPositionOnScreen(String element)  {
        boolean isOnScreen = elementExists(element);
        return isOnScreen;
}
    public boolean isCompanyOnScreen(String company)  {
        boolean isOnScreen = elementExists(company);
        return isOnScreen;
}
    public boolean isCombinedSearchOnTheScreen() throws IOException {
        File file = captureImage(JOBS_PAGE).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("combined_search.png"));
        boolean isOnScreen = elementExists(NewYork);
        return isOnScreen;
}
public boolean isExist(){
        boolean ifExist = elementExists(POSITION_FIELD);
        return ifExist;

    }
public boolean catchError(){
        boolean error = elementExists(ErrorMess);
        return error;
}
}