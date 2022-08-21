import Pages.AboutUsPage;
import Pages.HomePage;
import Pages.JobsPage;
import Utils.UseCaseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Stream;

import static Const.Const.*;
import static org.junit.jupiter.api.Assertions.*;

public class JobsPageTest extends UseCaseBase {

    private static HomePage homePage;
    private static JobsPage jobsPage;


    @BeforeAll
    public static void classSetup() {
        homePage = new HomePage();
        jobsPage = new JobsPage();
        //чтобы открывать динамично страницы, убираем отсюда jobsPage = new JobsPage(); и корректируем в тесте тоже

    }

    @BeforeEach
    public void beforeTest() {
        homePage.navigateToHomePage();

    }

    @Test
    public void isJobsPageIsOpened() {
        jobsPage.openJobsPage();
      //  jobsPage = JobsPage.openJobsPage();
        //  так правильнее если много страниц, еще меняем на static в JobPage openJobPage();
        Assertions.assertEquals(JOBS_PAGE, jobsPage.isPageLoaded());
    }

    @Test
    public void isLogoVisible() throws IOException {
        boolean isVisible = jobsPage.openJobsPage().isFilterOnTheScreen();
        assertTrue(isVisible);
    }

    @Test
    public void logsTest() {
        List<LogEntry> logs = jobsPage.logs();

        for (LogEntry e : logs) {
            System.out.println("Message: " + e.getMessage());
            System.out.println("level: " + e.getLevel());
            Assertions.assertNotEquals(Level.SEVERE, e.getLevel());
        }

    }

    @Test
    public void searchToronto() throws IOException, InterruptedException {
        //jobsPage = JobsPage.openJobsPage();
        jobsPage.openJobsPage().sendLocation("Toronto").clickSearchButton();
        jobsPage.sendLocation("Toronto").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isTorontoOnTheScreen();
        assertTrue(isOnScreen);

    }

    @Test
    public void searchTelAviv() throws IOException {
        boolean isOnScreen = jobsPage.openJobsPage().sendLocation("Tel Aviv").clickSearchButton().isTelAvivOnTheScreen();
        assertTrue(isOnScreen);
    }

    @Test
    public void searchChicago() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("Chicago").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isChicagoOnTheScreen();
        assertTrue(isOnScreen);
    }

    @Test
    public void searchNewYork() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("New York").clickSearchButton();
        Thread.sleep(10000);
        boolean isOnScreen = jobsPage.isNewYorkOnTheScreen();
        assertTrue(isOnScreen);
    }

    static Stream<Arguments> dataProvider() {

        return Stream.of(
                Arguments.of("QA", "//*[text()='#4068- QA Manual Engineer']"),
                Arguments.of("Developer", "//*[text()='Senior Full Stack Developer']"),
                Arguments.of("Project Manager", "//*[text()='Project Manager']")
        );
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    public void searchPositionTest(String position, String element) throws InterruptedException {
        jobsPage.openJobsPage().sendPosition(position);
        Thread.sleep(10000);
        jobsPage.clickSearchButton();
      //  Thread.sleep(10000);
        boolean isPositionOnScreen = jobsPage.isPositionOnScreen(element);
        assertTrue(isPositionOnScreen);
    }

    @Test
    public void searchCompanyAppleTest() {
        jobsPage.openJobsPage().sendCompany("Apple").clickSearchButton();
        boolean isAppleOnScreen = jobsPage.isCompanyOnScreen(APPLE);
        assertTrue(isAppleOnScreen);
    }

    @Test
    public void searchCompanyFacebookTest() {
        jobsPage.openJobsPage().sendCompany("Facebook").clickSearchButton();
        boolean isOnScreen = jobsPage.isCompanyOnScreen(FACEBOOK);
        assertTrue(isOnScreen);
    }
    @Test
    public void searchCompanyGoogleTest() {
        jobsPage.openJobsPage().sendCompany("Google").clickSearchButton();
        boolean isOnScreen = jobsPage.isCompanyOnScreen(GOOGLE);
        assertTrue(isOnScreen);
}
@Test
    public void combinedSearchTest() throws IOException, InterruptedException {
        jobsPage.openJobsPage().sendLocation("USA").sendCompany("Google").clickSearchButton();
    Thread.sleep(10000);
        boolean onScreen = jobsPage.isCombinedSearchOnTheScreen();
        assertTrue(onScreen);
}
@Test
    public void abracadabraTest() throws InterruptedException {
    jobsPage.openJobsPage().sendPosition("abracadabra").clickSearchButton();
    assertNotNull(jobsPage.isExist());
    Thread.sleep(1000);
    assertNotNull(jobsPage.catchError());
}
@Test
    public void resetTest() throws InterruptedException, IOException {
        jobsPage.openJobsPage().sendPosition("Developer").sendLocation("Toronto").sendCompany("Google");
        //я разделила, потому что в одну строку очень длинно
        jobsPage.clickSearchButton();
    Thread.sleep(1000);
    jobsPage.clickResetButton();
    assertTrue(jobsPage.isFilterOnTheScreen());


}
}